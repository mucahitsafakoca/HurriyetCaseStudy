package com.web.base.driver;

import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            options.addArguments("--disable-extensions");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-debugging-port=9222");
            options.addArguments("--disable-software-rasterizer");
            options.addArguments("--disable-dev-tools");
            options.addArguments("--disable-translate");
            options.addArguments("--disable-background-networking");
            options.addArguments("--mute-audio");
        }

        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait.pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        if (System.getenv("CI") == null) {
            webDriver.manage().window().maximize();
        }

        webDriver.navigate().to("https://www.hurriyet.com.tr/");
        System.out.println("✅ WebDriver initialized successfully.");
    }

    @AfterSuite
    public void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();
            System.out.println("🧹 WebDriver closed successfully.");
        }
    }
}
