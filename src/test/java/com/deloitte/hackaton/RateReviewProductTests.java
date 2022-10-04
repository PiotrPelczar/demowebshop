package com.deloitte.hackaton;

import com.deloitte.hackaton.data.JSONDataReader;
import com.deloitte.hackaton.data.product.JSONProductData;
import com.deloitte.hackaton.data.user.JSONUserData;
import io.qameta.allure.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static com.deloitte.hackaton.utils.TestFactory.startNewProductTest;
import static com.deloitte.hackaton.utils.TestFactory.startNewReviewProductTest;

public class RateReviewProductTests extends TestsSetup{

    @Description ("TC 31533. Rate a product review")
    @ParameterizedTest
    @MethodSource("productsDataStream")
    void reviewsProduct(JSONProductData productData) throws InterruptedException {
        JSONUserData userData = JSONDataReader.readUsers().getUsers().get(0);
        startNewProductTest(driver, productData, userData)
                .login()
                .openLoginPage()
                .typeEmail()
                .typePassword()
                .logIn()
                .verifyLogin();
        Thread.sleep(1000);

        startNewProductTest(driver, productData, userData)
                .openProductPage()
                .goToReviewPage();

        startNewReviewProductTest(driver, productData, userData)
                .findAnyReview()
                .clickYseAndCheckCountOfVote();
    }

    private static Stream<JSONProductData> productsDataStream() {
        return JSONDataReader.readProducts().getProducts().stream();
    }
}
