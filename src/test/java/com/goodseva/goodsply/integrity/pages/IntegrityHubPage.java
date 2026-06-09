package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IntegrityHubPage extends DriverUtils {
    public IntegrityHubPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@data-testid='tab-storage']")
    private WebElement storageTab;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='tab-outbound']")
    private WebElement outBoundTab;

    public void clickOnEachLink(WebElement element, String message) {
        click(element, message);
    }

    public void clickOnStorageTab() {
        click(storageTab, "Storage tab");
    }

    public void clickOnOutboundTab() {
        click(outBoundTab, "Outbound tab");
    }
}
