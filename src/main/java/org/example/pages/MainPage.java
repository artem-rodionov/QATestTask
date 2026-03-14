package org.example.pages;

import org.example.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage() {
        WebElement loginButton = driver.findElement(Locators.MainPage.LOGIN_BUTTON);
        loginButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> {
            for (String handle : d.getWindowHandles()) {
                d.switchTo().window(handle);
                if (d.getCurrentUrl().contains("login")) {
                    return true;
                }
            }
            return false;
        });
        return new LoginPage(driver);
    }

    public SpeedTestPage goToSpeedTestPage() {
        WebElement speedTestLink = driver.findElement(Locators.MainPage.SPEEDTEST_LINK);
        speedTestLink.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> {
            for (String handle : d.getWindowHandles()) {
                d.switchTo().window(handle);
                if (d.getCurrentUrl().contains("speedtest")) {
                    return true;
                }
            }
            return false;
        });
        return new SpeedTestPage(driver);
    }

    public DocumentationPage goToDocumentationPage() {
        WebElement documentationPage = driver.findElement(Locators.MainPage.DOCUMENTATION_LINK);
        documentationPage.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> {
            for (String handle : d.getWindowHandles()) {
                d.switchTo().window(handle);
                if (d.getCurrentUrl().contains("docs")) {
                    return true;
                }
            }
            return false;
        });
        return new DocumentationPage(driver);
    }
}
