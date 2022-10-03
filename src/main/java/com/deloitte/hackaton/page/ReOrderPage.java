package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ReOrderPage extends ProductAbstract{

    @FindBy(xpath = "//a[@href = \"/customer/orders\"]")
    WebElement ordersButton;

    @FindBy(css = ".order-details-button")
    List<WebElement> details;

    @FindBy(css = ".re-order-button")
    WebElement reOrderButton;

    @FindBy(css = "td.name")
    WebElement productName;

    @FindBy(css = "td.price")
    WebElement productPrice;

    @FindBy(css = "td.quantity")
    WebElement productQuantity;

    @FindBy(css = "td.total")
    WebElement productTotal;

    String orderNumberString, getName, getPrice, getQuantity, getTotal;
    List<String> productData = CartPage.getList();
    JSONUserData userData;

    public ReOrderPage(WebDriver driver, JSONProductData productData, JSONUserData userData ) {
        super(driver, productData);
        this.userData = userData;
    }

    @Step("Open Orders Info")
    public ReOrderPage openOrdersInfo(){
        ordersButton.click();
        assertEquals("https://demowebshop.tricentis.com/customer/orders", driver.getCurrentUrl());
        return this;
    }

    @Step("Click details button on the fist item")
    public ReOrderPage detailsButton(){
        WebElement firstItemDetailsButton = details.stream().findFirst().get();
        orderNumberString = firstItemDetailsButton.getText();
        firstItemDetailsButton.click();
        assertTrue(driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/orderdetails/"));
        getName = productName.getText();
        getPrice = productPrice.getText();
        getQuantity = productQuantity.getText();
        getTotal = productTotal.getText();
        return this;
    }

    @Step("Click on ReOrder button")
    public ReOrderPage clickOnReOrderButton(){
        reOrderButton.click();
        assertEquals("https://demowebshop.tricentis.com/cart", driver.getCurrentUrl());
        return this;
    }

    @Step("Check correctness order's data after re-order")
    public ReOrderPage reOrderCheckData(){
        assertEquals(getName, productData.get(0));
        assertEquals(getPrice, productData.get(2));
        assertEquals(getQuantity, productData.get(1));
        assertEquals(getTotal, productData.get(3));

        return this;
    }

    @Step("Check if first order number is change")
    public ReOrderPage checkOrdersNumberForFirstItem(){
        WebElement firstItemDetailsButton = details.stream().findFirst().get();
        assertNotEquals(orderNumberString, firstItemDetailsButton.getText());
        return this;
    }
}
