package org.example.pages;

import org.example.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentationPage {
    private WebDriver driver;

    public DocumentationPage(WebDriver driver) {
        this.driver = driver;
    }

    public DocumentationPage enterToSearchBar(String searchText) {
        WebElement searchButton = driver.findElement(Locators.DocumentationPage.SEARCH_BUTTON);
        searchButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.findElement(Locators.DocumentationPage.SEARCH_BAR).isDisplayed());
        WebElement searchBar = driver.findElement(Locators.DocumentationPage.SEARCH_BAR);
        searchBar.sendKeys(searchText);
        return this;
    }

    public int getCountOfResults() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.findElement(Locators.DocumentationPage.SEARCH_RESULT_LINK).isDisplayed());
        WebElement searchResultCount = driver.findElement(Locators.DocumentationPage.SEARCH_RESULT_LINK);
        String result = searchResultCount.getText();
        int openIndex = result.indexOf('(');
        int closeIndex = result.lastIndexOf(')');
        String closeText = result.substring(openIndex + 1, closeIndex).trim();
        return Integer.parseInt(closeText);
    }

    public String getHeaderText() {
        return driver.findElement(Locators.DocumentationPage.HEADER_PANEL).getText();
    }
}
