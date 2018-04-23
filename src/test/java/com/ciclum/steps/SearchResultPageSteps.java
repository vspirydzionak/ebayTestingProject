package com.ciclum.steps;

import com.ciclum.pages.AbstractPage;
import com.ciclum.pages.SearchResultPage;
import com.ciclum.pages.StartPage;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

import static org.hamcrest.Matchers.greaterThan;

public class SearchResultPageSteps extends Steps{

    static StartPage startPage = null;
    static SearchResultPage searchResultPage = new SearchResultPage();

    @Given("user goes to start page '$url'")
    public void userGoersToStartPage(String url) {
        startPage = new StartPage();
        startPage.openPage("https://www.ebay.com");
    }

    @When("user selects books category")
    public void selectBookCategory() {
        startPage.selectCategory();
    }

    @When("user search '$bookTitle'")
    public void searchBookByTitle(String bookTitle) {
        searchResultPage = startPage.enterBookName();
    }

    @When("user clicks register link")
    public void clickRegister() {
        searchResultPage.clickRegisterLink();
    }

    @Then("the first price is higher than $priceExpected USD")
    public void verifyTheFirstPrice(Long priceExpected) {
        searchResultPage =new SearchResultPage();
        Long priceFound = searchResultPage.getFirstPrice();
        Assert.assertThat(priceFound, greaterThan(priceExpected));
    }

    @Then("system shows username '$userName'")
    public void systemShowsUserName(String userName){
        Assert.assertEquals(userName, searchResultPage.getUserName());
    }
}
