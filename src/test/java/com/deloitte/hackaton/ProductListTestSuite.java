package com.deloitte.hackaton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;



import static com.deloitte.hackaton.utils.TestFactory.*;

public class ProductListTestSuite {

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
    void productListTests() throws InterruptedException {
        startBooksTest(driver)
                .getToBooksPage()
                .changeViewList()
                .changeViewGrid()
                .displayingDifferentNoOfProducts()
                .sortAZ()
                .sortZA()
                .priceLH()
                .priceHL()
                .filter();

    }

}
