package com.web.base.pages;

import com.web.base.utils.WebTestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class HomePage extends WebTestMethods {

    private final WebTestMethods methods;

    private final By homePageTitle = By.className("header__logo--img");

    public HomePage() {
        methods = new WebTestMethods();
    }

    public void checkHomePage() {

        WebElement el = methods.findElement(homePageTitle);
        methods.waitUntilElementVisible(el);
        System.out.println("Homepage in acildigi goruldu");
    }

    public void scrollDownByAmount(int i) {
        methods.scrollDownByAmount(i);
    }


    public void chromeFocusTabWithNumber(int number) {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(number - 1));
    }

}
