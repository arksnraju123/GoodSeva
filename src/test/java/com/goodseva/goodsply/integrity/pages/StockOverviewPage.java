package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StockOverviewPage extends DriverUtils {
    public StockOverviewPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//p[text()='Total Quantity']/following-sibling::p")
    private WebElement totalQuantity;

    public String getTotalQuantity() throws InterruptedException {
        Thread.sleep(3000);
        return getText(totalQuantity, "Total Quantity").replaceAll("\\D+", "");
    }
}
