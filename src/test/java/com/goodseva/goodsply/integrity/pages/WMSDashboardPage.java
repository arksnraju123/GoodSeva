package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WMSDashboardPage extends DriverUtils {
    public WMSDashboardPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//p[text()='Facilities']/following::p[1]")
    private WebElement totalFacilities;

    @FindBy(how = How.XPATH, using = "//p[text()='Zones']/following::p[1]")
    private WebElement totalZones;

    @FindBy(how = How.XPATH, using = "//p[text()='Bins']/following::p[1]")
    private WebElement totalBins;

    @FindBy(how = How.XPATH, using = "//p[text()='Products']/following::p[1]")
    private WebElement totalProducts;

    @FindBy(how = How.XPATH, using = "//p[text()='Total Inventory']/following::p[1]")
    private WebElement totalInventory;

    public String getTotalFacilities() {
        return getText(totalFacilities, "Total Facilities");
    }

    public String getTotalZones() {
        return getText(totalZones, "Total Zones");
    }

    public String getTotalBins() {
        return getText(totalBins, "Total Bins");
    }

    public String getTotalProducts() {
        return getText(totalProducts, "Total Products");
    }

    public String getTotalInventory() {
        return getText(totalInventory, "Total Inventory").split("\\.")[0];
    }

    public void clickOnEachLink(WebElement element, String message) {
        click(element, message);
    }
}
