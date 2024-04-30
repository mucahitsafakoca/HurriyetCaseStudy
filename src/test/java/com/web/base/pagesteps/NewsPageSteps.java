package com.web.base.pagesteps;

import com.thoughtworks.gauge.Step;
import com.web.base.pages.NewsPage;

public class NewsPageSteps {

    @Step("Check if new openned page has 200 status code")
    public void statusCheck() {
        NewsPage.statusCheck();

    }
}
