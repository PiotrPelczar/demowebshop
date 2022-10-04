package com.deloitte.hackaton;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import static com.deloitte.hackaton.utils.TestFactory.*;

public class RecentlyViewedProductsTestSuite extends TestsSetup{

    @Description "TC 31528. Find recently viewed products"
    @Test
    void findRecentlyViewedProducts() {
        startNewJeweleryTest(driver)
                .goToJewelry()
                .blackWhiteDiamond()
                .diamondBracelet()
                .diamondEarrings()
                .vintageRing()
                .presenceOfRecentlyViewdItems();

    }

}
