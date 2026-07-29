package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CommonPage extends DriverUtils {

    public CommonPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-next-page']")
    private WebElement nextBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-prev-page']")
    private WebElement previousBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='Previous']/preceding::div[1]")
    private WebElement totalPages;

    public void verifyPrevBtn() {
        Assert.assertFalse(isElementEnabled(previousBtn), "Previous button is enabled by default");
    }

    public void clickOnNextBtn() {
        click(nextBtn, "Next button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void clickOnPrevBtn() {
        click(previousBtn, "Previous button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyPagination(String pageNum) {
        Assert.assertTrue(getText(totalPages, "Total Pages").contains("Page "+pageNum), "Page is not navigated to Next/Previous page");
    }
}
