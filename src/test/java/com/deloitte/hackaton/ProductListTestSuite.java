package com.deloitte.hackaton;
import org.junit.jupiter.api.*;

import static com.deloitte.hackaton.utils.TestFactory.*;

public class ProductListTestSuite extends TestsSetup{
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
