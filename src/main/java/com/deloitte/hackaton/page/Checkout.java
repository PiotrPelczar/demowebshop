package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Checkout extends UserAbstract {

    ArrayList<String> car = new ArrayList<String>();

    public Checkout(WebDriver driver, JSONUserData userData) {
        super(driver, userData);
    }


    @FindBy(xpath = "//input[@onclick=\"Billing.save()\"]")
    WebElement clickBillingAdress;

    @FindBy(xpath = "//input[@onclick=\"Shipping.save()\"]")
    WebElement clickShippingAdress;

    @FindBy(xpath = "//input[@onclick=\"ShippingMethod.save()\"]")
    WebElement clickShippingMethod;

    @FindBy(xpath = "//input[@onclick=\"PaymentMethod.save()\"]")
    WebElement clickPaymentMethod;

    @FindBy(xpath = "//input[@onclick=\"PaymentInfo.save()\"]")
    WebElement clickPaymentInfo;

    @FindBy(xpath = "//input[@onclick=\"ConfirmOrder.save()\"]")
    WebElement clickConfirmOrder;

    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")
    WebElement orderDetails;

    @FindBy(xpath = "//li[@class=\"name\"]")
    WebElement name;

    @FindBy(id = "shippingoption_0")
    WebElement shippingGround;

    @FindBy(id = "shippingoption_1")
    WebElement shippingNextDay;

    @FindBy(id = "shippingoption_2")
    WebElement shipping2ndDay;

    @FindBy(xpath = "//li[@class=\"shipping-method\"]")
    WebElement shippingMethodDetails;

    @FindBy(xpath = "//li[@class=\"name\"]")
    WebElement nameInDetails;

    @FindBy (xpath = "//li[@class=\"email\"]")
    WebElement emailInDetails;

    @FindBy (xpath = "//li[@class=\"phone\"]")
    WebElement phoneInDetails;

    @FindBy (xpath = "//li[@class=\"city-state-zip\"]")
    WebElement cityStateZipInDetails;



    @Step("Click Order details and validate order")
    public Checkout clickThroughPaymentMethods() {
        clickBillingAdress.click();
        clickShippingAdress.click();
        clickShippingMethod.click();
        clickPaymentMethod.click();
        clickPaymentInfo.click();


        return this;
    }



    @Step("Click Order details and validate order")
    public Checkout confirm() {
        clickConfirmOrder.click();
        orderDetails.click();
        return this;
    }

    @Step("Click Order details and validate order")
    public Checkout validateName() {
        assertTrue(nameInDetails.getText().contains(getUserData().getFirstName()));
        assertTrue(nameInDetails.getText().contains(getUserData().getLastName()));
        return this;
    }




}
