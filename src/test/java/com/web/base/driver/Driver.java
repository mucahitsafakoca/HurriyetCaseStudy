package com.web.base.driver;


import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class Driver {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;

       @BeforeSuite
    public void initializeDriver() {
        // Eğer GitHub Actions ortamındaysak (CI değişkeni her zaman set olur)
        String driverPath = System.getenv("CI") != null
                ? "/usr/local/bin/chromedriver"
                : "web_driver/chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();

        // GitHub Actions (headless) için gerekli bayraklar
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        webDriver = new ChromeDriver(options);

        // Timeout ayarları
        long seconds = 10;
        long milliseconds = 400;
        long timeoutMillis = seconds * 1000 + milliseconds;

        webDriverWait = new WebDriverWait(webDriver, Duration.ofMillis(timeoutMillis));
        webDriverWait
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        webDriver.manage().window().maximize();
        webDriver.navigate().to("https://www.hurriyet.com.tr/");
    }

    @AfterSuite
    public void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
