package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BlueAndGreenSneaker extends UserAbstract {


    WebDriver driver;

    private Checkout checkout;

    private List<String> array123;
    public BlueAndGreenSneaker(WebDriver driver, JSONUserData userData){
        super(driver, userData);
        array123 = new ArrayList<>();

    }

    public List<String> getList(){
        return array123;}


    @FindBy(id = "product_attribute_28_7_10")
    WebElement siezeDropdown;

    @FindBy(xpath = "//span[@style=\"background-color:#1fcb1a;\"]")
    WebElement colorGreen;

    @FindBy(id = "add-to-cart-button-28")
    WebElement addToCart;

    @FindBy (xpath = "//span[@class=\"close\"]")
    WebElement addToCartConfirmation;

    @FindBy (xpath = "//option[@value=\"28\"]")
    WebElement size11;


    @Step("Product is customized and added to cart")
    public BlueAndGreenSneaker selectSize() {
        Select sizeofSneakers = new Select(siezeDropdown);
        sizeofSneakers.selectByVisibleText("11");
        array123.add(size11.getAttribute("value"));
      //  checkout.getList().add(size11.getAttribute("value"));
        return this;
    }

    @Step("Product is customized and added to cart")
    public BlueAndGreenSneaker selecColor() {
        colorGreen.click();
        return this;
    }

    @Step("Product is customized and added to cart")
    public BlueAndGreenSneaker addToCart() {
        addToCart.click();
        addToCartConfirmation.click();
        //  new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(addToCartConfirmation));
        return this;
    }



}
