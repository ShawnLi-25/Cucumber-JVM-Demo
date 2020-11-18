package com.xlxl.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class EmptyListStepDefinitions {
    private Integer val;
    private String actualAnswer;

    @Given("A is a list with {int} elements")
    public void a_is_a_list_with_elements(Integer _val) {
        this.val = _val;
    }

    @When("I ask whether it's an empty list")
    public void i_ask_whether_it_s_empty() {
        actualAnswer = IsItEmpty.isItEmpty(val);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}
