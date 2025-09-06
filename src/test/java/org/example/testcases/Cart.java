package org.example.testcases;

import org.example.pages.CartPage;
import org.example.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.FakeDataGenerator;
import utilities.PropertyReader;
import java.util.HashMap;

public class Cart extends BaseTestClass {
    private CartPage cartPage;
    private HomePage homePage;
    private final FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void cartTest() throws InterruptedException {
        HashMap<String, String> data;
        data = fakeDataGenerator.getPlaceOrderData();

        header.clickOnHome()
                .clickOnPhones()
                .clickOnSamsungGalaxyS6()
                .clickOnAddToCart()
                .acceptAlert()
                .clickOnHome()
                .clickOnLaptops()
                .clickOnMacBookPro()
                .clickOnAddToCart()
                .acceptAlert()
                .clickOnHome()
                .clickOnMonitors()
                .clickOnASUSFullHD()
                .clickOnAddToCart()
                .acceptAlert()
                .clickOnCart();
        softAssert.assertEquals(cartPage.getActualPrice(), cartPage.getExpectedPrice());

        cartPage.deleteProduct();
        softAssert.assertTrue(cartPage.isProductDeleted());

        cartPage.clickOnPlaceOrder()
                .enterPlaceOrderData(data.get("NAME"), data.get("COUNTRY"), data.get("CITY"),
                        data.get("CARD"), data.get("MONTH"), data.get("YEAR"))
                .clickOnPurchase();
        softAssert.assertEquals(cartPage.getSuccessMessage(), PropertyReader.getAlertMessage("SUCCESSFUL.PURCHASE"));
        softAssert.assertTrue(cartPage.areTheRightDataAppear(data.get("CARD"), data.get("NAME")));

        cartPage.clickOnOk();
        softAssert.assertEquals(homePage.getUrl(), PropertyReader.getData("HOME.URL"));
        softAssert.assertAll();
    }
}
