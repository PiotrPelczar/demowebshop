package com.deloitte.hackaton.utils;
import com.deloitte.hackaton.data.user.JSONInvalidEmails;
import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import com.deloitte.hackaton.page.*;
import com.deloitte.hackaton.data.user.UserDataRandomizer;
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
    public static NewsletterPage startNewNewsletterNegativeTest(WebDriver driver, JSONInvalidEmails mailData){
        return new NewsletterPage(driver, mailData);
    }
    public static MainPage mainPage(WebDriver driver, JSONUserData userData) {
        return new MainPage(driver, userData);
    }

    public static ContactUsNonLoginUserPage startNewContactUsFormNonLoginTest(WebDriver driver, JSONUserData userData){
        return new ContactUsNonLoginUserPage(driver, userData);
    }
    public static ContactUsLoginUserPage startNewContactUsFormLoginTest(WebDriver driver, JSONUserData userData){
        return new ContactUsLoginUserPage(driver, userData);
    }
    public static CustomerInfoPage startNewCustomerInfoTest(WebDriver driver, JSONUserData userData) {
        return new CustomerInfoPage(driver, userData);
    }
    public static ProductPage startNewProductTest(WebDriver driver, JSONProductData productData, JSONUserData userData){
        return new ProductPage(driver, productData, userData);
    }

    public static CartPage startNewCartTest(WebDriver driver, JSONProductData productData, JSONUserData userData){
        return new CartPage(driver, productData, userData);
    }

    public static CartPage startNewCartTest(WebDriver driver, JSONUserData userData){
        return new CartPage(driver, userData);
    }
}

