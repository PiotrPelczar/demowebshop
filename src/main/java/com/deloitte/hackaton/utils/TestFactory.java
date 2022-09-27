package com.deloitte.hackaton.utils;

import com.deloitte.hackaton.data.user.JSONUserData;
import com.deloitte.hackaton.page.RegisterPage;
import org.openqa.selenium.WebDriver;

public class TestFactory {

    public static RegisterPage startNewUserTest(WebDriver driver, JSONUserData userData){
        return new RegisterPage(driver, userData);
    }
}
