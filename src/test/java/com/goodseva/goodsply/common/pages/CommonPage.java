package com.goodseva.goodsply.common.pages;

import com.goodseva.utils.FileUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonPage extends DriverUtils {
    public CommonPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement signIn;

    @FindBy(how = How.NAME, using = "email")
    private WebElement userNameTextbox;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordTextbox;

    @FindBy(how = How.XPATH, using = "(//button[text()='Sign In'])[2]")
    private WebElement signInButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/parent::div/parent::button[@data-state='closed']")
    private WebElement integrityExpand;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Appointments']")
    private WebElement appointmentsLink;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Zones']")
    private WebElement zonesLink;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Integrity Hub']")
    private WebElement integrityHub;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='WMS Dashboard']")
    private WebElement wmsDashboard;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Facilities']")
    private WebElement facilities;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Bins']")
    private WebElement bins;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Products & SKUs']")
    private WebElement productsAndSKUs;

    @FindBy(how = How.XPATH, using = "//span[text()='Integrity']/following::span[text()='Stock Overview']")
    private WebElement stockOverview;

    public void clickOnSignIn() {
        click(signIn, "SignIn Link");
    }

    public void loginGoodsPly() {
        clickOnSignIn();
        enterText(userNameTextbox, FileUtils.getProperty("config.properties", "goodsPlyUserName"), "Email/Username/Mobile Number textbox");
        enterText(passwordTextbox, FileUtils.getProperty("config.properties", "goodsPlyPassword"), "Password textbox");
        click(signInButton, "SignIn button");
    }

    private void expandIntegrity() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WaitUtils.waitForPageLoads();
        /*if (isElementDisplayed(integrityExpand, "Integrity expand icon")) {
            click(integrityExpand, "Expand Integrity");
            WaitUtils.waitForPageLoads();
        }*/
    }

    public void openAppointmentPage() {
        expandIntegrity();
        jsClick(appointmentsLink, "Appointments Link");
    }

    public void openZonesPage() {
        expandIntegrity();
        jsClick(zonesLink, "Zones Link");
    }

    public void openIntegrityHubPage() {
        expandIntegrity();
        jsClick(integrityHub, "Integrity Hub Link");
    }

    public void openWMSDashboardPage() {
        expandIntegrity();
        jsClick(wmsDashboard, "WMS Dashboard Link");
    }

    public void openFacilitiesPage() {
        expandIntegrity();
        jsClick(facilities, "Facilities Link");
    }

    public void openBinsPage() {
        expandIntegrity();
        jsClick(bins, "Bins Link");
    }

    public void openProductsAndSKUsPage() {
        expandIntegrity();
        jsClick(productsAndSKUs, "Products And SKUs Link");
    }

    public void openStockOverviewPage() {
        expandIntegrity();
        jsClick(stockOverview, "Stock Overview Link");
    }
}
