package org.example.utils;

import org.openqa.selenium.By;

public interface Locators {
    interface MainPage {
        By LOGIN_BUTTON = By.xpath("//*[@id=\"__nuxt\"]/div[2]/header/div[2]/div[2]/div/div/div[2]/div[1]/div/div/a[1]");
        By SPEEDTEST_LINK = By.xpath("//*[@id=\"__nuxt\"]/div[2]/header/div[2]/div[1]/div/div/div/ul[1]/li[2]/a");
        By DOCUMENTATION_LINK = By.xpath("//*[@id=\"__nuxt\"]/div[2]/header/div[2]/div[2]/div/div/nav/ul[1]/li[5]/a");
    }

    interface LoginPage {
        By HEADER_PANEL = By.xpath("/html/body/my-bootstrap/panel-auth-layout/my-login/panel-auth-layout-container/div[1]/h3");
        By NOT_CORRECT_LOGIN_DATA_PANEL = By.xpath("//*[@id=\"login-form\"]/div/nz-alert/div/div/span/div");
        By ACCOUNT_NUMBER_INPUT = By.xpath("//*[@id=\"username\"]");
        By PASSWORD_INPUT = By.xpath("//*[@id=\"current-password\"]");
        By LOGIN_BUTTON = By.xpath("//*[@id=\"login-form\"]/button");
    }

    interface SpeedTestPage {
        By HEADER_PANEL = By.xpath("/html/body/main/div/div[1]/h1");
        By RUN_SPEEDTEST_BUTTON = By.xpath("//*[@id=\"startStopBtn\"]");
        By DOWNLOADING_TEXT = By.xpath("//*[@id=\"dlText\"]");
        By LOADING_TEXT = By.xpath("//*[@id=\"ulText\"]");
    }

    interface DocumentationPage {
        By HEADER_PANEL = By.xpath("//*[@id=\"__docusaurus_skipToContent_fallback\"]/main/div[1]/div/div[2]/h1");
        By SEARCH_BUTTON = By.xpath("//*[@id=\"__docusaurus\"]/nav/div[1]/div[2]/div[4]");
        By SEARCH_BAR = By.xpath("//*[@id=\"__docusaurus\"]/nav/div[1]/div[2]/div[4]/div/dialog/div/div/div/input");
        By SEARCH_RESULT_LINK = By.xpath("//*[@id=\"__docusaurus\"]/nav/div[1]/div[2]/div[4]/div/dialog/div/footer/a");
    }
}
