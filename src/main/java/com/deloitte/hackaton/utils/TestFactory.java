package com.deloitte.hackaton.utils;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;

import com.deloitte.hackaton.page.*;

import com.deloitte.hackaton.page.CustomerInfoPage;
import com.deloitte.hackaton.page.LoginPage;
import com.deloitte.hackaton.page.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestFactory {

    public static RegisterPage startNewUserTest(WebDriver driver, JSONUserData userData) {
        return new RegisterPage(driver, userData);
    }

    public static LoginPage startNewLoginTest(WebDriver driver, JSONUserData userData) {
        return new LoginPage(driver, userData);
    }

    public static MainPage mainPage(WebDriver driver, JSONUserData userData) {
        return new MainPage(driver, userData);
    }

    public static GiftCards giftCards(WebDriver driver, JSONUserData userData) {
        return new GiftCards(driver, userData);
    }

    public static ContactUsNonLoginUserPage startNewContactUsFormNonLoginTest(WebDriver driver, JSONUserData userData){
        return new ContactUsNonLoginUserPage(driver, userData);
    }
    public static ContactUsLoginUserPage startNewContactUsFormLoginTest(WebDriver driver, JSONUserData userData){
        return new ContactUsLoginUserPage(driver, userData);
    }

    public static Cart cart(WebDriver driver, JSONUserData userData) {
        return new Cart(driver, userData);
    }

    public static BlueAndGreenSneaker blueAndGreenSneaker(WebDriver driver, JSONUserData userData) {
        return new BlueAndGreenSneaker(driver, userData);
    }

    public static CustomerInfoPage startNewCustomerInfoTest(WebDriver driver, JSONUserData userData) {
        return new CustomerInfoPage(driver, userData);

    }

    public static Checkout checkout(WebDriver driver, JSONUserData userData) {
        return new Checkout(driver, userData);
    }


    public static ProductPage startNewProductTest(WebDriver driver, JSONProductData productData, JSONUserData userData){
        return new ProductPage(driver, productData, userData);
    }



}

