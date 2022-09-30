package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.*;

public class RecentyViewdProductsTestSuite {

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


    @Test
    void buyAProductAsRegistered() throws InterruptedException {
        startNewJeweleryTest(driver)
                .goToJewelry()
                .BlackWhiteDiamond()
                .DiamondBracelet()
                .DiamondEarrings()
                .VintageRing()
                .presenceOfRecentlyViewdItems();

    }

}
