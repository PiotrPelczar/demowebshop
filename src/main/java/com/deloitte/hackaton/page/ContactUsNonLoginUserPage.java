package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.*;


public class ContactUsNonLoginUserPage extends UserAbstract{

    @FindBy(xpath = "//a[@href = \"/contactus\"]")
    WebElement contactUsButton;

    @FindBy(xpath = "//input[@id = \"FullName\"]")
    WebElement fullNameInput;

    @FindBy(xpath = "//input[@id = \"Email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//textarea[@id = \"Enquiry\"]")
    WebElement enquireInput;

    @FindBy(xpath = "//input[@value=\"Submit\"]")
    WebElement submitButton;

    @FindBy(xpath = "//div[@class = \"result\"]")
    WebElement result;

    public ContactUsNonLoginUserPage(WebDriver driver, JSONUserData userData){
        super(driver, userData);
    }


    @Step("Open Main Page")
    public ContactUsNonLoginUserPage openMainPage(){
        driver.get("https://demowebshop.tricentis.com");
        return this;
    }

    @Step("Find and open Contact Us page")
    public ContactUsNonLoginUserPage openContactUsPage(){
        contactUsButton.click();
        assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/contactus");
        return this;
    }

    @Step("Input full name")
    public ContactUsNonLoginUserPage inputFullName(){
        fullNameInput.click();
        fullNameInput.sendKeys(getUserData().getFirstName() + " " + getUserData().getLastName());
        return this;
    }

    @Step("Input email")
    public ContactUsNonLoginUserPage inputEmail(){
        emailInput.click();
        emailInput.sendKeys(getUserData().getEmail());
        return this;
    }

    @Step("Input enquire")
    public ContactUsNonLoginUserPage inputEnquire(){
        enquireInput.click();
        assertEquals(true, enquireInput.getText().isEmpty());
        enquireInput.sendKeys(ContactUsLoginUserPage.ENQUIRE_TEXT);
        return this;
    }
    @Step("Click submit button")
    public ContactUsNonLoginUserPage submit(){
        submitButton.click();
        return this;
    }

    @Step("Verify if enquiry has been sent")
    public ContactUsNonLoginUserPage verifySubmitEnquiry(){
        System.out.println(result.getText());
        assertEquals(ContactUsLoginUserPage.RESULT, result.getText());
        return this;
    }

}