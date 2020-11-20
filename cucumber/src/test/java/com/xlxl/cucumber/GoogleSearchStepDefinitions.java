package com.xlxl.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.junit.Assert;

public class GoogleSearchStepDefinitions {
    private final SearchResultPage page;

    static {
        // Set system property to use chromedriver properly
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
    }

    public GoogleSearchStepDefinitions() {
        this.page = new SearchResultPage();
    }

    @Before("@selenium")
    public void createDriver() {
        page.createDriver();
    }

    @Given("I am on the Google search page")
    public void visitGoogle() {
        this.page.getDriver().get("https://www.google.com");
    }

    @When("I search for {string}")
    public void searchFor(String query) {
        WebElement element = this.page.getDriver().findElement(By.name("q"));
        element.sendKeys(query);
        element.submit();
        sleep();
    }

    @Then("The page title should start with {string}")
    public void checkTitle(String titleStartsWith) {
        Assert.assertTrue(this.page.ifStartWith(titleStartsWith));
    }

    @Then("{string} is displayed in any of the first {int} results with title selector {string}")
    public void isDisplayedInResults(String expectedResult, int numOfResultsToSearch, String titleSelector) {
        Assert.assertTrue(this.page.ifInResults(expectedResult, numOfResultsToSearch, titleSelector));
    }

    @After("@selenium")
    public void closeBrowser() {
        this.page.getDriver().quit();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Sleep error?" + e);
        }
    }
}
