package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.user.JSONInvalidEmails;
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

import static com.deloitte.hackaton.utils.TestFactory.startNewNewsletterNegativeTest;

public class NewsletterNegativeTestSuite {

    WebDriver driver;

    @BeforeAll
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup(){
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));

    }

    @AfterEach
    void tearDown() {
        this.driver.quit();
    }



    @ParameterizedTest
    @MethodSource(value = "invalidEmailStream")
    void newsletterNegative(JSONInvalidEmails invalidEmails){
        startNewNewsletterNegativeTest(driver, invalidEmails)
                .openMainPage()
                .inputInvalidMail()
                .subscribe()
                .errorMessage();
    }

    private static Stream<JSONInvalidEmails> invalidEmailStream() {
        return JSONDataReader.readInvalidEmail().getInvalidEmails().stream();
    }

}

