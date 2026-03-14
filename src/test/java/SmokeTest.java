import org.apache.commons.lang3.RandomStringUtils;
import org.example.pages.DocumentationPage;
import org.example.pages.MainPage;
import org.example.pages.SpeedTestPage;
import org.example.utils.Locators;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTest {
    private WebDriver driver;

    @BeforeEach
    public void preparation() {
        String baseUrl = "https://selectel.ru/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }

    @Test
    public void testOpenLoginPage() {
        MainPage mainPage = new MainPage(driver);
        String headerText = mainPage.goToLoginPage().getHeaderText();

        assertEquals("Вход в панель управления", headerText);
    }

    @Test
    public void testNotCorrectLoginDataOnLoginPage() {
        MainPage mainPage = new MainPage(driver);
        String headerText = mainPage
                .goToLoginPage()
                .login(RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(5))
                .getNotCorrectLoginText();

        assertEquals("Номер аккаунта, почта или пароль указаны неверно", headerText);
    }

    @Test
    public void testOpenSpeedTestPage() {
        MainPage mainPage = new MainPage(driver);
        String headerText = mainPage
                .goToSpeedTestPage()
                .getHeaderText();

        assertEquals("Selectel Speedtest", headerText);
    }

    @Test
    public void testTrySpeedTestAndGetResult() {
        MainPage mainPage = new MainPage(driver);
        SpeedTestPage page = mainPage
                .goToSpeedTestPage()
                .runSpeedTest();

        String loadSpeed = page.getLoadSpeed();
        String downLoadSpeed = page.getDownLoadSpeed();

        assertTrue(Double.parseDouble(loadSpeed) > 0);
        assertTrue(Double.parseDouble(downLoadSpeed) > 0);
    }

    @Test
    public void testTrySpeedTestAndTryToStop() {
        MainPage mainPage = new MainPage(driver);
        SpeedTestPage page = mainPage
                .goToSpeedTestPage()
                .runAndStopSpeedTest();

        String loadSpeed = page.getLoadSpeed();
        String downLoadSpeed = page.getDownLoadSpeed();

        assertEquals("", loadSpeed);
        assertEquals("", downLoadSpeed);
    }

    @Test
    public void testOpenDocumentationPage() {
        MainPage mainPage = new MainPage(driver);
        String headerText = mainPage
                .goToDocumentationPage()
                .getHeaderText();

        assertEquals("Документация", headerText);
    }

    @Test
    public void testDocumentationPageTryToSearchDDOSAndGetNotZeroResult() {
        MainPage mainPage = new MainPage(driver);
        int countOfResults = mainPage
                .goToDocumentationPage()
                .enterToSearchBar("DDOS")
                .getCountOfResults();

        assertTrue(countOfResults > 0);
    }
}
