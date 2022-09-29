package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Cart extends UserAbstract {

    public Cart(WebDriver driver, JSONUserData userData){
        super(driver, userData);
    }

    @FindBy (id = "CountryId")
    WebElement countryDropdownShipping;

    @FindBy (id = "termsofservice")
    WebElement termsOfServiceCheck;

    @FindBy (id = "checkout")
    WebElement checkoutButton;


    @Step ("Go to cart")
    public Cart goToCart() {
        driver.get("https://demowebshop.tricentis.com/cart");

        return this;
    }

    @Step ("Provide info for checkout and confirm purchase")
    public Cart selectCountryFromDropdown(){
        Select countryDropdown = new Select(countryDropdownShipping);
        countryDropdown.selectByVisibleText(userData.getCountry());
        return this;
    }

    @Step ("Provide info for checkout and confirm purchase")
    public Cart clickTerms() {
        termsOfServiceCheck.click();
        return this;
    }

    @Step ("Provide info for checkout and confirm purchase")
    public Cart clickCheckout() {
        checkoutButton.click();
        //  userData.getAddress_1()
        return this;
    }


}
