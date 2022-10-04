package com.deloitte.hackaton;

import org.junit.jupiter.api.*;
import static com.deloitte.hackaton.utils.TestFactory.*;

public class RecentlyViewedProductsTestSuite extends TestsSetup{
    @Test
    void buyAProductAsRegistered() {
        startNewJeweleryTest(driver)
                .goToJewelry()
                .blackWhiteDiamond()
                .diamondBracelet()
                .diamondEarrings()
                .vintageRing()
                .presenceOfRecentlyViewdItems();

    }

}
