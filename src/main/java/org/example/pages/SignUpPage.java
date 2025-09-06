package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends Page{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sign-username")
    WebElement inputTextUsername;

    @FindBy(id = "sign-password")
    WebElement inputTextPassword;

    @FindBy(xpath = "//button[contains(text(),'Sign up')]")
    WebElement buttonSignUp;

    public SignUpPage signUp(String username, String password) {
        sendText(inputTextUsername, username);
        sendText(inputTextPassword, password);
        clickElement(buttonSignUp);
        return this;
    }
}
