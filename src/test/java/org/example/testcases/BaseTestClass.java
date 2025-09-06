package org.example.testcases;

import org.example.pages.Header;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utilities.PropertyReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class BaseTestClass {
    static WebDriver driver;
    public SoftAssert softAssert;
    public Header header;

    @BeforeMethod
    void beforeMethod() {
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to(PropertyReader.getProperty("BASE.URL"));

        header = new Header(driver);
    }

    @AfterMethod
    void afterMethod(){ WebDriverFactory.stopDriver(); }
}
