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

import static com.deloitte.hackaton.utils.TestFactory.*;


public class ProductsDataDrivenTestSuite {

    WebDriver driver;

    @BeforeAll
    static void setupAll(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup(){
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        this.driver.quit();
    }


    @ParameterizedTest
    @MethodSource("productsDataStream")
    void testCheckoutWithoutAgreeing(JSONProductData productData) throws InterruptedException {
        mainPage(driver, productData).navigateToMainPage();
        boolean isEmpty = startNewCartTest(driver, productData).checkIfCartEmpty();
        if(isEmpty){
            startNewCartTest(driver, productData).deleteIfNotEmpty();
        }
        startNewProductTest(driver, productData)
                .openProductPage()
                .verifyProductName()
                .verifyAvailability()
                .selectQuantity()
                .orderProduct()
                .verifyNotification()
                .goToCartPage()
                .clickCheckoutButton()
                .validateCheckout();
    }

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
        startNewCustomerInfoTest(driver, userData).openAddressPage().deleteAllAddresses();
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

        boolean isEmpty = startNewCartTest(driver, productData, userData).checkIfCartEmpty();
        if(isEmpty){
            startNewCartTest(driver, productData, userData).deleteIfNotEmpty();
        }
        startNewProductTest(driver, productData, userData)
                .openProductPage()
                .verifyProductName()
                .verifyAvailability()
                .selectQuantity()
                .orderProduct()
                .verifyNotification();
        mainPage(driver, userData)
                .getElementsFromProductDetails()
                .navigateToMainPage()
                .searchFor14laptop()
                .laptop14inchAddToCart()
                .goToCart()
                .deleteProduct()
                .updateCart()
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
                .validateShippingInfo()
                .validateBillingInfoOnChange()
                .confirm()
                .validateTotalCostsInDetailsIfPO();
        startNewLoginTest(driver, userData)
                .logOut()
                .verifyIfLoggedOut();
    }

    private static Stream<JSONProductData> productsDataStream() {
        return JSONDataReader.readProducts().getProducts().stream();
    }
}
