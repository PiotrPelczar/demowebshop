package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import lombok.var;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPage extends ProductAbstract{

    private static final String SUCCESS_NOTIFICATION = "The product has been added to your shopping cart";

    @FindBy(xpath = "//div[@class='product-name']")
    WebElement itemName;

    @FindBy(xpath = "//div[@class='stock']/span[@class='value']")
    WebElement availability;

    @FindBy(xpath = "//input[@class='qty-input']")
    WebElement qtyInput;

    @FindBy(xpath = "//input[@class='button-1 add-to-cart-button']")
    WebElement addButton;

    @FindBy(xpath = "//div[@class='bar-notification success']")
    WebElement notificationBar;

    @FindBy(xpath = "//span[@class='cart-label']")
    WebElement cartLink;

    JSONUserData userData;

    public ProductPage(WebDriver driver, JSONProductData productData, JSONUserData userData ) {
        super(driver, productData);
        this.userData = userData;
    }


    @Step
    public LoginPage login(){
        return new LoginPage(this.driver, this.userData);
    }

    @Step("Open product page")
    public ProductPage openProductPage() throws InterruptedException {
        this.driver.get("https://demowebshop.tricentis.com/"+ getProductData().getUrl());
        return this;
    }

    @Step("Assert if product name is correct")
    public ProductPage verifyProductName() {
        var txt = itemName.getText();
        assertTrue(txt.contains(getProductData().getName()));
        return this;
    }

    @Step("Assert if product availability is correct")
    public ProductPage verifyAvailability() {
        var expected = getProductData().getAvailable();
        var txt = availability.getText();

        if (expected){
            assertEquals("In stock", txt);
        }

        return this;
    }

    @Step("Type product quantity")
    public ProductPage selectQuantity() {
        qtyInput.click();
        qtyInput.clear();
        qtyInput.sendKeys(getProductData().getQuantity().toString());
        return this;
    }

    @Step("Order product")
    public ProductPage orderProduct() throws InterruptedException {
        addButton.click();
        Thread.sleep(500L);
        return this;
    }

    @Step("Assert if product is ordered")
    public ProductPage verifyNotification() throws InterruptedException {
        var txt = notificationBar.getText();
        Thread.sleep(500L);
        assertTrue(txt.contains(SUCCESS_NOTIFICATION));
        return this;
    }

    @Step("Open shopping cart page")
    public CartPage goToCartPage() throws InterruptedException {
        cartLink.click();
        Thread.sleep(500L);
        return new CartPage(this.driver, this.productData, this.userData);
    }


}
