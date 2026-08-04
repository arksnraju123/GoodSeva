package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.StringUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FacilitiesPage extends DriverUtils {
    public FacilitiesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Click on a facility')]/preceding::div[1]")
    private WebElement totalFacilities;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-add-facility']")
    private WebElement addFacilityBtn;

    @FindBy(how = How.XPATH, using = "//div[@data-component-name='DialogPrimitive.Content']")
    private WebElement newPopup;

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private WebElement facilityNameTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='address']")
    private WebElement addressTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='operatingHoursStart']")
    private WebElement operatingHoursStartTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='operatingHoursEnd']")
    private WebElement operatingHoursEndTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='totalDockDoors']")
    private WebElement totalDockDoorsTxtBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Create Facility']")
    private WebElement createFacilityBtn;

    @FindBy(how = How.XPATH, using = "//div[contains(@data-testid, 'card-facility-')][1]//h3")
    private WebElement facilityNameText;

    @FindBy(how = How.XPATH, using = "//div[contains(@data-testid, 'card-facility-')][1]//div[2]/div[1]")
    private WebElement addressText;

    @FindBy(how = How.XPATH, using = "//div[contains(@data-testid, 'card-facility-')][1]//div[2]/div[2]")
    private WebElement hoursStartEndTimeText;

    @FindBy(how = How.XPATH, using = "//div[contains(@data-testid, 'card-facility-')][1]//div[2]/div[3]")
    private WebElement dockDoorsText;

    @FindBy(how = How.XPATH, using = "//div[contains(@data-testid, 'card-facility-')][1]//div[1]/div")
    private WebElement statusText;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class, 'font-semibold leading-none ')])[2]")
    private WebElement facilityNameAfterClickOnFacility;

    @FindBy(how = How.XPATH, using = "//button[contains(@aria-controls, 'content-dock-doors')]")
    private WebElement dockDoorsTab;

    @FindBy(how = How.XPATH, using = "//button[contains(@aria-controls, 'content-zones')]")
    private WebElement zonesTab;

    @FindBy(how = How.XPATH, using = "//button[contains(@aria-controls, 'content-bins')]")
    private WebElement binsTab;

    @FindBy(how = How.XPATH, using = "//div[@data-state='active' and @data-component-name='TabsPrimitive.Content']/div[2]/p")
    private WebElement noDockZoneBinMsg;

    @FindBy(how = How.XPATH, using = "//div[@data-state='active' and @data-component-name='TabsPrimitive.Content']//button")
    private WebElement addDoorZoneBinBtn;

    @FindBy(how = How.XPATH, using = "//input[@name='doorNumber']")
    private WebElement doorNumTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='doorNumber']/following::button[1]/following::select")
    private WebElement doorTypeDropdown;

    @FindBy(how = How.XPATH, using = "//input[@name='maxVehicleHeight']")
    private WebElement maxHeightTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='maxVehicleWidth']")
    private WebElement maxWidthTxtBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Create Door']")
    private WebElement createDoorBtn;

    @FindBy(how = How.XPATH, using = "//input[@name='name']")
    private WebElement zoneNameTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='code']")
    private WebElement zoneCodeTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='code']/following::button[1]/following::select")
    private WebElement zoneTypeDropdown;

    @FindBy(how = How.XPATH, using = "//input[@name='maxCapacity']")
    private WebElement maxCapacityTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='description']")
    private WebElement descriptionTxtBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Create Zone']")
    private WebElement createZoneBtn;

    @FindBy(how = How.XPATH, using = "//input[@name='binCode']/preceding::button[1]/following::select[1]")
    private WebElement zoneDropdown;

    @FindBy(how = How.XPATH, using = "//input[@name='binCode']")
    private WebElement binCodeTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='binCode']/following::button[1]/following::select")
    private WebElement binTypeDropdown;

    @FindBy(how = How.XPATH, using = "//input[@name='aisle']")
    private WebElement aisleTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@name='rack']")
    private WebElement rackTextBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Create Bin']")
    private WebElement createBinBtn;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm']")
    private WebElement binCode;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-facilities']")
    private WebElement searchTxtBox;

    @FindBy(how = How.XPATH, using = "//h4[contains(@data-testid,'text-door-number-')]")
    private WebElement doorName;

    @FindBy(how = How.XPATH, using = "//h4[contains(@data-testid,'text-door-number-')]/following::div[2]/div")
    private WebElement doorType;

    @FindBy(how = How.XPATH, using = "//h4[contains(@data-testid,'text-door-number-')]/following::div[1]")
    private WebElement doorStatus;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm truncate']")
    private WebElement zoneName;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm truncate']/following-sibling::p")
    private WebElement zoneCodeAndType;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm truncate']/following::div/span")
    private WebElement zoneMaxCapacity;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm truncate']/following::div/div[contains(@class, 'inline-flex items-center')]")
    private WebElement zoneStatus;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm']")
    private WebElement binName;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm']/following-sibling::p")
    private WebElement binDetails;

    @FindBy(how = How.XPATH, using = "//p[@class='font-medium text-sm']/following::div[contains(@class, 'inline-flex items-center')]")
    private WebElement binStatus;

    public String getTotalFacilities() throws InterruptedException {
        WaitUtils.sleepFor(2000);
        return getText(totalFacilities, "Total Facilities").replaceAll("\\D+", "");
    }

    public void createNewFacility(String facilityName, String address, String hoursStart, String hoursEnd, String totalDockDoors) {
        click(addFacilityBtn, "Add Facility");
        WaitUtils.waitForElementClickable(facilityNameTxtBox);
        String facility = facilityName.concat(StringUtils.getRandomNumber(1000, 100000));
        globalVariables.put("Facility", facility);
        enterText(facilityNameTxtBox, facility, "Facility name");
        enterText(addressTxtBox, address, "Address");
        enterText(operatingHoursStartTxtBox, hoursStart, "Operating Hours Start");
        enterText(operatingHoursEndTxtBox, hoursEnd, "Operating Hours End");
        enterText(totalDockDoorsTxtBox, totalDockDoors, "Total Dock Doors");
        click(createFacilityBtn, "Create Button");
        WaitUtils.waitForInvisibilityOfElement(createFacilityBtn);
    }

    public void searchFacility() {
        enterText(searchTxtBox, globalVariables.get("Facility"), "Facility Name");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyNewFacility(String facilityName, String address, String hoursStart, String hoursEnd, String totalDockDoors, String status) {
        Assert.assertEquals(getText(facilityNameText, "Facility Name"), globalVariables.get("Facility"), "Facility name is wrong");
        Assert.assertEquals(getText(addressText, "Address"), address, "Address is wrong");
        Assert.assertEquals(getText(hoursStartEndTimeText, "Hours To Start End"), hoursStart + " - " + hoursEnd, "Hours To Start, End is wrong");
        Assert.assertEquals(getText(dockDoorsText, "Dock Doors"), totalDockDoors, "Dock doors is wrong");
        Assert.assertEquals(getText(statusText, "Status"), status, "Status is wrong");
    }

    public void clickOnFacility() {
        click(facilityNameText, "Facility Name");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyFacilityName() {
        Assert.assertEquals(getText(facilityNameAfterClickOnFacility, "Facility Name"), globalVariables.get("Facility"), "Facility Name is wrong after open it");
    }

    public void openTab(String tab) {
        if (tab.equalsIgnoreCase("Dock Door"))
            click(dockDoorsTab, "Dock doors Tab");
        else if (tab.equalsIgnoreCase("Zones"))
            click(zonesTab, "Zones Tab");
        else if (tab.equalsIgnoreCase("Bins"))
            click(binsTab, "Bins Tab");
        WaitUtils.waitForPageLoads();
    }

    public void verifyDefaultDockZoneBinMsg(String msg) {
        Assert.assertEquals(getText(noDockZoneBinMsg, "No docks/Zone/Bin message"), msg, "Default docks/zone/bins message not displayed for new Facility");
    }

    public void verifyAddBinDisabled() {
        Assert.assertFalse(isElementEnabled(addDoorZoneBinBtn), "Add Bin button enabled when no Zones created");
    }

    public void addDockDoor(String doorType, String maxHeight, String maxWeight) {
        click(addDoorZoneBinBtn, "Add Dock Door");
        WaitUtils.waitForElementClickable(doorNumTxtBox);
        String doorNum = StringUtils.getRandomNumber(1000, 100000);
        globalVariables.put("DockDoorNum", doorNum);
        enterText(doorNumTxtBox, doorNum, "Dock door number");
        selectDropdownValueByVisibleText(doorTypeDropdown, doorType, "Door Type dropdown");
        enterText(maxHeightTxtBox, maxHeight, "Max Height");
        enterText(maxWidthTxtBox, maxWeight, "Max Width");
        click(createDoorBtn, "Create Door");
        WaitUtils.waitForInvisibilityOfElement(createDoorBtn);
    }

    public void verifyNewDockDoor(String doorTypeValue, String status) {
        String door = getText(doorName, "Door Name");
        Assert.assertTrue(door.contains("Door ") && door.contains(globalVariables.get("DockDoorNum")), "Door name is wrong");
        Assert.assertTrue(getText(doorType, "Door Type").contains(doorTypeValue.toLowerCase()), "Door Type is wrong");
        Assert.assertEquals(getText(doorStatus, "Status"), status, "Door Status is wrong");
    }

    public void addZone(String zoneName, String zoneCode, String zoneType, String maxCapacity, String description) {
        click(addDoorZoneBinBtn, "Add Zone");
        WaitUtils.waitForElementClickable(zoneNameTxtBox);
        String zName = zoneName.concat(StringUtils.getRandomNumber(1000, 100000));
        globalVariables.put("ZoneName", zName);
        globalVariables.put("ZoneCode", zoneCode);
        enterText(zoneNameTxtBox, zName, "Zone Name");
        enterText(zoneCodeTxtBox, zoneCode, "Zone Code");
        selectDropdownValueByVisibleText(zoneTypeDropdown, zoneType, "Door Type dropdown");
        enterText(maxCapacityTxtBox, maxCapacity, "Max Capacity");
        enterText(descriptionTxtBox, description, "Description");
        click(createZoneBtn, "Create Zone");
        WaitUtils.waitForInvisibilityOfElement(createZoneBtn);
    }

    public void verifyNewZone(String zoneCode, String zoneType, String maxCapacity, String status) {
        Assert.assertEquals(getText(zoneName, "Zone Name"), globalVariables.get("ZoneName"), "Zone name is wrong");
        String text = getText(zoneCodeAndType, "Zone Code and Type");
        if (zoneCode.equalsIgnoreCase("AutoVerify")) {
            Assert.assertTrue(text.contains(globalVariables.get("ZoneCode")) && text.contains(zoneType.toLowerCase()), "Zone code and Type is wrong");
        } else {
            Assert.assertTrue(text.contains(zoneCode) && text.contains(zoneType.toLowerCase()), "Zone code and Type is wrong");
        }
        Assert.assertTrue(getText(zoneMaxCapacity, "Zone max capacity").contains(maxCapacity), "Max Capacity is wrong");
        Assert.assertEquals(getText(zoneStatus, "Status"), status, "Zone Status is wrong");
    }

    public void addBin(String binCode, String binType, String aisle, String rack) {
        click(addDoorZoneBinBtn, "Add Bin");
        WaitUtils.waitForElementClickable(zoneDropdown);
        selectDropdownValueByVisibleText(zoneDropdown, globalVariables.get("ZoneName").concat(" (").concat(globalVariables.get("ZoneCode").concat(")")), "Zone dropdown");
        String binCodeValue = binCode.concat(StringUtils.getRandomNumber(1000, 100000));
        globalVariables.put("BinCode", binCodeValue);
        enterText(binCodeTxtBox, binCodeValue, "Bin Code");
        selectDropdownValueByVisibleText(binTypeDropdown, binType, "Bin Type");
        enterText(aisleTxtBox, aisle, "Aisle");
        enterText(rackTextBox, rack, "Rack");
        click(createBinBtn, "Create Bin");
        WaitUtils.waitForInvisibilityOfElement(createBinBtn);
    }

    public void verifyNewBin(String binType, String aisle, String rack, String status) {
        Assert.assertEquals(getText(binCode, "Bin Code"), globalVariables.get("BinCode"), "Bin code is wrong");
        String text = getText(binDetails, "Bin details");
        boolean detailsCondition = text.contains(globalVariables.get("ZoneName")) && text.contains(binType.toLowerCase()) && text.contains(aisle) && text.contains(rack);
        Assert.assertTrue(detailsCondition, "Bin details are wrong");
        Assert.assertEquals(getText(binStatus, "Status"), status, "Bin Status is wrong");
    }

    public void verifyTotalCount(String doorsCount, String zoneCount, String binsCount) {
        Assert.assertTrue(getText(dockDoorsTab, "Dock doors tab").contains(doorsCount), "Total Dock Doors count is wrong");
        Assert.assertTrue(getText(zonesTab, "Zones tab").contains(zoneCount), "Total Zones count is wrong");
        Assert.assertTrue(getText(binsTab, "Bins tab").contains(binsCount), "Total Bins count is wrong");
    }

    public void deleteZone() {
        click(getElement(By.xpath("//p[text()='" + globalVariables.get("ZoneName") + "']/following::button"), "Delete button"), "Delete button");
        Assert.assertEquals(getAlertText(), "Delete zone \"" + globalVariables.get("ZoneName") + "\"? All bins inside will also be removed.", "Wrong alert displayed when delete Zone");
        acceptAlert();
    }

    public void verifyDeletedZone() {
        List<WebElement> allZones = getDriver().findElements(By.xpath("//p[text()='" + globalVariables.get("ZoneName") + "']"));
        Assert.assertTrue(allZones.isEmpty(), "Zone has displayed even after delete from Zones page");
    }

    public void deleteBin() {
        click(getElement(By.xpath("//p[text()='" + globalVariables.get("BinCode") + "']/following::button"), "Delete button"), "Delete button");
        acceptAlert();
    }

    public void verifyDeletedBin() {
        List<WebElement> allBins = getDriver().findElements(By.xpath("//p[text()='" + globalVariables.get("BinCode") + "']"));
        Assert.assertTrue(allBins.isEmpty(), "Bin has displayed even after delete from Bins page");
    }
}
