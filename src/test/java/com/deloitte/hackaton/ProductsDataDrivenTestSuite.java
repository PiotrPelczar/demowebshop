package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.startNewLoginTest;
import static com.deloitte.hackaton.utils.TestFactory.startNewProductTest;


public class ProductsDataDrivenTestSuite {

    WebDriver driver; // reference to current WebDriver object

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

//    @AfterEach
//    void tearDown() {
//        this.driver.quit();
//    }


    @ParameterizedTest
    @MethodSource("productsDataStream")
    void buyAProductAsRegistered(JSONProductData productData) throws InterruptedException {
        JSONUserData userData = JSONDataReader.readUsers().getUsers().get(0);
        startNewProductTest(driver, productData, userData)
                .login()
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        startNewProductTest(driver, productData, userData)
                .openProductPage()
                .verifyProductName()
                .verifyAvailability()
                .selectQuantity()
                .orderProduct()
                .verifyNotification()
                .goToCartPage()
                .verifyProductName()
                .verifyQuantity()
                .selectCountry()
                .selectState()
                .acceptTerms()
                .goToCheckout()
                .chooseNewBillingAddress()
                .addNewAddressData()
                .selectShippingAddress()
                .selectShippingMethod()
                .selectPaymentMethod()
                .typePurchaseOrderNumber()
                .validateProductDetails();
    }

    private static Stream<JSONProductData> productsDataStream() {
        return JSONDataReader.readProducts().getProducts().stream();
    }
}
