package com.ciclum.steps;

import com.ciclum.pages.RegisterPage;
import com.ciclum.pages.SearchResultPage;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

public class RegisterPageSteps extends Steps {
    static RegisterPage regPage = null;
    static SearchResultPage searchResultPage = new SearchResultPage();


    @When("user goes to register page")
    public void goToRegisterPage() {
        regPage = new RegisterPage();
    }

    @When("user enters first name")
    public void enterFirstName() {
        regPage.enterFirstName("Vasili");
    }

    @When("user enters last name")
    public void enterLastName() {
        regPage.enterLastName("Spirydzionak");
    }

    @When("user enters email")
    public void enterEmail() {
        regPage.enterEmail("Vasili_Spirydzionak@gmail.com");
    }

    @When("user enters password")
    public void enterPassword() {
        regPage.enterPassword("1q2w3e4r5t6y7u8i1q2w");
    }

    @When("user clicks submit button")
    public void userClicksSubmitButton() {
        regPage.clickSubmitButton();
    }

    @When("user clicks first name input")
    public void clickFirstNameInput() {
        regPage.clickFirstNameInput();
    }

    @When("user clicks last name input")
    public void clickLastNameInput() {
        regPage.clickLastNameInput();
    }

    @When("user clicks password input")
    public void clickPasswordInput() {
        regPage.clickPasswordInput();
    }

    @Then("submit button disabled")
    public void checkSubmitDisabled() {
        Assert.assertFalse(regPage.isSubmitDisabled());
    }

    @Then("error messages appear")
    public void checkErrorMessage() {
        Assert.assertTrue(regPage.isErrorMessagesThrown());
    }
}
