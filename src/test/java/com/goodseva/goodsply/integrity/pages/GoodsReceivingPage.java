package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.DateTimeUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class GoodsReceivingPage extends DriverUtils {
    public GoodsReceivingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']")
    private WebElement facilityDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-product']")
    private WebElement productDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-bin']")
    private WebElement binDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']/span")
    private WebElement facilityDropdownValue;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-product']/span")
    private WebElement productDropdownValue;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-bin']/span")
    private WebElement binDropdownValue;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-quantity']")
    private WebElement quantity;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-unit-cost']")
    private WebElement unitCost;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-lot-number']")
    private WebElement lotNumber;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-po-number']")
    private WebElement poNumber;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='textarea-notes']")
    private WebElement notes;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-clear']")
    private WebElement clearFormBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-submit']")
    private WebElement receiveGoodsBtn;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-receiving-history']")
    private WebElement searchTxtBox;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[1]")
    private WebElement tableDateColumn;

    @FindBy(how = How.XPATH, using = "//table//tr/td[2]/div[1]")
    private List<WebElement> tableProductColumn;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[3]/div[1]")
    private WebElement tableQtyReceivedColumn;

    @FindBy(how = How.XPATH, using = "//table//tr/td[4]")
    private List<WebElement> tableBinColumn;

    @FindBy(how = How.XPATH, using = "//table//tr/td[5]")
    private List<WebElement> tablePOReferenceColumn;

    @FindBy(how = How.XPATH, using = "//table//tr/td[6]")
    private WebElement tableNotesColumn;

    @FindBy(how = How.XPATH, using = "//span[@data-component-name='SelectPrimitive.ItemText']")
    private List<WebElement> dropdownValues;

    public void createNewGoodsReceiving(String quantityValue, String unitCostValue, String lotNumberValue, String poNumberValue, String notesValue, String isSave) {
        selectDropdownValue(facilityDropdown, dropdownValues, globalVariables.get("Facility"), "Facility dropdown");
        selectDropdownValue(productDropdown, dropdownValues, globalVariables.get("ProductName"), "Product dropdown");
        selectDropdownValue(binDropdown, dropdownValues, globalVariables.get("BinCode"), "Bin dropdown");
        enterText(quantity, quantityValue, "Quantity");
        enterText(unitCost, unitCostValue, "Unit Cost");
        enterText(lotNumber, lotNumberValue, "Lot Number");
        enterText(poNumber, poNumberValue, "PO Number");
        globalVariables.put("PONumber", poNumberValue);
        enterText(notes, notesValue, "Notes");

        if (isSave.equalsIgnoreCase("true")) {
            click(receiveGoodsBtn, "Receive Goods");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }
    }

    public void clearForm() {
        click(clearFormBtn, "Clear Form");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyDefaultValues() {
        Assert.assertEquals(getText(facilityDropdownValue, "Facility"), "Select facility", "Default Facility dropdown value is wrong");
        Assert.assertEquals(getText(productDropdownValue, "Product"), "Select product or scan barcode", "Default Product dropdown value is wrong");
        Assert.assertEquals(getText(binDropdownValue, "Bin"), "Select bin (optional)", "Default Bin dropdown value is wrong");
        Assert.assertEquals(getAttribute(quantity, "value"), "1", "Default Quantity value is wrong");
        Assert.assertEquals(getAttribute(unitCost, "value"), "", "Default Unit Cost value is wrong");
        Assert.assertEquals(getAttribute(lotNumber, "value"), "", "Default Lot Number value is wrong");
        Assert.assertEquals(getAttribute(poNumber, "value"), "", "Default PO Number value is wrong");
        Assert.assertEquals(getText(notes, "Notes"), "", "Default Notes value is wrong");
    }

    public void search(String searchWith) {
        if (searchWith.equalsIgnoreCase("Product")) {
            enterText(searchTxtBox, globalVariables.get("ProductName"), "Product");
        } else if (searchWith.equalsIgnoreCase("Bin")) {
            enterText(searchTxtBox, globalVariables.get("BinCode"), "Bin");
        } else if (searchWith.equalsIgnoreCase("PO/Reference")) {
            enterText(searchTxtBox, globalVariables.get("PONumber"), "PO Number");
        }
        WaitUtils.sleepFor(2000);
    }

    public void verifyTable(String qtyReceived, String poReference, String notes) {
        Assert.assertTrue(getText(tableDateColumn, "Date").contains(DateTimeUtils.getFutureDate(0, "dd MMM yyyy")), "Table date not displayed today's date");
        Assert.assertEquals(getText(tableProductColumn.get(0), "Product"), globalVariables.get("ProductName"), "Product name is wrong in table");
        Assert.assertEquals(getText(tableQtyReceivedColumn, "Quantity Received"), qtyReceived, "Quantity Received name is wrong in table");
        Assert.assertEquals(getText(tableBinColumn.get(0), "Bin"), globalVariables.get("BinCode"), "Bin name is wrong in table");
        Assert.assertEquals(getText(tablePOReferenceColumn.get(0), "PO/Reference"), poReference, "PO/Reference name is wrong in table");
        Assert.assertEquals(getText(tableNotesColumn, "Notes"), notes, "Notes name is wrong in table");
    }
}
