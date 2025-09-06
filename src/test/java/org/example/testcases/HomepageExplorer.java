package org.example.testcases;

import org.example.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomepageExplorer extends BaseTestClass {
    private HomePage homePage;

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        softAssert = new SoftAssert();
        homePage = new HomePage(driver);
    }


    @Test
    public void SlideRightAndLeftArrow() throws InterruptedException {
        header.clickOnHome();
        softAssert.assertTrue(homePage.isFirstSlideDisplayed());
        homePage.rightSlider();
        softAssert.assertTrue(homePage.isSecondSlideDisplayed());
        homePage.rightSlider();
        softAssert.assertTrue(homePage.isThirdSlideDisplayed());
        homePage.leftSlider();
        softAssert.assertTrue(homePage.isSecondSlideDisplayed());

        softAssert.assertAll();
    }

    @Test
    public void Categories() {
        header.clickOnHome()
                .clickOnPhones();
        softAssert.assertTrue(homePage.isSamsungGalaxyS6Exists());
        homePage.clickOnLaptops();
        softAssert.assertTrue(homePage.isMacBookProExists());
        homePage.clickOnMonitors();
        softAssert.assertTrue(homePage.isASUSFullHDExists());
        homePage.clickOnCategories();
        softAssert.assertTrue(homePage.isSamsungGalaxyS6Exists());
        homePage.clickOnNext();
        softAssert.assertTrue(homePage.isMacBookProExists() && homePage.isASUSFullHDExists());

        softAssert.assertAll();
    }
}
