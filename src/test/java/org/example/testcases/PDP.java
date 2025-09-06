package org.example.testcases;

import org.example.pages.PDPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;

public class PDP extends BaseTestClass {
    private PDPage pdPage;

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        softAssert = new SoftAssert();
        pdPage = new PDPage(driver);
    }

    @Test
    public void samsungGalaxyS6PDP() {
        header.clickOnHome()
                .clickOnPhones()
                .clickOnSamsungGalaxyS6()
                .clickOnAddToCart();

        softAssert.assertEquals(pdPage.getProductTagName(), PropertyReader.getData("PHONE"));
        softAssert.assertEquals(pdPage.getAlertMessage(), PropertyReader.getAlertMessage("ADD.PRODUCT"));

        softAssert.assertAll();
    }

    @Test
    public void macBookProPDP() {
        header.clickOnHome()
                .clickOnLaptops()
                .clickOnMacBookPro()
                .clickOnAddToCart();

        softAssert.assertEquals(pdPage.getProductTagName(), PropertyReader.getData("LAPTOP"));
        softAssert.assertEquals(pdPage.getAlertMessage(), PropertyReader.getAlertMessage("ADD.PRODUCT"));

        softAssert.assertAll();
    }

    @Test
    public void aSUSFullHDPDP() {
        header.clickOnHome()
                .clickOnMonitors()
                .clickOnASUSFullHD()
                .clickOnAddToCart();

        softAssert.assertEquals(pdPage.getProductTagName(), PropertyReader.getData("MONITOR"));
        softAssert.assertEquals(pdPage.getAlertMessage(), PropertyReader.getAlertMessage("ADD.PRODUCT"));

        softAssert.assertAll();
    }
}
