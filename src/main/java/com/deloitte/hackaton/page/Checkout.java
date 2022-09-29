package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Checkout extends UserAbstract {

    private BlueAndGreenSneaker sneaker;
    private List<String> arraySneaker;
    public Checkout(WebDriver driver, JSONUserData userData) {
        super(driver, userData);
        arraySneaker = new ArrayList<>();
    }

    public List<String> getList(){
        return arraySneaker;

    }

    List<String> arrayCheckout = new ArrayList<String>();

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

    @FindBy(xpath = "//input[@value=\"Ground___Shipping.FixedRate\"]")
    WebElement shippingGround;

    @FindBy (xpath = "//label[@for=\"shippingoption_0\"]")
    WebElement shippingGroundLabel;

    @FindBy (xpath = "//input[@value=\"Payments.CashOnDelivery\"]")
    WebElement paymentMethodCOD;

    @FindBy (xpath = "//div[@class=\"payment-details\"]/label[@for=\"paymentmethod_0\"]")
    WebElement paymentMethodCODLabel;


    @FindBy(xpath = "//ul[@class=\"billing-info\"]/li[@class=\"name\"]")
    WebElement nameDetailsBilling;

    @FindBy (xpath = "//ul[@class=\"billing-info\"]/li[@class=\"email\"]")
    WebElement emailDetailsBilling;

    @FindBy (xpath = "//ul[@class=\"billing-info\"]/li[@class=\"phone\"]")
    WebElement phoneDetailsBilling;

    @FindBy (xpath = "//ul[@class=\"billing-info\"]/li[@class=\"city-state-zip\"]")
    WebElement cityStateZipDetailsBilling;

    @FindBy (xpath = "//ul[@class=\"billing-info\"]/li[@class=\"country\"]")
    WebElement countryDetailsBilling;

    @FindBy (xpath = "//ul[@class=\"billing-info\"]/li[@class=\"payment-method\"]")
    WebElement paymentDetailsBilling;

    @FindBy(xpath = "//ul[@class=\"shipping-info\"]/li[@class=\"name\"]")
    WebElement nameDetailsShipping;

    @FindBy (xpath = "//ul[@class=\"shipping-info\"]/li[@class=\"email\"]")
    WebElement emailDetailsShipping;

    @FindBy (xpath = "//ul[@class=\"shipping-info\"]/li[@class=\"phone\"]")
    WebElement phoneDetailsShipping;

    @FindBy (xpath = "//ul[@class=\"shipping-info\"]/li[@class=\"city-state-zip\"]")
    WebElement cityStateZipDetailsShipping;

    @FindBy (xpath = "//ul[@class=\"shipping-info\"]/li[@class=\"country\"]")
    WebElement countryDetailsShipping;

    @FindBy (xpath = "//ul[@class=\"shipping-info\"]/li[@class=\"shipping-method\"]")
    WebElement methodDetailsShipping;

    @FindBy (xpath = "//div[@class=\"attributes\"]")
    WebElement productDetails;





    @Step("Click Order details and validate order")
    public Checkout clickThroughPaymentMethods() {
        clickBillingAdress.click();
        clickShippingAdress.click();
        shippingGround.click();

        arrayCheckout.add(shippingGroundLabel.getText());
        clickShippingMethod.click();
        paymentMethodCOD.click();
        arrayCheckout.add(paymentMethodCODLabel.getText());
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
    public Checkout validateBillingInfo() {
        assertTrue(nameDetailsBilling.getText().contains(getUserData().getFirstName()));
        assertTrue(nameDetailsBilling.getText().contains(getUserData().getLastName()));
        assertTrue(emailDetailsBilling.getText().contains(getUserData().getEmail()));
        assertEquals(phoneDetailsBilling.getText().replaceAll("[^0-9]", ""), getUserData().getPhoneNumber());
        assertTrue(cityStateZipDetailsBilling.getText().contains(getUserData().getCity()));
        assertTrue(cityStateZipDetailsBilling.getText().contains(getUserData().getPostCode()));
        assertTrue(countryDetailsBilling.getText().contains(getUserData().getCountry()));
        String paymentCODFromArray = arrayCheckout.get(1);
        String paymentCOD[] = paymentCODFromArray.split(" ");
        assertTrue(paymentDetailsBilling.getText().contains(paymentCOD[0]));

        return this;
    }

    @Step("Click Order details and validate order")
    public Checkout validateShippingInfo() {
        assertTrue(nameDetailsShipping.getText().contains(getUserData().getFirstName()));
        assertTrue(nameDetailsShipping.getText().contains(getUserData().getLastName()));
        assertTrue(emailDetailsShipping.getText().contains(getUserData().getEmail()));
        assertEquals(phoneDetailsShipping.getText().replaceAll("[^0-9]", ""), getUserData().getPhoneNumber());
        assertTrue(cityStateZipDetailsShipping.getText().contains(getUserData().getCity()));
        assertTrue(cityStateZipDetailsShipping.getText().contains(getUserData().getPostCode()));
        assertTrue(countryDetailsShipping.getText().contains(getUserData().getCountry()));
        String groundLabelFromArray = arrayCheckout.get(0);
        String groundLabel[] = groundLabelFromArray.split(" ");
        assertTrue(methodDetailsShipping.getText().contains(groundLabel[0]));
        return this;
    }


    @Step("Click Order details and validate order")
    public Checkout validateProductInfoBGSneaker() {
        assertTrue(productDetails.getText().contains(sneaker.getList().get(0)));
        return this;
    }











}
