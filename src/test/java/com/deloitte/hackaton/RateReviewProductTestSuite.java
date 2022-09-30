package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.product.JSONProductData;
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

import static com.deloitte.hackaton.utils.TestFactory.startNewProductTest;
import static com.deloitte.hackaton.utils.TestFactory.startNewReviewProductTest;

public class RateReviewProductTestSuite {
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

    @AfterEach
    void tearDown() {
        this.driver.quit();
    }


    @ParameterizedTest
    @MethodSource("productsDataStream")
    void reviewsProduct(JSONProductData productData) throws InterruptedException {
        JSONUserData userData = JSONDataReader.readUsers().getUsers().get(0);
        startNewProductTest(driver, productData, userData)
                .login()
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn();

        startNewProductTest(driver, productData, userData)
                .openProductPage()
                .goToReviewPage();

        startNewReviewProductTest(driver, productData, userData)
                .findAnyReview()
                .clickYseAndCheckCountOfVote();
    }

    private static Stream<JSONProductData> productsDataStream() {
        return JSONDataReader.readProducts().getProducts().stream();
    }
}
