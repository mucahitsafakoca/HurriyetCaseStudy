package com.web.base.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.time.Duration;

public class Driver {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;

    @BeforeSuite
    public void initializeDriver() {
        String driverPath = System.getenv("CI") != null
                ? "/usr/local/bin/chromedriver"
                : "web_driver/chromedriver";

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();

        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        webDriver = new ChromeDriver(options);

        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

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
