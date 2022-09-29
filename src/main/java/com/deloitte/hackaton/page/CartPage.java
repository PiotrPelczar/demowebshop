package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage extends ProductAbstract{

    @FindBy(xpath = "//input[@name='removefromcart']")
    WebElement deleteCheckbox;

    @FindBy(xpath = "//input[@class='qty-input']")
    WebElement quantity;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement itemName;

    @FindBy(xpath = "//input[@name='updatecart']")
    WebElement updateCart;

    @FindBy(xpath = "//div[@class='order-summary-content']")
    WebElement orderSummary;

    @FindBy(xpath = "//*[@id=\"CountryId\"]")
    WebElement countryDropDown;

    @FindBy(xpath = "//*[@id=\"StateProvinceId\"]")
    WebElement stateDropdown;

    @FindBy(xpath = "//*[@id=\"termsofservice\"]")
    WebElement termsServiceButton;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    WebElement checkoutButton;


    JSONUserData userData;

    public CartPage(WebDriver driver, JSONProductData productData, JSONUserData userData) {
        super(driver, productData);
        this.userData = userData;
    }

    @Step("Assert if ordered product is correct")
    public CartPage verifyProductName() {
        var txt = itemName.getText();
        assertTrue(txt.contains(productData.getName()));
        return this;
    }

    @Step("Assert if ordered quantity is correct")
    public CartPage verifyQuantity() {
        var txt = quantity.getAttribute("value");
        assertEquals(productData.getQuantity().toString(), txt);
        return this;
    }
    @Step("Select country from dropdown")
    public CartPage selectCountry(){
        Select countryDropDownSelect = new Select(countryDropDown);
        countryDropDownSelect.selectByVisibleText("United States");
        String text = countryDropDownSelect.getAllSelectedOptions().stream().iterator().next().getText();
        assertEquals("United States", text);
        WebElement unitedStates = driver.findElement(By.xpath("//*[@id=\"CountryId\"]//option[@value=\"1\"]"));
        assertTrue(unitedStates.isSelected());
        return this;
    }

    @Step("Select Alaska from dropdown")
    public CartPage selectState(){
        Select stateDropDownSelect = new Select(stateDropdown);
        stateDropDownSelect.selectByVisibleText("Alaska");
        String text = stateDropDownSelect.getAllSelectedOptions().stream().iterator().next().getText();
        assertEquals("Alaska", text);
        WebElement alaska = driver.findElement(By.xpath("//*[@id=\"StateProvinceId\"]/option[@value=\"4\"]"));
        assertTrue(alaska.isSelected());
        return this;
    }

    @Step("Accept terms")
    public CartPage acceptTerms(){
        termsServiceButton.click();
        return this;
    }

    @Step("Go to checkout")
    public CheckoutPage goToCheckout() throws InterruptedException {
        checkoutButton.click();
        Thread.sleep(500L);
        return new CheckoutPage(this.driver, this.productData, this.userData);
    }

}
