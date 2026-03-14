package org.example.pages;

import org.example.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage login(String accountNumber, String password) {
        WebElement inputAccountNumber = driver.findElement(Locators.LoginPage.ACCOUNT_NUMBER_INPUT);
        WebElement inputPassword = driver.findElement(Locators.LoginPage.PASSWORD_INPUT);
        inputAccountNumber.sendKeys(accountNumber);
        inputPassword.sendKeys(password);
        WebElement loginButton = driver.findElement(Locators.LoginPage.LOGIN_BUTTON);
        loginButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> d.findElement(Locators.LoginPage.NOT_CORRECT_LOGIN_DATA_PANEL).isDisplayed());
        return this;
    }

    public String getHeaderText() {
        return driver.findElement(Locators.LoginPage.HEADER_PANEL).getText();
    }

    public String getNotCorrectLoginText() {
        return driver.findElement(Locators.LoginPage.NOT_CORRECT_LOGIN_DATA_PANEL).getText();
    }
}
