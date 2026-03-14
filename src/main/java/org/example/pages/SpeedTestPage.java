package org.example.pages;

import org.example.utils.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpeedTestPage {
    private WebDriver driver;

    public SpeedTestPage(WebDriver driver) {
        this.driver = driver;
    }

    public SpeedTestPage runSpeedTest() {
        WebElement buttonRun = driver.findElement(Locators.SpeedTestPage.RUN_SPEEDTEST_BUTTON);
        buttonRun.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(d -> d.findElement(Locators.SpeedTestPage.RUN_SPEEDTEST_BUTTON).getAttribute("class").equals("ui-button"));
        return this;
    }

    public SpeedTestPage runAndStopSpeedTest() {
        WebElement buttonRun = driver.findElement(Locators.SpeedTestPage.RUN_SPEEDTEST_BUTTON);
        buttonRun.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(d -> d.findElement(Locators.SpeedTestPage.RUN_SPEEDTEST_BUTTON).getAttribute("class").equals("ui-button running"));
        buttonRun.click();
        return this;
    }

    public String getLoadSpeed() {
        return driver.findElement(Locators.SpeedTestPage.LOADING_TEXT).getText();
    }

    public String getDownLoadSpeed() {
        return driver.findElement(Locators.SpeedTestPage.DOWNLOADING_TEXT).getText();
    }

    public String getButtonText() {
        return driver.findElement(Locators.SpeedTestPage.RUN_SPEEDTEST_BUTTON).getText();
    }

    public String getHeaderText() {
        return driver.findElement(Locators.SpeedTestPage.HEADER_PANEL).getText();
    }
}
