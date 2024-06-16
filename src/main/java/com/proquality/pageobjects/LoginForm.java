package com.proquality.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends BasePage {
    @FindBy(css = "input#name")
    WebElement usernameField;

    @FindBy(css = "input#password")
    WebElement passwordField;

    @FindBy(css = "button#login-button")
    WebElement submitButton;

    @FindBy(css = ".dropdown.uui-profile-menu")
    WebElement loginDropdown;

    /* public LoginForm() {
        super();
    }

     */

    public void clickUserIcon() {
        loginDropdown.click();
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void login(String username, String password) {
        clickUserIcon();
        enterUsername(username);
        enterPassword(password);
        clickSubmit();
    }
}