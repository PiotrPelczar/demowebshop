package com.deloitte.hackaton.utils;

import com.deloitte.hackaton.data.user.JSONUserData;
import com.deloitte.hackaton.data.user.UserDataRandomizer;
import com.deloitte.hackaton.page.CustomerInfoPage;
import com.deloitte.hackaton.page.LoginPage;
import com.deloitte.hackaton.page.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestFactory {

    public static RegisterPage startNewUserTest(WebDriver driver, JSONUserData userData){
        return new RegisterPage(driver, userData);
    }

    public static LoginPage startNewLoginTest(WebDriver driver, JSONUserData userData){
        return new LoginPage(driver, userData);
    }

    public static CustomerInfoPage startNewCustomerInfoTest(WebDriver driver, JSONUserData userData){
        return new CustomerInfoPage(driver, userData);
    }

    public static UserDataRandomizer startRandomizer(){
        return new UserDataRandomizer();
    }

}

