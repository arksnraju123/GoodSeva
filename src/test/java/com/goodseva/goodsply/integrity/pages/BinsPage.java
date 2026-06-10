package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BinsPage extends DriverUtils {
    public BinsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[text()='Saved Bins']/span")
    private WebElement totalBins;

    public String getTotalBins() throws InterruptedException {
        Thread.sleep(2000);
        return getText(totalBins, "Total Bins").replaceAll("\\D+", "");
    }
}
