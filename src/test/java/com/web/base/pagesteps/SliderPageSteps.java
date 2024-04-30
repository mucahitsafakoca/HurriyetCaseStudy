package com.web.base.pagesteps;

import com.thoughtworks.gauge.Step;
import com.web.base.pages.SliderPage;

public class SliderPageSteps {

    private final SliderPage sliderPage;

    public SliderPageSteps() {
        this.sliderPage = new SliderPage();
    }

    @Step("Check If right Arrow Visibile and click")
    public void clickRightArrow() {
        sliderPage.checkRightArrowAndClick();
    }

    @Step("Check If left Arrow Visibile and click")
    public void clickLeftArrow() {
        sliderPage.checkLeftArrowAndClick();
    }

    @Step("Save Active Slider Url")
    public void saveActiveUrl() {
        sliderPage.saveActiveUrl();

    }

    @Step("Save Next Slider Url")
    public void saveNextUrl() {
        sliderPage.saveNextUrl();

    }

    @Step("Save Prev Slider Url")
    public void savePrevUrl() {
        sliderPage.savePrevUrl();

    }

    @Step("Check if slider changed after right")
    public void checkIfSliderChangedAfterRight() {
        sliderPage.checkIfSliderChangedAfterRight();
    }

    @Step("Check if slider changed after next num")
    public void checkIfSliderChangedNextNum() {
        sliderPage.checkIfSliderChangedAfterNextNum();
    }

    @Step("Check if next number visible and hover")
    public void hoverNextNumber() {
        sliderPage.checkNextNumberAndHover();

    }

    @Step("Click active slider number")
    public void clickActiveSliderNum() throws InterruptedException {
        sliderPage.checkNextNumberAndClick();

    }

    @Step("Check if Urls are matched")
    public void urlCheck() {
        sliderPage.areUrlsMatch();

    }
}
