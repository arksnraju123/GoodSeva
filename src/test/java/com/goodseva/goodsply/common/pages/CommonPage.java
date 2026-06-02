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

    public void clickOnSignIn() {
        click(signIn, "SignIn Link");
    }

    public void loginGoodsPly(){
        clickOnSignIn();
        enterText(userNameTextbox, FileUtils.getProperty("config.properties", "goodsPlyUserName"), "Email/Username/Mobile Number textbox");
        enterText(passwordTextbox, FileUtils.getProperty("config.properties", "goodsPlyPassword"), "Password textbox");
        click(signInButton, "SignIn button");
    }

    private boolean isIntegrityExpand(){
        return isElementDisplayed(integrityExpand, "Integrity expand icon");
    }

    public void openAppointmentPage(){
        if(isIntegrityExpand()){
            click(integrityExpand, "Expand Integrity");
            WaitUtils.waitForPageLoads();
        }
        jsClick(appointmentsLink, "Appointments Link");
    }
}
