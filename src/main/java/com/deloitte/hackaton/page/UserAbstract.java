package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.user.JSONUserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.Objects;

public abstract class UserAbstract extends BaseUrl{

    protected WebDriver driver;
    protected JSONUserData userData;

    public UserAbstract(WebDriver driver, JSONUserData userData){
        this.driver = driver;
        this.userData = userData;
        PageFactory.initElements(driver, this);
    }

    protected JSONUserData getUserData() {
        if (Objects.isNull(this.userData)) {
            throw new IllegalArgumentException("User data must not be null!");
        }
        return this.userData;
    }
}
