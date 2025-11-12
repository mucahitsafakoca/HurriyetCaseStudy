package com.web.base.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class Driver {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;

    @BeforeSuite
    public void initializeDriver() {
        // GitHub Actions ortamında CI değişkeni set edilir
        String driverPath = System.getenv("CI") != null
                ? "/usr/local/bin/chromedriver"
                : "web_driver/chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);

        // ChromeOptions import'u eklendi
        ChromeOptions options = new ChromeOptions();

        // CI ortamında headless mod aktif
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        webDriver = new ChromeDriver(options);

        // WebDriverWait — Duration ile kullanılmalı (Selenium 4+)
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait.pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        // Headless dışı ortamlarda pencereyi büyüt
        if (System.getenv("CI") == null) {
            webDriver.manage().window().maximize();
        }

        webDriver.navigate().to("https://www.hurriyet.com.tr/");
    }

    @AfterSuite
    public void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
