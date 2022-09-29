package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.security.RunAs;
import java.time.Duration;

public class MainPage extends UserAbstract {


    public MainPage (WebDriver driver, JSONUserData userData){
        super(driver, userData);
    }

    @FindBy(xpath = "//a[@href=\"/gift-cards\"]")
    WebElement giftCards;

    @FindBy(id = "small-searchterms")
    WebElement searchField;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[1]/a/img")
    WebElement blueAndGreenSneaker;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div[2]/h2/a")
    WebElement laptop14inch;

    @FindBy(id = "add-to-cart-button-31")
    WebElement laptop14inchAddToCart;

    @FindBy (xpath = "//p[@class=\"content\"]")
    WebElement addToCartConfirmation;

    @FindBy (xpath = "//a[@href=\"/apparel-shoes\"]")
    WebElement apparelShoes;

    @FindBy(xpath = "//*[@id=\"topcartlink\"]/a/span[@class=\"cart-label\"]")
    WebElement goToCartButton;


    public MainPage navigateToMainPage() {
        driver.get("https://demowebshop.tricentis.com/");
        return this;
    }

    public GiftCardsPage goToGiftCards() {
        giftCards.click();
        return new GiftCardsPage(driver, userData);
    }

    public SneakersProductPage searchForBlueAndGreenSneaker() {
        searchField.sendKeys("blue and green sneaker");
        searchField.sendKeys(Keys.RETURN);
        blueAndGreenSneaker.click();
        return new SneakersProductPage(driver, userData);
    }

    @Step ()
    public MainPage searchFor14laptop() {
        searchField.sendKeys("14.1-inch Laptop");
        searchField.sendKeys(Keys.RETURN);
        laptop14inch.click();
        return this;
    }

    public CartPage laptop14inchAddToCart() throws InterruptedException {
        laptop14inchAddToCart.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(addToCartConfirmation));
        goToCartButton.click();
        Thread.sleep(500L);
        return new CartPage(this.driver, this.userData);
    }

}











