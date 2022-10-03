package com.deloitte.hackaton.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.deloitte.hackaton.data.user.JSONUserData;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterPage extends UserAbstract{

    @FindBy(xpath = "//form[@action=\"/register\"]//input[@value=\"M\"]")
    WebElement genderRadio;

    @FindBy(xpath = "//*[@id='FirstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[@id=\"LastName\"]")
    WebElement lastNameInput;

    @FindBy(xpath = "//*[@id=\"Email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"Password\"]")
    WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"ConfirmPassword\"]")
    WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@id=\"register-button\"]")
    WebElement registerButton;

    public RegisterPage(WebDriver driver, JSONUserData userData){
       super(driver, userData);
    }

    @Step("Open register page")
    public RegisterPage openRegisterPage(){
        driver.get("https://demowebshop.tricentis.com/register");
        return this;
    }

    @Step("Select gender")
    public RegisterPage selectGender(){
        genderRadio.click();
        return this;
    }

    @Step("Type first name")
    public RegisterPage typeFirstName(){
        firstNameInput.click();
        firstNameInput.sendKeys(getUserData().getFirstName());
        return this;
    }

    @Step("Type last name")
    public RegisterPage typeLastName(){
        lastNameInput.click();
        lastNameInput.sendKeys(getUserData().getLastName());
        return this;
    }

    @Step("Type email")
    public RegisterPage typeEmail(){
        emailInput.click();
        emailInput.sendKeys(getUserData().getEmail());
        return this;
    }

    @Step("Type password")
    public RegisterPage typePassword(){
        passwordInput.click();
        passwordInput.sendKeys(getUserData().getPassword());
        return this;
    }

    @Step("Repeat password")
    public RegisterPage repeatPassword(){
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(getUserData().getPassword());
        return this;
    }

    @Step("Click register button")
    public RegisterPage register(){
        registerButton.click();
        return this;
    }

    @Step("Assert if user account has been created")
    public RegisterPage verifyRegistration(){
        assertTrue(driver.getCurrentUrl().contains("registerresult"));
        return this;
    }

}
