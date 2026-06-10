package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FacilitiesPage extends DriverUtils {
    public FacilitiesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Click on a facility')]/preceding::div[1]")
    private WebElement totalFacilities;

    public String getTotalFacilities() throws InterruptedException {
        Thread.sleep(2000);
        return getText(totalFacilities, "Total Facilities").replaceAll("\\D+", "");
    }
}
