package com.web.base.pagesteps;

import com.thoughtworks.gauge.Step;
import com.web.base.pages.HomePage;


public class HomepageSteps {
    private final HomePage homePage;

    public HomepageSteps() {
        this.homePage = new HomePage();
    }

    @Step("Check If HomePageTitle Visible")
    public void checkElementVisibility() {
        homePage.checkHomePage();
    }

    @Step("Scroll a bit")
    public void scrollBit() {
        homePage.scrollDownByAmount(500);
    }

    @Step("Switch to new window")
    public void goToNextWindow() {
        homePage.chromeFocusTabWithNumber(2);
    }
}
