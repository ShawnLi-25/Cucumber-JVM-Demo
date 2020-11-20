package com.xlxl.cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.IntStream;

public class SearchResultPage {
    private WebDriver driver;

    SearchResultPage() {}

    public boolean ifStartWith(String title) {
        return new WebDriverWait(driver,5L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title);
            }
        });
    }

    public boolean ifInResults(String expectedTitle, int numOfResultsToSearch, String titleSelector) {
        List<WebElement> results = driver.findElements(By.cssSelector(titleSelector));
        System.out.println(titleSelector + "Log:" + results.size());
        new WebDriverWait(driver,8L).until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(titleSelector)));

        String matchStr = expectedTitle.substring(0, 1).toUpperCase() + expectedTitle.substring(1).toLowerCase();
        return IntStream.range(0, Math.min(results.size(), numOfResultsToSearch))
                .anyMatch(index -> results.get(index).getText().contains(matchStr));
    }

    public void createDriver() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

