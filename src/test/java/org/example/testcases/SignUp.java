package org.example.testcases;

import org.example.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.FakeDataGenerator;
import utilities.PropertyReader;

public class SignUp extends BaseTestClass {
    private SignUpPage signUpPage;
    private final FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();


    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        signUpPage = new SignUpPage(driver);
    }

    @Test()
    public void validSingUp() {
        header.clickOnSignUp()
                .signUp(fakeDataGenerator.getUsername(), fakeDataGenerator.getPassword());

        Assert.assertEquals(signUpPage.getAlertMessage(), PropertyReader.getAlertMessage("VALID.SIGN.UP"));
    }

    @Test()
    public void singUpWithUsedUsername() {
        String validUsername = fakeDataGenerator.getUsername();

        header.clickOnSignUp()
                .signUp(validUsername, fakeDataGenerator.getPassword())
                .acceptAlert()
                .clickOnSignUp()
                .signUp(validUsername, fakeDataGenerator.getPassword());

        Assert.assertEquals(signUpPage.getAlertMessage(), PropertyReader.getAlertMessage("USED.SIGN.UP"));
    }

    @Test()
    public void singUpWithEmptyFields() {
        header.clickOnSignUp()
                .signUp("", "");

        Assert.assertEquals(signUpPage.getAlertMessage(), PropertyReader.getAlertMessage("EMPTY.SIGN.UP"));
    }

}
