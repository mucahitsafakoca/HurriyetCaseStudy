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
        webDriver = new ChromeDriver();

        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        webDriverWait.withTimeout(Duration.ofSeconds(30))
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


