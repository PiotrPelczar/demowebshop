package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CheckoutPage extends ProductAbstract{


    @FindBy(xpath = "//*[@id=\"billing-address-select\"]")
    WebElement billingAddressSelect;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_CountryId\"]")
    WebElement billingAddressCountry;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_City\"]")
    WebElement city;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_Address1\"]")
    WebElement address_1;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_ZipPostalCode\"]")
    WebElement postCode;

    @FindBy(xpath = "//*[@id=\"BillingNewAddress_PhoneNumber\"]")
    WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
    WebElement billingContinueButton;

    @FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
    WebElement shippingContinueButton;

    @FindBy(xpath = "//*[@id=\"shipping-address-select\"]/option[1]")
    WebElement shippingAddress;

    @FindBy(xpath = "//input[@value=\"Ground___Shipping.FixedRate\"]")
    WebElement groundShippingMethod;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
    WebElement shippingMethodContinueButton;

    @FindBy(xpath = "//input[@value=\"Payments.PurchaseOrder\"]")
    WebElement paymentMethod;

    @FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
    WebElement paymentMethodContinueButton;

    @FindBy(xpath = "//*[@id=\"PurchaseOrderNumber\"]")
    WebElement purchaseOrderNumber;

    @FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
    WebElement purchaseOrderNumberContinueButton;

    @FindBy(xpath = "//td[@class=\"product\"]//a")
    WebElement productName;

    @FindBy(xpath = "//td[@class=\"qty nobr\"]/span[not(@class)]")
    WebElement quantity;

    @FindBy(xpath = "//input[@onclick=\"Billing.save()\"]")
    WebElement clickBillingAddress;

    @FindBy(xpath = "//input[@onclick=\"Shipping.save()\"]")
    WebElement clickShippingAddress;

    @FindBy(xpath = "//input[@onclick=\"ShippingMethod.save()\"]")
    WebElement clickShippingMethod;

    @FindBy (xpath = "//input[@value=\"Payments.CashOnDelivery\"]")
    WebElement paymentMethodCOD;

    @FindBy(xpath = "//input[@onclick=\"PaymentMethod.save()\"]")
    WebElement clickPaymentMethod;
    @FindBy(xpath = "//input[@onclick=\"PaymentInfo.save()\"]")
    WebElement clickPaymentInfo;

    @FindBy(xpath = "//input[@onclick=\"ConfirmOrder.save()\"]")
    WebElement clickConfirmOrder;

    @FindBy(xpath = "//li/a[contains(@href, \"/orderdetails\")]")
    WebElement orderDetails;

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

    @FindBy(xpath = "//div[@class=\"attributes\"][contains(text(), \"Size\")]")
    WebElement sizeColorField;

    @FindBy(xpath = "//em//a")
    WebElement shoeNameField;




    public List<String> elements = SneakersProductPage.getList();

    public CheckoutPage(WebDriver driver, JSONProductData productData, JSONUserData userData) {
        super(driver, productData);
        this.userData = userData;
    }

    @Step("Click Order details and validate order")
    public CheckoutPage clickThroughPaymentMethods() {
        clickBillingAddress.click();
        clickShippingAddress.click();
        groundShippingMethod.click();
//        arrayCheckout.add(shippingGroundLabel.getText());
        clickShippingMethod.click();
        paymentMethodCOD.click();
//        arrayCheckout.add(paymentMethodCODLabel.getText());
        clickPaymentMethod.click();
        clickPaymentInfo.click();
        return this;
    }
    @Step
    public CheckoutPage chooseNewBillingAddress(){
        Select billingAddressSelectDropdown = new Select(billingAddressSelect);
        billingAddressSelectDropdown.selectByVisibleText("New Address");
        WebElement newAddress = driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]/option[@value=\"\"]"));
        assertTrue(newAddress.isSelected());
        return this;
    }

    @Step
    public CheckoutPage addNewAddressData() throws InterruptedException {
        Select billingAddressCountrySelectDropdown = new Select(billingAddressCountry);
        billingAddressCountrySelectDropdown.selectByVisibleText("Canada");
        city.sendKeys("Toronto");
        address_1.sendKeys("address1");
        postCode.sendKeys("93-120");
        phoneNumber.sendKeys("123321123");
        Thread.sleep(1000);
        billingContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage selectShippingAddress() throws InterruptedException {
        shippingAddress.click();
        Thread.sleep(1000);
        shippingContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage selectShippingMethod() throws InterruptedException {
        groundShippingMethod.click();
        Thread.sleep(1000);
        shippingMethodContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage selectPaymentMethod() throws InterruptedException {
        paymentMethod.click();
        Thread.sleep(1000);
        paymentMethodContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage typePurchaseOrderNumber() throws InterruptedException {
        purchaseOrderNumber.sendKeys("0001");
        Thread.sleep(1000);
        purchaseOrderNumberContinueButton.click();
        return this;
    }

    @Step("Click Order details and validate order")
    public CheckoutPage validateBillingInfo() {
        assertTrue(nameDetailsBilling.getText().contains(getUserData().getFirstName()));
        assertTrue(nameDetailsBilling.getText().contains(getUserData().getLastName()));
        assertTrue(emailDetailsBilling.getText().contains(getUserData().getEmail()));
        assertEquals(phoneDetailsBilling.getText().replaceAll("[^0-9]", ""), getUserData().getPhoneNumber());
        assertTrue(cityStateZipDetailsBilling.getText().contains(getUserData().getCity()));
        assertTrue(cityStateZipDetailsBilling.getText().contains(getUserData().getPostCode()));
        assertTrue(countryDetailsBilling.getText().contains(getUserData().getCountry()));
//        String paymentCODFromArray = arrayCheckout.get(1);
//        String paymentCOD[] = paymentCODFromArray.split(" ");
//        assertTrue(paymentDetailsBilling.getText().contains(paymentCOD[0]));
        return this;
    }

    @Step("Click Order details and validate order")
    public CheckoutPage validateShippingInfo() {
        assertTrue(nameDetailsShipping.getText().contains(getUserData().getFirstName()));
        assertTrue(nameDetailsShipping.getText().contains(getUserData().getLastName()));
        assertTrue(emailDetailsShipping.getText().contains(getUserData().getEmail()));
        assertEquals(phoneDetailsShipping.getText().replaceAll("[^0-9]", ""), getUserData().getPhoneNumber());
        assertTrue(cityStateZipDetailsShipping.getText().contains(getUserData().getCity()));
        assertTrue(cityStateZipDetailsShipping.getText().contains(getUserData().getPostCode()));
        assertTrue(countryDetailsShipping.getText().contains(getUserData().getCountry()));
//        String groundLabelFromArray = arrayCheckout.get(0);
//        String groundLabel[] = groundLabelFromArray.split(" ");
//        assertTrue(methodDetailsShipping.getText().contains(groundLabel[0]));
        return this;
    }

    @Step
    public CheckoutPage validateShoesDetails(){
        assertTrue(sizeColorField.getText().contains(elements.get(0)));
        assertTrue(sizeColorField.getText().contains(elements.get(2)));
        assertEquals(shoeNameField.getText(), elements.get(1));
        return this;
    }


    @Step
    public CheckoutPage validateProductDetails(){
        var productNameText = productName.getText();
        assertTrue(productNameText.contains(productData.getName()));

        var productQuantity = quantity.getText();
        assertEquals(productData.getQuantity().toString(), productQuantity);

        return this;
    }

    @Step("Click Order details and validate order")
    public CheckoutPage confirm() {
        clickConfirmOrder.click();
        orderDetails.click();
        return this;
    }
}