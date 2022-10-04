package com.deloitte.hackaton;

import org.junit.jupiter.api.*;
import static com.deloitte.hackaton.utils.TestFactory.*;

public class QuantityOverloadTestSuite extends TestsSetup{
    @Test
    void moreThanA1000ItemsAdded(){
        startNewJeweleryTest(driver)
                .goToJewelry()
                .viewBlackWhiteDiamond()
                .addMoreThan10000pieces()
                .validateQtyOverloadMessage();
    }
}
