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

    @FindBy(how = How.XPATH, using = "//div[text()='Saved Zones']/span")
    private WebElement totalZones;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-add-zone']")
    private WebElement addZoneButton;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']/following-sibling::select")
    private WebElement facilityDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']")
    private WebElement facilityDropdownToOpen;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']/following-sibling::select/option")
    private List<WebElement> facilityDropdownOptions;

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

    @FindBy(how = How.XPATH, using = "//tbody/tr[1]/td[4]/span")
    private WebElement tableTemperatureBlank;

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

    public void createUpdateNewZone(String facility, String zoneName, String zoneCode, String zoneType, String temperature, String maximumCapacity, String status) {
        String zoneNameValue = zoneName + StringUtils.getRandomNumber();
        String zoneCodeValue = zoneCode + StringUtils.getRandomNumber();
        globalVariables.put("ZoneName", zoneNameValue);
        globalVariables.put("ZoneCode", zoneCodeValue);
        WaitUtils.sleepFor(3000);
        if (!facility.matches("[0-9]+")) {
            if (facility.equalsIgnoreCase("AutoSelect")) {
                selectDropdownValue(facilityDropdownToOpen, facilityDropdownOptions, globalVariables.get("Facility"), "Facility Dropdown");
            } else {
                selectDropdownValueByVisibleText(facilityDropdown, facility, "Facility Dropdown");
            }
        } else {
            selectDropdownValueByIndex(facilityDropdown, facility, "Facility Dropdown");
        }
        if (!facility.equalsIgnoreCase("_IGNORE_")) {
            if (facility.matches("[0-9]+")) {
                if (facility.equalsIgnoreCase("AutoSelect")) {
                    globalVariables.put("Facility", getDropdownValueByIndex(facilityDropdown, globalVariables.get("Facility")));
                } else {
                    globalVariables.put("Facility", getDropdownValueByIndex(facilityDropdown, facility));
                }
            } else {
                if (!facility.equalsIgnoreCase("AutoSelect")) {
                    globalVariables.put("Facility", facility);
                }
            }
        }
        clearData(zoneNameTxtBox, "ZoneName");
        enterText(zoneNameTxtBox, zoneNameValue, "ZoneName");
        clearData(zoneCodeTxtBox, "ZoneCode");
        enterText(zoneCodeTxtBox, zoneCodeValue, "ZoneCode");
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
        WaitUtils.waitForInvisibilityOfElement(createZoneBtn);
    }

    public void searchZone() {
        enterText(searchZoneTxtBox, globalVariables.get("ZoneName"), "Search Zone");
        WaitUtils.waitForPageLoads();
    }

    public void editZone() {
        click(editBnt, "Edit Zone");
        WaitUtils.waitForPageLoads();
    }

    public void verifyZone(String zoneType, String temperature, String maximumCapacity, String status) {
        Assert.assertEquals(getText(tableZoneName, "Zone name in table"), globalVariables.get("ZoneName"), "Wrong Zone name displayed");
        Assert.assertEquals(getText(tableZoneCode, "Zone code in table"), globalVariables.get("ZoneCode"), "Wrong Zone code displayed");
        Assert.assertEquals(getText(tableZoneFacility, "Zone Facility in table"), globalVariables.get("Facility"), "Wrong facility displayed");
        Assert.assertEquals(getText(tableType, "Type in table").toLowerCase(), zoneType.toLowerCase(), "Wrong Type displayed");
        if (temperature.equalsIgnoreCase("-")) {
            Assert.assertEquals(getText(tableTemperatureBlank, "Temperature in table").toLowerCase(), temperature.toLowerCase(), "Wrong Temperature displayed");
        } else {
            Assert.assertEquals(getText(tableTemperature, "Temperature in table").toLowerCase(), temperature.toLowerCase(), "Wrong Temperature displayed");
        }
        Assert.assertTrue(getText(tableCapacity, "Capacity in table").contains(maximumCapacity), "Wrong Capacity displayed");
        Assert.assertEquals(getText(tableZoneStatus, "Status in table"), status, "Wrong Status displayed");
    }

    public void deleteZone() throws InterruptedException {
        click(deleteBnt, "Delete Zone");
        WaitUtils.waitForAlert();
        acceptAlert();
        WaitUtils.sleepFor(3000);
    }

    public void verifyZoneDeleted() {
        Assert.assertEquals(allZones.size(), 0, "Zone has not deleted");
    }

    public String getTotalZones() throws InterruptedException {
        WaitUtils.sleepFor(2000);
        return getText(totalZones, "Total Zones").replaceAll("\\D+", "");
    }
}
