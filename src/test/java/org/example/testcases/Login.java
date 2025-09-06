package org.example.testcases;

import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.FakeDataGenerator;
import utilities.PropertyReader;

public class Login extends BaseTestClass {
    private LoginPage loginPage;
    private final FakeDataGenerator fakeDataGenerator = new FakeDataGenerator();

    @Override
    @BeforeMethod
    void beforeMethod() {
        super.beforeMethod();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyFields() {
        header.clickOnLogin()
                .login("", "");

        Assert.assertEquals(loginPage.getAlertMessage(), PropertyReader.getAlertMessage("EMPTY.LOGIN"));
    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword() {
        String validUsername = fakeDataGenerator.getUsername();

        header.clickOnSignUp()
                .signUp(validUsername, fakeDataGenerator.getPassword())
                .acceptAlert()
                .clickOnLogin()
                .login(validUsername, fakeDataGenerator.getPassword());

        Assert.assertEquals(loginPage.getAlertMessage(), PropertyReader.getAlertMessage("WRONG.PASSWORD.LOGIN"));
    }

    @Test
    public void loginWithInvalidUsername() {
        header.clickOnLogin()
                .login(fakeDataGenerator.getUsername(),fakeDataGenerator.getPassword());

        Assert.assertEquals(loginPage.getAlertMessage(), PropertyReader.getAlertMessage("INVALID.LOGIN"));
    }

    @Test
    public void validLogin() {
        String validUsername = fakeDataGenerator.getUsername();
        String validPassword = fakeDataGenerator.getPassword();

        header.clickOnSignUp()
                .signUp(validUsername, validPassword)
                .acceptAlert()
                .clickOnLogin()
                .login(validUsername, validPassword);

        Assert.assertTrue(header.isWelcomeUserDisplayed() && header.isLogoutDisplayed());
    }

    @Test
    public void logout() {
        String validUsername = fakeDataGenerator.getUsername();
        String validPassword = fakeDataGenerator.getPassword();

        header.clickOnSignUp()
                .signUp(validUsername, validPassword)
                .acceptAlert()
                .clickOnLogin()
                .login(validUsername, validPassword);
        header.clickOnLogout();

        Assert.assertTrue(header.isLoginDisplayed() && header.isSignUpDisplayed());
    }
}
