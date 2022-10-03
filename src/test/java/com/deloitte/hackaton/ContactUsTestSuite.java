package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.*;

public class ContactUsTestSuite {
    WebDriver driver;

    @BeforeAll
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @AfterEach
    void tearDown(){
        this.driver.quit();
    }

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void contactUsNonLoginUser(JSONUserData userData){
        startNewContactUsFormNonLoginTest(driver, userData)
                .openMainPage()
                .openContactUsPage()
                .inputFullName()
                .inputEmail()
                .inputEnquire()
                .submit()
                .verifySubmitEnquiry();
    }

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void contactUsLoginUser(JSONUserData userData){
        startNewLoginTest(driver, userData)
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn();
        startNewContactUsFormLoginTest(driver, userData)
                .openContactUsPage()
                .verifyEmailInput()
                .verifyFullNameInput()
                .inputEnquire()
                .submit()
                .verifySubmitEnquiry();
    }
    private static Stream<JSONUserData> usersDataStream() {
        return JSONDataReader.readUsers().getUsers().stream();
    }

}