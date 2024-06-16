package com.proquality;

import com.proquality.pageobjects.LoginForm;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static junit.framework.Assert.assertEquals;

public class StepDefinitions {
    private LoginForm loginForm;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginForm = new LoginForm();
        loginForm.getDriver().get(loginForm.getBaseUrl());
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        loginForm.login("Roman", "Jdi1234");
    }

    @Then("I should be redirected to the home page")
    public void i_should_be_redirected_to_the_home_page() {
        // Implement your check here. This could be checking the URL, or looking for an element that is only present on the home page.
        String expectedTitle = "Home Page";
        String actualTitle = loginForm.getDriver().getTitle();
        assertEquals(expectedTitle, actualTitle);
    }
}