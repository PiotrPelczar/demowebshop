package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.user.JSONUserData;
import com.deloitte.hackaton.data.user.UserDataRandomizer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.*;
import static com.deloitte.hackaton.utils.TestFactory.startNewCustomerInfoTest;

public class UserDataDrivenTestSuite extends TestsSetup{

    UserDataRandomizer userDataRandomizer;

    @ParameterizedTest
    @MethodSource(value = "registerUsersDataStream")
    void register(JSONUserData userData) throws IOException {
        userDataRandomizer.getRandomUser();
        startNewUserTest(driver, userData)
                .openRegisterPage()
                .selectGender()
                .typeFirstName()
                .typeLastName()
                .typeEmail()
                .typePassword()
                .repeatPassword()
                .register()
                .verifyRegistration();
        startNewLoginTest(driver, userData)
                .logOut()
                .verifyIfLoggedOut();
    }

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void login(JSONUserData userData){
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin()
                .logOut()
                .verifyIfLoggedOut();
    }

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void addAndDeleteUserData(JSONUserData userData) throws InterruptedException{
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        startNewCustomerInfoTest(driver, userData).openAddressPage().deleteAllAddresses();
        Thread.sleep(1000);
        startNewCustomerInfoTest(driver, userData)
                .clickOnAddNewButton()
                .typeFirstName()
                .typeLastName()
                .typeEmail()
                .selectCountry()
                .typeCity()
                .typeAddress1()
                .typePostalCode()
                .typePhoneNumber()
                .addAddress()
                .verifyIfAdded();
    }

    private static Stream<JSONUserData> registerUsersDataStream() {
        return JSONDataReader.readRegisterUsers().getUsers().stream();
    }

    private static Stream<JSONUserData> usersDataStream() {
        return JSONDataReader.readUsers().getUsers().stream();
    }

}
