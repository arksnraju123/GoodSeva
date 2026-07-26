package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.FileUtils;
import com.goodseva.utils.StringUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BinsPage extends DriverUtils {
    public BinsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    String pdfDownloadPath = System.getProperty("user.home") + "/Downloads/download.pdf";

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-add-bin']")
    private WebElement addBinButton;

    @FindBy(how = How.XPATH, using = "//div[text()='Saved Bins']/span")
    private WebElement totalBins;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-bins']")
    private WebElement searchBinsTextBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-zone']")
    private WebElement filterByZoneDropdown;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[1]/div")
    private List<WebElement> binTableAllValues;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[3]/div/div[1]")
    private List<WebElement> zoneTableAllValues;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[4]/div")
    private List<WebElement> typeTableAllValues;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[5]/div")
    private List<WebElement> statusTableAllValues;

    @FindBy(how = How.XPATH, using = "//span[@data-component-name='SelectPrimitive.ItemText']")
    private List<WebElement> filterByDropdownValues;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-type']")
    private WebElement filterByTypeDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-status']")
    private WebElement filterByStatusDropdown;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[1]/div")
    private WebElement binCodeFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[2]/div")
    private WebElement locationFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[3]/div/div[1]")
    private WebElement zoneFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[3]/div/div[2]")
    private WebElement zoneFacilityFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[4]/div[1]")
    private WebElement typeFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[5]/div[1]")
    private WebElement statusFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[6]/div/div")
    private WebElement capacityFromTable;

    @FindBy(how = How.XPATH, using = "(//tbody//tr[@data-component-name='TableRow'][1]/td[7]//*[local-name()='svg'])[1]")
    private WebElement pickableOptionFromTable;

    @FindBy(how = How.XPATH, using = "(//tbody//tr[@data-component-name='TableRow'][1]/td[7]//*[local-name()='svg'])[2]")
    private WebElement receivableOptionFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[8]//button[1]")
    private WebElement printIconFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[8]//button[2]")
    private WebElement editIconFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[8]//button[3]")
    private WebElement deleteIconFromTable;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-zone']")
    private WebElement zoneDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-bin-code']")
    private WebElement binCodeTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-bin-type']")
    private WebElement binTypeDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-bin-type']")
    private WebElement binTypeDropdownValue;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-aisle']")
    private WebElement aisleTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-rack']")
    private WebElement rackTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-shelf']")
    private WebElement shelfTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-level']")
    private WebElement levelTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-status']")
    private WebElement statusDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-status']/span")
    private WebElement statusDropdownValue;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-capacity']")
    private WebElement capacityTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='checkbox-is-pickable']")
    private WebElement pickableRadioBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='checkbox-is-receivable']")
    private WebElement receivableRadioBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-cancel']")
    private WebElement cancelBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-save-bin']")
    private WebElement createBinBtn;

    @FindBy(how = How.XPATH, using = "//div[text()='Saved Bins']/following::table")
    private WebElement savedBinsTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[1]")
    private WebElement tableMsg;

    @FindBy(how = How.XPATH, using = "//div[@data-component-name='CardTitle']/following-sibling::span")
    private WebElement noBinMsg;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-save-bin']")
    private WebElement updateBinBtn;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[1]/div")
    private List<WebElement> allBinCodes;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[2]/div")
    private List<WebElement> allLocations;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[4]/div")
    private List<WebElement> allTypes;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[5]/div")
    private List<WebElement> allStatus;

    @FindBy(how = How.XPATH, using = "(//div//select)[1]/option")
    private List<WebElement> zoneDropDownValues;

    @FindBy(how = How.XPATH, using = "(//div//select)[2]/option")
    private List<WebElement> binTypeDropdownValues;

    @FindBy(how = How.XPATH, using = "(//div//select)[3]/option")
    private List<WebElement> statusDropdownValues;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-next-page']")
    private WebElement nextBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-prev-page']")
    private WebElement previousBtn;

    @FindBy(how = How.XPATH, using = "//button[text()='Previous']/preceding::div[1]")
    private WebElement totalPages;

    public String getTotalBins() throws InterruptedException {
        WaitUtils.sleepFor(2000);
        return getText(totalBins, "Total Bins").replaceAll("\\D+", "");
    }

    public void createNewBin(String binCode, String binType, String aisle, String rack, String shelf, String level, String status, String capacity, String pickable, String receivable) {
        click(addBinButton, "Add Bin button");
        WaitUtils.sleepFor(2000);
        WaitUtils.waitForElementClickable(aisleTxtBox);
        click(zoneDropdown, "");
        String zoneValue = getText(zoneDropDownValues.get(1), "Zone");
        pressEscape();
        globalVariables.put("Zone", zoneValue);
        selectDropdownValue(zoneDropdown, zoneDropDownValues, zoneValue, "Zone");
        String binCodeValue = binCode.concat(StringUtils.getRandomNumber());
        globalVariables.put("BinCode", binCodeValue);
        globalVariables.put("Type", binType);
        globalVariables.put("Status", status);
        enterText(binCodeTxtBox, binCodeValue, "Bin code");
        selectDropdownValue(binTypeDropdown, binTypeDropdownValues, binType, "Bin Type");
        enterText(aisleTxtBox, aisle, "Aisle");
        enterText(rackTxtBox, rack, "Rack");
        enterText(shelfTxtBox, shelf, "Shelf");
        enterText(levelTxtBox, level, "Level");
        WaitUtils.sleepFor(1000);
        selectDropdownValue(statusDropdown, statusDropdownValues, status, "Status dropdown");
        enterText(capacityTxtBox, capacity, "Capacity");
        if (pickable.equalsIgnoreCase("Yes")) {
            if (!getAttribute(pickableRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(pickableRadioBtn, "Pickable radio button");
        } else {
            if (!getAttribute(pickableRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(pickableRadioBtn, "Pickable radio button");
        }
        if (receivable.equalsIgnoreCase("Yes")) {
            if (!getAttribute(receivableRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(receivableRadioBtn, "Receivable radio button");
        } else {
            if (!getAttribute(receivableRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(receivableRadioBtn, "Receivable radio button");
        }
        click(createBinBtn, "Create Bin button");
        WaitUtils.waitForVisibilityOfElement(savedBinsTable);
        WaitUtils.sleepFor(5000);
    }

    public void verifyBin(String location, String type, String status, String capacity, String pickable, String receivable) {
        Assert.assertEquals(getText(binCodeFromTable, "Bin code"), globalVariables.get("BinCode"), "BinCode is wrong");
        Assert.assertEquals(getText(locationFromTable, "Location"), location, "Location is wrong");
        Assert.assertTrue(globalVariables.get("Zone").contains(getText(zoneFromTable, "Zone")), "Zone is wrong");
        Assert.assertEquals(getText(typeFromTable, "Zone"), type, "Type is wrong");
        Assert.assertEquals(getText(statusFromTable, "Status"), status, "Status is wrong");
        Assert.assertTrue(getText(capacityFromTable, "Capacity").contains(capacity), "Capacity is wrong");
        if (pickable.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(pickableOptionFromTable, "title"), "Pickable", "Pickable is wrong");
        } else {
            Assert.assertEquals(getAttribute(pickableOptionFromTable, "title"), "Not Pickable", "Pickable is wrong");
        }

        if (receivable.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(receivableOptionFromTable, "title"), "Receivable", "Receivable is wrong");
        } else {
            Assert.assertEquals(getAttribute(receivableOptionFromTable, "title"), "Not Receivable", "Receivable is wrong");
        }
    }

    public void verifyEditBinPage(String binType, String aisle, String rack, String shelf, String level, String status, String capacity, String pickable, String receivable) {
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("BinCode") + "']/following::button[contains(@data-testid, 'button-edit-bin')][1]")), "Edit button");
        WaitUtils.sleepFor(2000);
        WaitUtils.waitForElementClickable(aisleTxtBox);
        Assert.assertEquals(getTextBoxValue(binCodeTxtBox, "Bin code"), globalVariables.get("BinCode"), "Edited BinCode is wrong");
        Assert.assertEquals(getText(binTypeDropdownValue, "Bin type"), binType, "Edited Type is wrong");
        Assert.assertEquals(getTextBoxValue(aisleTxtBox, "Aisle"), aisle, "Edited Aisle is wrong");
        Assert.assertEquals(getTextBoxValue(rackTxtBox, "Rack"), rack, "Edited Rack is wrong");
        Assert.assertEquals(getTextBoxValue(shelfTxtBox, "Shelf"), shelf, "Edited Shelf is wrong");
        Assert.assertEquals(getTextBoxValue(levelTxtBox, "Level"), level, "Edited Level is wrong");
        Assert.assertEquals(getText(statusDropdownValue, "Status dropdown"), status, "Edited Status is wrong");
        Assert.assertEquals(getTextBoxValue(capacityTxtBox, "Capacity"), capacity, "Edited Capacity is wrong");

        if (pickable.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(pickableRadioBtn, "aria-checked"), "true", "Edited Pickable is wrong");
        } else {
            Assert.assertEquals(getAttribute(pickableRadioBtn, "aria-checked"), "false", "Edited Pickable is wrong");
        }

        if (receivable.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(receivableRadioBtn, "aria-checked"), "true", "Edited Receivable is wrong");
        } else {
            Assert.assertEquals(getAttribute(receivableRadioBtn, "aria-checked"), "false", "Edited Receivable is wrong");
        }

        click(cancelBtn, "Cancel button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void searchWithBinName() {
        enterText(searchBinsTextBox, globalVariables.get("BinCode"), "Bin Code");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void searchWithInvalidBinName() {
        enterText(searchBinsTextBox, "xyz_" + StringUtils.getRandomNumber(10000, 1000000), "Bin Code");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifySearchBin() {
        List<String> allValues = getAllElementsValues(binTableAllValues);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("BinCode").split("\\(")[0].trim())), "Search not worked correctly when search with BinCode");
    }

    public void searchWithZone() {
        selectDropdownValue(filterByZoneDropdown, filterByDropdownValues, globalVariables.get("Zone").split("\\(")[0].trim(), "Search Zone dropdown");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifySearchZone() {
        List<String> allValues = getAllElementsValues(zoneTableAllValues);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("Zone").split("\\(")[0].trim())), "Search not worked correctly when search with Zone");
    }

    public void searchWithType() {
        selectDropdownValue(filterByTypeDropdown, filterByDropdownValues, globalVariables.get("Type"), "Search Type dropdown");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifySearchType() {
        List<String> allValues = getAllElementsValues(typeTableAllValues);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("Type").toLowerCase())), "Search not worked correctly when search with Type");
    }

    public void searchWithStatus() {
        selectDropdownValue(filterByStatusDropdown, filterByDropdownValues, globalVariables.get("Status"), "Search Status dropdown");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifySearchStatus() {
        List<String> allValues = getAllElementsValues(statusTableAllValues);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("Status").toLowerCase())), "Search not worked correctly when search with Status");
    }

    public void resetSearch(String searchField) {
        if (searchField.equalsIgnoreCase("Bins")) {
            clearData(searchBinsTextBox, "Bin textbox");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }

        if (searchField.equalsIgnoreCase("Zones")) {
            selectDropdownValues(filterByZoneDropdown, filterByDropdownValues, "All Zones", "Search Zone dropdown");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }

        if (searchField.equalsIgnoreCase("Type")) {
            selectDropdownValues(filterByTypeDropdown, filterByDropdownValues, "All Types", "Search dropdown");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }

        if (searchField.equalsIgnoreCase("Status")) {
            selectDropdownValues(filterByStatusDropdown, filterByDropdownValues, "All Status", "Status dropdown");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }
    }

    public void editBin(String binCode, String binType, String aisle, String rack, String shelf, String level, String status, String capacity, String pickable, String receivable) {
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("BinCode") + "']/following::button[contains(@data-testid, 'button-edit-bin')][1]")), "Edit button");
        WaitUtils.sleepFor(2000);
        WaitUtils.waitForElementClickable(aisleTxtBox);
        String binCodeValue = binCode.concat(StringUtils.getRandomNumber());
        globalVariables.replace("BinCode", binCodeValue);
        globalVariables.replace("Type", binType);
        globalVariables.replace("Status", status);
        enterText(binCodeTxtBox, binCodeValue, "Bin code");
        selectDropdownValue(binTypeDropdown, binTypeDropdownValues, binType, "Bin Type");
        enterText(aisleTxtBox, aisle, "Aisle");
        enterText(rackTxtBox, rack, "Rack");
        enterText(shelfTxtBox, shelf, "Shelf");
        enterText(levelTxtBox, level, "Level");
        WaitUtils.sleepFor(1000);
        selectDropdownValue(statusDropdown, statusDropdownValues, status, "Status dropdown");
        enterText(capacityTxtBox, capacity, "Capacity");
        if (pickable.equalsIgnoreCase("Yes")) {
            if (!getAttribute(pickableRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(pickableRadioBtn, "Pickable radio button");
        } else {
            if (!getAttribute(pickableRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(pickableRadioBtn, "Pickable radio button");
        }
        if (receivable.equalsIgnoreCase("Yes")) {
            if (!getAttribute(receivableRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(receivableRadioBtn, "Receivable radio button");
        } else {
            if (!getAttribute(receivableRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(receivableRadioBtn, "Receivable radio button");
        }
        click(createBinBtn, "Create Bin button");
        WaitUtils.waitForVisibilityOfElement(savedBinsTable);
        WaitUtils.sleepFor(5000);
    }

    public void verifyTableMessage() {
        Assert.assertEquals(getText(tableMsg, "Table message"), "No bins found", "Table message is wrong when do invalid Bin search");
    }

    public void verifyNoBinMessage() {
        Assert.assertEquals(getText(noBinMsg, "No Bin message"), "No bins yet — use \"Add Bin\" above to create one", "No Bin message is wrong when do invalid Bin search");
    }

    public void deleteBin() {
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("BinCode") + "']/following::button[contains(@data-testid, 'button-delete-bin')][1]")), "Delete button");
        WaitUtils.sleepFor(1000);
        acceptAlert();
    }

    public void verifyBinDeleted() {
        enterText(searchBinsTextBox, globalVariables.get("BinCode"), "Bin Code");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
        Assert.assertEquals(getText(tableMsg, "Table message"), "No bins found", "Bin has not deleted when delete it");
    }

    public void clickOnPrint() {
        log.info("Deleting existing file :" + pdfDownloadPath);
        FileUtils.deleteFileFromFolder(pdfDownloadPath);
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("BinCode") + "']/following::button[contains(@data-testid, 'button-print-label-bin')][1]")), "Delete button");
        WaitUtils.sleepFor(5000);
    }

    public void verifyPDFFile(String type, String capacity, String status) {
        String pdfFileData = FileUtils.getPDFFileData(pdfDownloadPath).toLowerCase();
        Assert.assertTrue(pdfFileData.contains("goodseva wms — bin location label".toLowerCase()), "Header is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains(globalVariables.get("BinCode").toLowerCase()), "Bind code is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains(getText(zoneFacilityFromTable, "Zone").toLowerCase()), "Zone is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains(getText(zoneFacilityFromTable, "Zone facility").toLowerCase()), "Facility is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains(type.toLowerCase()), "Type is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains(capacity.toLowerCase()), "Capacity is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains(status.toLowerCase()), "Status is wrong in PDF");
        Assert.assertTrue(pdfFileData.contains("scan before put-away and picking".toLowerCase()), "Footer is wrong in PDF");
    }

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
