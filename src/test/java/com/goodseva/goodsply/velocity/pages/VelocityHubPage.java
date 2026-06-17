package com.goodseva.goodsply.velocity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class VelocityHubPage extends DriverUtils {
    public VelocityHubPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickOnEachLink(WebElement element, String message) {
        click(element, message);
    }
}
