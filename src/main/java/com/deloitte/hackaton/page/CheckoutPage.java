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



    JSONUserData userData;
    public CheckoutPage(WebDriver driver, JSONProductData productData, JSONUserData userData) {
        super(driver, productData);
        this.userData = userData;
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
    public CheckoutPage addNewAddressData(){
        Select billingAddressCountrySelectDropdown = new Select(billingAddressCountry);
        billingAddressCountrySelectDropdown.selectByVisibleText("Canada");
        city.sendKeys("Toronto");
        address_1.sendKeys("address1");
        postCode.sendKeys("93-120");
        phoneNumber.sendKeys("123321123");
        billingContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage selectShippingAddress(){
        shippingAddress.click();
        shippingContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage selectShippingMethod(){
        groundShippingMethod.click();
        shippingMethodContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage selectPaymentMethod(){
        paymentMethod.click();
        paymentMethodContinueButton.click();
        return this;
    }

    @Step
    public CheckoutPage typePurchaseOrderNumber(){
        purchaseOrderNumber.sendKeys("0001");
        purchaseOrderNumberContinueButton.click();
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

}
