package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.user.JSONUserData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.startNewUserTest;

public class RegisterTestSuite {

    WebDriver driver;

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/register");
        WebElement element = driver.findElement(By.xpath("//form[@action=\"/register\"]//input[@value=\"M\"]"));
        element.click();
    }

    @BeforeEach
    void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/aromanowski/Desktop/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @ParameterizedTest
    @MethodSource(value = "usersDataStream")
    void register(JSONUserData userData){
       startNewUserTest(driver, userData)
               .openRegisterPage()
               .selectGender()
               .typeFirstName()
               .typeLastName()
               .typeEmail()
               .typePassword()
               .repeatPassword()
               .register()
               .verifyRegistration()
               .logOut()
               .verifyIfLoggedOut();
    }

    private static Stream<JSONUserData> usersDataStream() {
        return JSONDataReader.readUsers().getUsers().stream();
    }
}
