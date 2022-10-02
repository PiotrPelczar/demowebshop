package com.deloitte.hackaton;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.*;

public class QuantityOverloadTestSuite {

    WebDriver driver;


    @BeforeAll
    public static void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
    }

    @AfterEach
    void tearDown() {
        this.driver.quit();
    }


    @Test
    void moreThanA1000ItemsAdded() throws InterruptedException {
        startNewJeweleryTest(driver)
                .goToJewelry()
                .viewBlackWhiteDiamond()
                .addMoreThan10000pieces()
                .validateQtyOverloadMessage();

    }

}
