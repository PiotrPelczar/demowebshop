package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.*;

public class ContactUsLoginUserPage extends UserAbstract{

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

    public static final String RESULT = "Your enquiry has been successfully sent to the store owner.";
    public static final String ATTRIBUTE = "value";
    public static final String ENQUIRE_TEXT = "some text";

    public ContactUsLoginUserPage(WebDriver driver, JSONUserData userData){
        super(driver, userData);
    }

    @Step("Find and open Contact Us page")
    public ContactUsLoginUserPage openContactUsPage(){
        contactUsButton.click();
        assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/contactus");
        return this;
    }

    @Step("Check if user email is correct in Email field")
    public ContactUsLoginUserPage verifyEmailInput(){
        assertEquals(userData.getEmail(), emailInput.getAttribute(ATTRIBUTE));
        return this;
    }

    @Step("Check if user full name is correct in fullname field")
    public ContactUsLoginUserPage verifyFullNameInput(){
        assertEquals(userData.getFirstName() + " " + userData.getLastName(), fullNameInput.getAttribute(ATTRIBUTE));
        return this;
    }

    @Step("Input enquire")
    public ContactUsLoginUserPage inputEnquire(){
        enquireInput.click();
        assertTrue( enquireInput.getText().isEmpty());
        enquireInput.sendKeys(ENQUIRE_TEXT);
        return this;
    }
    @Step("Click submit button")
    public ContactUsLoginUserPage submit(){
        submitButton.click();
        return this;
    }

    @Step("Verify if enquiry has been sent")
    public ContactUsLoginUserPage verifySubmitEnquiry(){
        System.out.println(result.getText());
        assertEquals(RESULT, result.getText());
        return this;
    }

}
