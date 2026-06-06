package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.StringUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ZonesPage extends DriverUtils {
    public ZonesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-add-zone']")
    private WebElement addZoneButton;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']/following-sibling::select")
    private WebElement facilityDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-zone-name']")
    private WebElement zoneNameTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-zone-code']")
    private WebElement zoneCodeTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-zone-type']/following-sibling::select")
    private WebElement zoneTypeDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-temperature']/following-sibling::select")
    private WebElement temperatureDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-max-capacity']")
    private WebElement maximumCapacityTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='checkbox-is-active']")
    private WebElement activeZoneCheckbox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-save-zone']")
    private WebElement createZoneBtn;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-zones']")
    private WebElement searchZoneTxtBox;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[1]//div[@class='font-medium']")
    private WebElement tableZoneName;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[1]//div[@class='text-sm text-muted-foreground']")
    private WebElement tableZoneCode;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[2]")
    private WebElement tableZoneFacility;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[3]/div")
    private WebElement tableType;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[4]/div/div")
    private WebElement tableTemperature;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[5]/div/div")
    private WebElement tableCapacity;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[6]/div/div")
    private WebElement tableZoneStatus;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[7]//button[1]")
    private WebElement editBnt;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[7]//button[2]")
    private WebElement deleteBnt;

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[2]")
    private List<WebElement> allZones;

    public void clickOnAddZone() {
        click(addZoneButton, "Add Zone button");
    }

    public void createUpdateNewZone(String facility, String zoneName, String zoneCode, String zoneType, String temperature, String maximumCapacity, String status) throws InterruptedException {
        String zoneNameValue = zoneName + StringUtils.getRandomNumber();
        String zoneCodeValue = zoneCode + StringUtils.getRandomNumber();
        globalVariables.clear();
        globalVariables.put("Zone Name", zoneNameValue);
        globalVariables.put("Zone Code", zoneCodeValue);
        Thread.sleep(3000);
        selectDropdownValueByIndex(facilityDropdown, facility, "Facility Dropdown");
        globalVariables.put("Facility", getDropdownValueByIndex(facilityDropdown, facility));
        clearData(zoneNameTxtBox, "Zone Name");
        enterText(zoneNameTxtBox, zoneNameValue, "Zone Name");
        clearData(zoneCodeTxtBox, "Zone Code");
        enterText(zoneCodeTxtBox, zoneCodeValue, "Zone Code");
        selectDropdownValueByVisibleText(zoneTypeDropdown, zoneType, "Zone Type Dropdown");
        selectDropdownValueByVisibleText(temperatureDropdown, temperature, "Temperature Dropdown");
        clearData(maximumCapacityTxtBox, "Maximum Capacity");
        enterText(maximumCapacityTxtBox, maximumCapacity, "Maximum Capacity");
        if (status.equalsIgnoreCase("Active")) {
            if (!getAttribute(activeZoneCheckbox, "data-state").equalsIgnoreCase("checked")) {
                click(activeZoneCheckbox, "Active Zone checkbox");
            }
        } else {
            if (getAttribute(activeZoneCheckbox, "data-state").equalsIgnoreCase("checked")) {
                click(activeZoneCheckbox, "Active Zone checkbox");
            }
        }

        click(createZoneBtn, "Create/Update Zone");
    }

    public void searchZone() {
        enterText(searchZoneTxtBox, globalVariables.get("Zone Name"), "Search Zone");
        WaitUtils.waitForPageLoads();
    }

    public void editZone() {
        click(editBnt, "Edit Zone");
        WaitUtils.waitForPageLoads();
    }

    public void verifyZone(String facility, String zoneName, String zoneCode, String zoneType, String temperature, String maximumCapacity, String status) throws InterruptedException {
        Assert.assertEquals(getText(tableZoneName, "Zone name in table"), globalVariables.get("Zone Name"), "Wrong Zone name displayed");
        Assert.assertEquals(getText(tableZoneCode, "Zone code in table"), globalVariables.get("Zone Code"), "Wrong Zone code displayed");
        Assert.assertEquals(getText(tableZoneFacility, "Zone Facility in table"), globalVariables.get("Facility"), "Wrong facility displayed");
        Assert.assertEquals(getText(tableType, "Type in table").toLowerCase(), zoneType.toLowerCase(), "Wrong Type displayed");
        Assert.assertEquals(getText(tableTemperature, "Temperature in table").toLowerCase(), temperature.toLowerCase(), "Wrong Temperature displayed");
        Assert.assertTrue(getText(tableCapacity, "Capacity in table").contains(maximumCapacity), "Wrong Capacity displayed");
        Assert.assertEquals(getText(tableZoneStatus, "Status in table"), status, "Wrong Status displayed");
    }

    public void deleteZone() throws InterruptedException {
        click(deleteBnt, "Delete Zone");
        WaitUtils.waitForAlert();
        acceptAlert();
        Thread.sleep(3000);
    }

    public void verifyZoneDeleted(){
        Assert.assertEquals(allZones.size(), 0, "Zone has not deleted");
    }

}
