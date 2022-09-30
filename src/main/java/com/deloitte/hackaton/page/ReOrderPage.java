package com.deloitte.hackaton.page;

import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import org.openqa.selenium.WebDriver;

public class ReOrderPage extends ProductAbstract{
    JSONUserData userData;

    public ReOrderPage(WebDriver driver, JSONProductData productData, JSONUserData userData ) {
        super(driver, productData);
        this.userData = userData;
    }
}
