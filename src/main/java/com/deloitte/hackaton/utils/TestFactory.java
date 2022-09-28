package com.deloitte.hackaton.utils;

import com.deloitte.hackaton.data.user.JSONUserData;
<<<<<<< HEAD

import com.deloitte.hackaton.page.*;

=======
import com.deloitte.hackaton.data.user.UserDataRandomizer;
import com.deloitte.hackaton.page.CustomerInfoPage;
import com.deloitte.hackaton.page.LoginPage;
import com.deloitte.hackaton.page.RegisterPage;
>>>>>>> origin
import org.openqa.selenium.WebDriver;

public class TestFactory {

    public static RegisterPage startNewUserTest(WebDriver driver, JSONUserData userData){
        return new RegisterPage(driver, userData);
    }

    public static LoginPage startNewLoginTest(WebDriver driver, JSONUserData userData){
        return new LoginPage(driver, userData);
    }

    public static ContactUsNonLoginUserPage startNewContactUsFormNonLoginTest(WebDriver driver, JSONUserData userData){
        return new ContactUsNonLoginUserPage(driver, userData);
    }
    public static ContactUsLoginUserPage startNewContactUsFormLoginTest(WebDriver driver, JSONUserData userData){
        return new ContactUsLoginUserPage(driver, userData);
    }

    public static CustomerInfoPage startNewCustomerInfoTest(WebDriver driver, JSONUserData userData){
        return new CustomerInfoPage(driver, userData);
    }

<<<<<<< HEAD
=======
    public static UserDataRandomizer startRandomizer(){
        return new UserDataRandomizer();
    }
>>>>>>> origin

}

