package com.web.base.pages;

import com.web.base.utils.WebTestMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.web.base.driver.Driver.webDriver;

public class SliderPage {
    private static String newWindowUrl;
    private final By rightArrow = By.className("home-carousel__next");
    private final By leftArrow = By.className("home-carousel__prev");
    private final By activeImg = By.cssSelector(".home-carousel.swiper-initialized.swiper-horizontal > .swiper-wrapper > .swiper-slide.swiper-slide-active > a");
    private final By prevImg = By.cssSelector(".home-carousel.swiper-initialized.swiper-horizontal > .swiper-wrapper > .swiper-slide.swiper-slide-prev > a");
    private final By nextImg = By.cssSelector(".home-carousel.swiper-initialized.swiper-horizontal > .swiper-wrapper > .swiper-slide.swiper-slide-next > a");
    private final By thirdIndex = By.xpath("/html/body/div[1]/section[8]/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/span[3]");
    private final WebTestMethods methods;
    private String activeUrl;
    private String nextUrl;

    public SliderPage() {
        this.methods = new WebTestMethods();
    }

    public static void getOpenedUrl() {
        newWindowUrl = webDriver.getCurrentUrl();


    }

    public void checkRightArrowAndClick() {
        WebElement elr = methods.findElement(rightArrow);
        methods.waitUntilElementVisible(elr);
        methods.clickElement(elr);

    }

    public void checkNextNumberAndHover() {
        WebElement el = methods.findElement(thirdIndex);
        methods.waitUntilElementVisible(el);
        methods.hover(el);

    }

    public void checkLeftArrowAndClick() {
        WebElement ell = methods.findElement(leftArrow);
        methods.waitUntilElementVisible(ell);
        methods.clickElement(ell);

    }

    public void saveActiveUrl() {
        WebElement el = methods.findElement(activeImg);
        activeUrl = methods.getAttribute(el, "href");
    }

    public void saveNextUrl() {
        WebElement el = methods.findElement(nextImg);
        nextUrl = methods.getAttribute(el, "href");
    }

    public void savePrevUrl() {
        WebElement el = methods.findElement(prevImg);
        String prevUrl = methods.getAttribute(el, "href");
    }

    public void checkIfSliderChangedAfterRight() {
        Assert.assertEquals("Slider is Not Changed", nextUrl, activeUrl);

    }

    public void checkIfSliderChangedAfterNextNum() {
        Assert.assertEquals("Slider is Not Changed", nextUrl, activeUrl);

    }

    public void checkNextNumberAndClick() throws InterruptedException {
        WebElement el = methods.findElement(thirdIndex);
        methods.clickElement(el);
        Thread.sleep(4000);

    }

    public void areUrlsMatch() {
        getOpenedUrl();
        Assert.assertEquals("Acılan sayfa farkli", newWindowUrl, activeUrl);
    }

}