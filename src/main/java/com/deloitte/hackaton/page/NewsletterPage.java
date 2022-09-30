package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONInvalidEmails;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class NewsletterPage {

    @FindBy(id = "newsletter-email")
    WebElement newsletterTextField;

    @FindBy(id = "newsletter-subscribe-button")
    WebElement subscribeButton;

    @FindBy(id = "newsletter-result-block")
    WebElement errorMessage;

    WebDriver driver;
    JSONInvalidEmails invalidEmails;
    String []mailData;

    public NewsletterPage(WebDriver driver, JSONInvalidEmails invalidEmails){
        this.driver = driver;
        this.invalidEmails = invalidEmails;
        PageFactory.initElements(driver, this);
    }

    public JSONInvalidEmails getInvalidEmails() {
        if (Objects.isNull(this.invalidEmails)) {
            throw new IllegalArgumentException("User data must not be null!");
        }
        return this.invalidEmails;
    }

    @Step("Open main page")
    public NewsletterPage openMainPage(){
        driver.get("https://demowebshop.tricentis.com/");
        return this;
    }


    @Step("Find Newsletter text area and input incorrect mail")
    public NewsletterPage inputInvalidMail(){
        newsletterTextField.click();
        newsletterTextField.sendKeys(getInvalidEmails().getEmails());
        return this;
    }

    @Step("Click subscribe button")
    public NewsletterPage subscribe(){
        subscribeButton.click();
        return this;
    }

    @Step("Error message is displayed")
    public NewsletterPage errorMessage(){
        try{
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(errorMessage.getText());
        assertTrue(errorMessage.getText().contains("Enter valid email"));
        return this;
    }


}
