package com.deloitte.hackaton;

import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import static com.deloitte.hackaton.utils.TestFactory.*;

public class QuantityOverloadTests extends TestsSetup{

    @Description ("TC 31536. Negative scenario: validate if customer cannot purchase more than 10000 pieces of an item")
    @Test
    void moreThanA1000ItemsAdded(){
        startNewJeweleryTest(driver)
                .goToJewelry()
                .viewBlackWhiteDiamond()
                .addMoreThan10000pieces()
                .validateQtyOverloadMessage();
    }
}
