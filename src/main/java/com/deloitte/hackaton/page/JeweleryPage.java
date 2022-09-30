package com.deloitte.hackaton.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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



    @Step("Click on some products and go to product details")
    public JeweleryPage goToJewelry(){
        driver.get("https://demowebshop.tricentis.com/jewelry");
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage BlackWhiteDiamond(){
        blackWhiteDiamond.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage DiamondEarrings(){
        diamondEarrings.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }

    @Step ("Click on some products and go to product details")
    public JeweleryPage DiamondBracelet(){
        diamondBracelet.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }


    @Step ("Click on some products and go to product details")
    public JeweleryPage VintageRing(){
        vintageRing.click();
        listOfElements.add(productNameField.getText());
        driver.navigate().back();
        return this;
    }




    @Step ("Go to main page and validate if those products appeared on the recently viewed product list")
    public JeweleryPage presenceOfRecentlyViewdItems(){
        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("BLABLA" + recentlyViewed1.getText());
        assertEquals(recentlyViewed1.getText(), listOfElements.get(3));
        assertEquals(recentlyViewed2.getText(), listOfElements.get(2));
        assertEquals(recentlyViewed3.getText(), listOfElements.get(1));
        assertEquals(recentlyViewed4.getText(), listOfElements.get(0));
        return this;
    }
}

