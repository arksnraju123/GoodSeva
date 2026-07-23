package com.goodseva.goodsply.velocity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PublishTripPage extends DriverUtils {
    public PublishTripPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }



}
