package com.web.base.utils;


import com.web.base.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTestMethods extends Driver {
    private final WebDriver driver;
    private final WebDriverWait wait;


    public WebTestMethods() {
        driver = Driver.webDriver;
        wait = Driver.webDriverWait;
    }

    public WebElement findElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void scrollDownByAmount(int yOffset) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0," + yOffset + ");", "");
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getAttribute(WebElement element, String name) {
        waitUntilElementVisible(element);
        return element.getAttribute(name);

    }

    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
