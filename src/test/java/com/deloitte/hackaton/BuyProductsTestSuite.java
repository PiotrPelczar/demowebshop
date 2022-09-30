package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.*;

public class BuyProductsTestSuite {

    WebDriver driver;


    @BeforeAll
    public static void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
    }


    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void buyAPhysicalGiftCard(JSONUserData userData) throws InterruptedException {
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        startNewCustomerInfoTest(driver, userData).openAddressPage();
        boolean isTrue = startNewCustomerInfoTest(driver, userData).verifyAddress();
        System.out.println(isTrue);
        if (!isTrue) {
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
                    .addAddress();
        }
        mainPage(driver, userData)
                .navigateToMainPage()
                .goToGiftCards()
                .locatePhisicalGiftCard100$()
                .provideInfoAndAddToCart()
                .selectUsersCountry()
                .acceptTerms()
                .goToCheckout()
                .clickThroughPaymentMethods()
                .confirm()
                .validateBillingInfo()
                .validateShippingInfo();
    }

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void buyACustomizableProduct(JSONUserData userData) throws InterruptedException {
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        startNewCustomerInfoTest(driver, userData).openAddressPage();
        boolean isTrue = startNewCustomerInfoTest(driver, userData).verifyAddress();
        System.out.println(isTrue);
        if (!isTrue == true) {
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
                    .addAddress();
        }
        mainPage(driver, userData)
                .navigateToMainPage()
                .searchForBlueAndGreenSneaker()
                .selectColor()
                .selectSize()
                .addToCart()
                .acceptTerms()
                .goToCheckout()
                .clickThroughPaymentMethods()
                .confirm()
                .validateShoesDetails()
                .validateBillingInfo()
                .validateShippingInfo();
    }


    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void buyANonCustomizableProduct(JSONUserData userData) throws InterruptedException {
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        startNewCustomerInfoTest(driver, userData).openAddressPage();
        boolean isTrue = startNewCustomerInfoTest(driver, userData).verifyAddress();
        System.out.println(isTrue);
        if (!isTrue == true) {
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
                    .addAddress();
        }
        mainPage(driver, userData)
                .navigateToMainPage()
                .searchFor14laptop()
                .laptop14inchAddToCart()
                .acceptTerms()
                .goToCheckout()
                .clickThroughPaymentMethods()
                .confirm()
                .validateBillingInfo()
                .validateShippingInfo();
    }



    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void buyAProductAsARegisteredUser(JSONUserData userData) {
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        startNewCustomerInfoTest(driver, userData).openAddressPage();
        boolean isTrue = startNewCustomerInfoTest(driver, userData).verifyAddress();
        System.out.println(isTrue);
        if (!isTrue == true) {
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
                    .addAddress();
        }
        mainPage(driver, userData)
                .navigateToMainPage();
    }

    private static Stream<JSONUserData> usersDataStream () {
        return JSONDataReader.readUsers().getUsers().stream();
    }
}





