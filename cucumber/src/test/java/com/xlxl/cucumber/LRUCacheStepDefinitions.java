package com.xlxl.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LRUCacheStepDefinitions {
    private LRUCache testLRUCache;

    @Given("I have a LRU cache with capacity {int}")
    public void initLRUCache(int capacity) {
        testLRUCache = new LRUCache(capacity);
    }

    @When("I put an entry with key {int} and value {int}")
    public void putEntry(int key, int val) {
        testLRUCache.put(key, val);
    }

    @Then("the cache will have {int} entries")
    public void haveEntry(int expectedSize) {
        assertEquals(expectedSize, testLRUCache.size());
    }

    @Then("I should get {int} with key {int}")
    public void shouldGetEntry(int expectedVal, int key) {
        assertEquals(expectedVal, testLRUCache.get(key));
    }

    @Then("I should not get entry with key {int}")
    public void shouldNotGetEntryWithKey(int key) {
        assertEquals(-1, testLRUCache.get(key));
    }

    @And("the head of the cache will be {int}")
    public void shouldHaveHead(int expectedHead) {
        assertEquals(expectedHead, testLRUCache.head());
    }

    @And("the tail of the cache will be {int}")
    public void shouldHaveTail(int expectedTail) {
        assertEquals(expectedTail, testLRUCache.tail());
    }
}

