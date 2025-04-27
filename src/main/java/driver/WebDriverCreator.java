package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverCreator {

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        switch (browser) {
            case "chrome":
                return createChromeDriver();
            case "yandex":
                return createYandexDriver();
            default:
                throw new IllegalArgumentException("Браузер -> " + browser + " не поддерживается");
        }
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        // Настраиваем ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        return new ChromeDriver(options);
    }


    private static WebDriver createYandexDriver() {
        WebDriverManager yandexManager = WebDriverManager.getInstance("yandexdriver");
        yandexManager.setup();

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\user\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}