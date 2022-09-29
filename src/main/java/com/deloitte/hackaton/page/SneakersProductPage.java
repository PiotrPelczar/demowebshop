package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SneakersProductPage extends UserAbstract {

    private List<String> array123;
    public SneakersProductPage(WebDriver driver, JSONUserData userData){
        super(driver, userData);
        array123 = new ArrayList<>();

    }

    public List<String> getList(){
        return array123;}


    @FindBy(id = "product_attribute_28_7_10")
    WebElement sizeDropdown;

    @FindBy(xpath = "//span[@style=\"background-color:#1fcb1a;\"]")
    WebElement colorGreen;

    @FindBy(id = "add-to-cart-button-28")
    WebElement addToCart;

    @FindBy (xpath = "//span[@class=\"close\"]")
    WebElement addToCartConfirmation;

    @FindBy (xpath = "//option[@value=\"28\"]")
    WebElement size11;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[@class=\"cart-label\"]")
    WebElement goToCartButton;

    @Step("Product is customized and added to cart")
    public SneakersProductPage selectSize() {
        Select sizeofSneakers = new Select(sizeDropdown);
        sizeofSneakers.selectByVisibleText("11");
        array123.add(size11.getAttribute("value"));
      //  checkout.getList().add(size11.getAttribute("value"));
        return this;
    }

    @Step("Product is customized and added to cart")
    public SneakersProductPage selectColor() {
        colorGreen.click();
        return this;
    }

    @Step("Product is customized and added to cart")
    public CartPage addToCart() throws InterruptedException {
        addToCart.click();
        addToCartConfirmation.click();
        goToCartButton.click();
        Thread.sleep(500L);
        return new CartPage(this.driver, this.userData);
    }


}
