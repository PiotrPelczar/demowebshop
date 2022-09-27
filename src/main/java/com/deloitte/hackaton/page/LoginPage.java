package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"Email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@value=\"Log in\"]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"header-links\"]//a[@href=\"/customer/info\"]")
    WebElement userInfo;

    @FindBy(xpath = "//a[@href = \"/logout\"]")
    WebElement logoutButton;

    WebDriver driver;

    JSONUserData userData;

    public LoginPage(WebDriver driver, JSONUserData userData){
        this.driver = driver;
        this.userData = userData;
        PageFactory.initElements(driver, this);
    }

    protected JSONUserData getUserData() {
        if (Objects.isNull(this.userData)) {
            throw new IllegalArgumentException("User data must not be null!");
        }
        return this.userData;
    }


    @Step("Open login page")
    public LoginPage openLoginPage(){
        driver.get("https://demowebshop.tricentis.com/login");
        return this;
    }

    @Step("Type email")
    public LoginPage typeEmail(){
        emailInput.click();
        emailInput.sendKeys(getUserData().getEmail());
        return this;
    }

    @Step("Type password")
    public LoginPage typePassword(){
        passwordInput.click();
        passwordInput.sendKeys(getUserData().getPassword());
        return this;
    }

    @Step("Click login button")
    public LoginPage logIn(){
        loginButton.click();
        return this;
    }

    @Step("Assert if user has been logged in")
    public LoginPage verifyLogin(){
        assertTrue(userInfo.isDisplayed());
        userInfo.click();
        assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/customer/info");
        return this;
    }

    @Step("Log out")
    public LoginPage logOut(){
        logoutButton.click();
        return this;
    }

    @Step
    public LoginPage verifyIfLoggedOut(){
        driver.get("https://demowebshop.tricentis.com/customer/info");
        assertTrue(driver.getCurrentUrl().contains("/login"));
        return this;
    }

}
