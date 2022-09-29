package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShoppingItems extends UserAbstract {


    WebDriver driver;


    public ShoppingItems(WebDriver driver, JSONUserData userData){
        super(driver, userData);
    }

    @FindBy(id = "product_attribute_28_7_10")
    WebElement siezeDropdown;

    @FindBy(xpath = "//span[@style=\"background-color:#1fcb1a;\"]")
    WebElement colorGreen;

    @FindBy(id = "add-to-cart-button-28")
    WebElement addTocart;

    @FindBy (xpath = "//span[@class=\"close\"]")
    WebElement addToCartConfirmation;

    @FindBy (xpath = "//a[@href=\"/50s-rockabilly-polka-dot-top-jr-plus-size\"]")
    WebElement rockPolka;

    @FindBy (id = "add-to-cart-button-5")
    WebElement rockPolkaAddToCart;

    @FindBy (xpath = "//a[@href=\"/blue-jeans\"]")
    WebElement blueJeans;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[4]/div/div[1]/a/img")
    WebElement physicalGiftCard100$;


    @Step("Product is customized and added to cart")
    public ShoppingItems selectSize() {
        Select sizeofSneakers = new Select(siezeDropdown);
        sizeofSneakers.selectByVisibleText("11");
        return this;
    }

    @Step("Product is customized and added to cart")
    public ShoppingItems selecColor() {
        colorGreen.click();
        return this;
    }

    @Step("Product is customized and added to cart")
    public ShoppingItems addToCart() {
        addTocart.click();
        addToCartConfirmation.click();
      //  new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(addToCartConfirmation));
        return this;
    }


    @Step ("locate Physical Gift Card and go to product details")
    public ShoppingItems locatePhisicalGiftCard(){
        physicalGiftCard100$.click();
        return this;
    }


}
