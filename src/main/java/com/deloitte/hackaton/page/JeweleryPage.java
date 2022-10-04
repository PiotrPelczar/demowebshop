package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JeweleryPage extends ProductAbstract {

    List<String> listOfElements = new ArrayList<String>();

    public JeweleryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-productid=\"14\"]/div[@class=\"details\"]/h2[@class=\"product-title\"]")
    WebElement blackWhiteDiamond;

    @FindBy(xpath = "//div[@data-productid=\"25\"]/div[@class=\"details\"]/h2[@class=\"product-title\"]")
    WebElement diamondEarrings;

    @FindBy(xpath = "//div[@data-productid=\"26\"]/div[@class=\"details\"]/h2[@class=\"product-title\"]")
    WebElement diamondBracelet;

    @FindBy(xpath = "//div[@data-productid=\"48\"]/div[@class=\"details\"]/h2[@class=\"product-title\"]")
    WebElement vintageRing;

    @FindBy (xpath = "//h1[@itemprop=\"name\"]")
    WebElement productNameField;

    @FindBy (css = "div.block.block-recently-viewed-products > div.listbox > ul > li:nth-child(1) > a")
    WebElement recentlyViewed1;

    @FindBy (css = "div.block.block-recently-viewed-products > div.listbox > ul > li:nth-child(2) > a")
    WebElement recentlyViewed2;

    @FindBy (css = "div.block.block-recently-viewed-products > div.listbox > ul > li:nth-child(3) > a")
    WebElement recentlyViewed3;

    @FindBy (css = "div.block.block-recently-viewed-products > div.listbox > ul > li.last > a")
    WebElement recentlyViewed4;

    @FindBy (id = "addtocart_14_EnteredQuantity")
    WebElement blackDiamondQty;

    @FindBy (xpath = "//input[@class=\"button-1 add-to-cart-button\"]")
    WebElement addTocart;

    @FindBy (xpath = "//p[@class=\"content\"]")
    WebElement alertMessage;


    @Step("Click on some products and go to product details")
    public JeweleryPage goToJewelry(){
        driver.get(getBaseUrl()+"jewelry");
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage blackWhiteDiamond(){
        blackWhiteDiamond.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage diamondEarrings(){
        diamondEarrings.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage diamondBracelet(){
        diamondBracelet.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }


    @Step ("Click on some products and go to product details")
    public JeweleryPage vintageRing(){
        vintageRing.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }

    @Step ("Go to main page and validate if those products appeared on the recently viewed product list")
    public JeweleryPage presenceOfRecentlyViewdItems(){
        driver.get(getBaseUrl());
        assertEquals(recentlyViewed1.getText(), listOfElements.get(3));
        assertEquals(recentlyViewed2.getText(), listOfElements.get(2));
        assertEquals(recentlyViewed3.getText(), listOfElements.get(1));
        assertEquals(recentlyViewed4.getText(), listOfElements.get(0));
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage viewBlackWhiteDiamond() {
        blackWhiteDiamond.click();
        return this;
    }

    @Step ("Provide large value in the product quantity field and validate error message")
    public JeweleryPage addMoreThan10000pieces(){
        blackDiamondQty.clear();
        blackDiamondQty.sendKeys("10001");
        addTocart.click();
        return this;
    }

    String expectedQtyOverloadMessage = "The maximum quantity allowed for purchase is 10000.";
    @Step ("Provide large value in the product quantity field and validate error message")
    public JeweleryPage validateQtyOverloadMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(alertMessage));
        assertEquals(alertMessage.getText(), expectedQtyOverloadMessage );
        return this;
    }
}

