package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.user.JSONUserData;
import com.deloitte.hackaton.data.user.UserDataRandomizer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.time.Duration;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.startNewLoginTest;
import static com.deloitte.hackaton.utils.TestFactory.startNewUserTest;

@ExtendWith(Screenshotter.class)
public class RegisterTestSuite {
    static WebDriver driver;
    @BeforeAll
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        Screenshotter.setDriver(driver);
    }

    @BeforeEach
    void setup(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    UserDataRandomizer userDataRandomizer;

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
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

    private static Stream<JSONUserData> usersDataStream() {
        return JSONDataReader.readRegisterUsers().getUsers().stream();
    }

}
