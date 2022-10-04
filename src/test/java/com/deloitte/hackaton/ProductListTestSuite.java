package com.deloitte.hackaton;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;

import static com.deloitte.hackaton.utils.TestFactory.*;

public class ProductListTestSuite extends TestsSetup{

    @Description "TC 31530. Product list tests"
    @Test
    void productListTests(){
        startBooksTest(driver)
                .getToBooksPage()
                .changeViewList()
                .changeViewGrid()
                .displayingDifferentNoOfProducts()
                .sortAZ()
                .sortZA()
                .priceLH()
                .priceHL()
                .filter();
    }
}
