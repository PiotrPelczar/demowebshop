package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public abstract class ProductAbstract {

    protected WebDriver driver;
    protected JSONProductData productData;

    protected JSONUserData userData;


    public ProductAbstract(WebDriver driver, JSONProductData productData) {
        this.driver = driver;
        this.productData = productData;
        PageFactory.initElements(driver, this);
    }

    public ProductAbstract(WebDriver driver, JSONUserData userData) {
        this.driver = driver;
        this.userData = userData;
        PageFactory.initElements(driver, this);
    }

    public ProductAbstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected JSONProductData getProductData() {
        if (Objects.isNull(this.productData)) {
            throw new IllegalArgumentException("Product data must not be null!");
        }
        return this.productData;
    }

    protected JSONUserData getUserData() {
        if (Objects.isNull(this.userData)) {
            throw new IllegalArgumentException("User data must not be null!");
        }
        return this.userData;
    }
}
