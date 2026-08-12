package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.DateTimeUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class PurchaseOrdersPage extends DriverUtils {
    public PurchaseOrdersPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[1]")
    private WebElement totalPurchaseOrdersCount;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[2]")
    private WebElement totalIssuedCount;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[5]")
    private WebElement totalValueCount;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='btn-create-po']")
    private WebElement createPOButton;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-purchase-orders']")
    private WebElement searchPOTextbox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-purchase-order-vendor']")
    private WebElement searchVendorsDropdown;

    @FindBy(how = How.XPATH, using = "//span[@data-component-name='SelectPrimitive.ItemText']")
    private List<WebElement> dropdownValues;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[1]")
    private List<WebElement> allTablePOOrders;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[2]")
    private List<WebElement> allTableVendors;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[3]")
    private List<WebElement> allTableDate;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[4]")
    private List<WebElement> allTableAmount;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[5]/div")
    private List<WebElement> allTableStatus;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[5]/div[text()='issued']")
    private List<WebElement> allTableIssuedStatus;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-vendor']")
    private WebElement vendorDropdownOnPOPopup;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-delivery-date']")
    private WebElement expectedDeliveryDate;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-delivery-date']/following::button[1]")
    private WebElement paymentTerms;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-item-description']")
    private WebElement descriptionTextbox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-item-qty']")
    private WebElement quantityTextbox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-item-qty']/following::button[1]")
    private WebElement uomDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-item-price']")
    private WebElement unitPriceTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='btn-add-item']")
    private WebElement addItemBtn;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-item-price']/following::div[@class='font-bold']")
    private WebElement totalAmountOnPopup;

    @FindBy(how = How.ID, using = "notes")
    private WebElement notesTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='btn-submit-po']")
    private WebElement createPOButtonOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//h2")
    private WebElement poValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[1]/p")
    private WebElement vendorValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div/div[2]/div")
    private WebElement statusValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[3]/p")
    private WebElement poDateValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[4]/p")
    private WebElement deliveryDateValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[5]/p")
    private WebElement paymentTermsValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[6]/p")
    private WebElement totalAmountValueOnPopup;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//following::div[7]/p)[3]")
    private WebElement notesValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[2]")
    private WebElement descriptionValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[3]")
    private WebElement qtyValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[4]")
    private WebElement unitOfMeasureValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[5]")
    private WebElement unitPriceValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[6]")
    private WebElement taxValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[7]")
    private WebElement lineTotalValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div/span")
    private WebElement totalValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//button")
    private WebElement closePopupIcon;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[2]")
    private List<WebElement> allDescriptionValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[3]")
    private List<WebElement> allQtyValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[4]")
    private List<WebElement> allUnitOfMeasureValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[5]")
    private List<WebElement> allUnitPriceValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[6]")
    private List<WebElement> allTotalValueOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table//td[7]")
    private List<WebElement> allDeleteIconOnPopup;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table/following::div/div[1]/div[1]")
    private WebElement subTotalOnCreatePO;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table/following::div/div[1]/div[2]")
    private WebElement taxOnCreatePO;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//table/following::div/div[1]/div[3]")
    private WebElement totalOnCreatePO;

    @FindBy(how = How.XPATH, using = "//button[text()='Previous']/preceding::*[1]")
    private WebElement totalPages;

    public void createPurchaseOrder(String vendor, String exptDeliveryDate, String pmtTerms, String description, String qty, String unitOfMeasure, String unitPrice, String notes) {
        String oldPOOrder = getText(allTablePOOrders.get(0), "Purchase order from table").split("-")[2];
        String newPOOrder = "PO-".concat(DateTimeUtils.getFutureDate(0, "YY")).concat("-" + String.format("%0" + oldPOOrder.length() + "d", Integer.parseInt(oldPOOrder) + 1));
        globalVariables.put("PurchaseOrder", newPOOrder);
        click(createPOButton, "Create PO");
        selectDropdownValue(vendorDropdownOnPOPopup, dropdownValues, vendor, "Vendor dropdown");
        exptDeliveryDate = DateTimeUtils.getFutureDate(Integer.parseInt(exptDeliveryDate.split("\\+")[1]), "dd-MM-yyyy");
        enterText(expectedDeliveryDate, exptDeliveryDate, "Expected Delivery Date");
        selectDropdownValue(paymentTerms, dropdownValues, pmtTerms, "Payment Terms dropdown");
        enterText(descriptionTextbox, description, "Description");
        enterText(quantityTextbox, qty, "Quantity");
        selectDropdownValue(uomDropdown, dropdownValues, unitOfMeasure, "Unit Of Measure dropdown");
        clearData(unitPriceTxtBox, "Unit Price");
        enterText(unitPriceTxtBox, unitPrice, "Unit Price");
        click(addItemBtn, "Add Item");
        WaitUtils.waitForPageLoads();
        enterText(notesTxtBox, notes, "Notes");
        click(createPOButtonOnPopup, "Create Purchase Order");
        WaitUtils.waitForInvisibilityOfElement(createPOButtonOnPopup);
    }

    public void verifyPurchaseOrder(String vendor, String date, String amount, String status) {
        String newPOOrder = getText(allTablePOOrders.get(0), "Purchase order from table");
        Assert.assertEquals(newPOOrder, globalVariables.get("PurchaseOrder"), "Purchase Order is wrong in table");
        Assert.assertEquals(getText(allTableVendors.get(0), "Vendors"), vendor, "Vendor is wrong in table");
        Assert.assertEquals(getText(allTableDate.get(0), "Date"), DateTimeUtils.getFutureDate(Integer.parseInt(date.split("\\+")[1]), "dd MMM yyyy"), "Date is wrong in table");
        Assert.assertEquals(getText(allTableAmount.get(0), "Amount"), amount, "Amount is wrong in table");
        Assert.assertEquals(getText(allTableStatus.get(0), "Status"), status, "Status is wrong in table");
    }

    public void verifyPurchaseOrderDetailsOnPopup(String vendor, String status, String poDate, String deliveryDate, String paymentTerms, String totalAmount, String notes, String description, String quantity, String unitOfMeasure, String unitPrice, String tax) {
        click(getElement(By.xpath("//td[text()='" + globalVariables.get("PurchaseOrder") + "']/following::button[2]"), "View button"), "View button");
        WaitUtils.waitForElementClickable(descriptionValueOnPopup);
        Assert.assertEquals(getText(poValueOnPopup, "PO number"), "Purchase Order: ".concat(globalVariables.get("PurchaseOrder")), "Purchase Order is wrong in view popup");
        Assert.assertEquals(getText(vendorValueOnPopup, "Vendors"), vendor, "Vendor is wrong in view popup");
        Assert.assertEquals(getText(statusValueOnPopup, "Status"), status, "Status is wrong in view popup");
        Assert.assertEquals(getText(poDateValueOnPopup, "PO Date"), DateTimeUtils.getFutureDate(Integer.parseInt(poDate.split("\\+")[1]), "dd MMM yyyy"), "PO Date is wrong in view popup");
        Assert.assertEquals(getText(deliveryDateValueOnPopup, "Delivery Date"), DateTimeUtils.getFutureDate(Integer.parseInt(deliveryDate.split("\\+")[1]), "dd MMM yyyy"), "Delivery Date is wrong in view popup");
        Assert.assertEquals(getText(paymentTermsValueOnPopup, "Payment Terms"), paymentTerms, "Payment Terms is wrong in view popup");
        Assert.assertEquals(getText(totalAmountValueOnPopup, "Total Amount"), totalAmount, "Total Amount is wrong in view popup");
        Assert.assertEquals(getText(notesValueOnPopup, "Notes"), notes, "Notes is wrong in view popup");
        Assert.assertEquals(getText(descriptionValueOnPopup, "Description"), description, "Description is wrong in view popup");
        Assert.assertEquals(getText(qtyValueOnPopup, "Quantity"), quantity, "Quantity is wrong in view popup");
        Assert.assertEquals(getText(unitOfMeasureValueOnPopup, "Unit Of Measure"), unitOfMeasure, "Unit Of Measure is wrong in view popup");
        Assert.assertEquals(getText(unitPriceValueOnPopup, "Unit Price"), unitPrice, "Unit Price is wrong in view popup");
        Assert.assertEquals(getText(taxValueOnPopup, "Tax"), tax, "Tax is wrong in view popup");
        Assert.assertEquals(getText(lineTotalValueOnPopup, "Line total"), totalAmount.concat(".00"), "Line total is wrong in view popup");
        Assert.assertEquals(getText(totalValueOnPopup, "Total"), totalAmount.concat(".00"), "total is wrong in view popup");
        click(closePopupIcon, "Close Popup");
    }

    public void clickOnAction(String action) {
        click(getElement(By.xpath("//td[text()='" + globalVariables.get("PurchaseOrder") + "']/following::button[1]"), action + " button"), action + " button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(5000);
    }

    public void verifyStatusInTable(String status) {
        Assert.assertEquals(getText(allTableStatus.get(0), "Status"), status, "Status is wrong in table");
    }

    public void verifyStatusOnPopup(String status) {
        if (!status.equalsIgnoreCase("issued")) {
            click(getElement(By.xpath("//td[text()='" + globalVariables.get("PurchaseOrder") + "']/following::button[2]"), "View button"), "View button");
        } else {
            click(getElement(By.xpath("//td[text()='" + globalVariables.get("PurchaseOrder") + "']/following::button[1]"), "View button"), "View button");
        }
        Assert.assertEquals(getText(statusValueOnPopup, "Status"), status, "Status is wrong in view popup");
        click(closePopupIcon, "Close Popup");
    }

    public void addLineItems(String description, String quantity, String unitOfMeasure, String unitPrice) {
        enterText(descriptionTextbox, description, "Description");
        enterText(quantityTextbox, quantity, "Quantity");
        selectDropdownValue(uomDropdown, dropdownValues, unitOfMeasure, "Unit Of Measure dropdown");
        clearData(unitPriceTxtBox, "Unit Price");
        enterText(unitPriceTxtBox, unitPrice, "Unit Price");
        click(addItemBtn, "Add Item");
        WaitUtils.waitForPageLoads();
    }

    public void createPO() {
        click(createPOButton, "Create PO");
        WaitUtils.waitForElementClickable(descriptionTextbox);
    }

    public void closeCreatePOPopup() {
        click(closePopupIcon, "Close Popup");
        WaitUtils.waitForPageLoads();
    }

    public void verifyLineItem(int rowIndex, String description, String quantity, String unitOfMeasure, String price, String total) {
        Assert.assertEquals(getText(allDescriptionValueOnPopup.get(rowIndex), "description"), description, "Description mismatch at row " + (rowIndex + 1));
        Assert.assertEquals(getText(allQtyValueOnPopup.get(rowIndex), "quantity"), quantity, "Quantity mismatch at row " + (rowIndex + 1));
        Assert.assertEquals(getText(allUnitOfMeasureValueOnPopup.get(rowIndex), "unitOfMeasure"), unitOfMeasure, "UnitOfMeasure mismatch at row " + (rowIndex + 1));
        Assert.assertEquals(getText(allUnitPriceValueOnPopup.get(rowIndex), "price"), price, "Price mismatch at row " + (rowIndex + 1));
        Assert.assertEquals(getText(allTotalValueOnPopup.get(rowIndex), "total"), total, "Total mismatch at row " + (rowIndex + 1));
    }

    public void verifyTotals(String subTotal, String tax, String total) {
        Assert.assertTrue(getText(subTotalOnCreatePO, "Sub total").contains(subTotal), "Sub total mismatch on Create PO popup");
        Assert.assertTrue(getText(taxOnCreatePO, "Tax").contains(tax), "Tax mismatch on Create PO popup");
        Assert.assertTrue(getText(totalOnCreatePO, "Total").contains(total), "Total mismatch on Create PO popup");
    }

    public void deleteLineItem(String row) {
        click(allDeleteIconOnPopup.get(Integer.parseInt(row) - 1), "Delete icon at row " + row);
        WaitUtils.sleepFor(2000);
    }

    public void searchForPO() {
        String existingPOOrder = getText(allTablePOOrders.get(0), "PO order");
        globalVariables.put("ExistingPOOrder", existingPOOrder);
        enterText(searchPOTextbox, existingPOOrder, "Po search text box");
        WaitUtils.sleepFor(2000);
    }

    public void verifyPOSearchResults() {
        List<String> allActualPoOrders = getAllElementsValues(allTablePOOrders);
        boolean allMatch = allActualPoOrders.stream().allMatch(order -> order.equals(globalVariables.get("ExistingPOOrder")));
        Assert.assertTrue(allMatch, "Search not worked correctly when search with Po Order");
    }

    public void resetPOSearchTextbox() {
        clearData(searchPOTextbox, "Search PO textbox");
    }

    public void searchForVendor(String vendor) {
        selectDropdownValue(searchVendorsDropdown, dropdownValues, vendor, "Search Vendor dropdown");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyVendorSearch(String vendor) {
        List<String> allValues = getAllElementsValues(allTableVendors);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.equals(vendor)), "Search not worked correctly when search with Vendor");
    }

    public void verifyTotalPurchaseOrders() {
        String totalFromPagination = getText(totalPages, "Total Pages").split("\\(")[1].split(" ")[0];
        String totalPOsCount = getText(totalPurchaseOrdersCount, "Total PO Count");
        Assert.assertEquals(totalFromPagination, totalPOsCount, "Total POs count mismatched in Total count and pagination");
    }

    public void verifyTotalIssued() {
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
        String totalIssuedCountValue = getText(totalIssuedCount, "Total Issued Count");
        String totalPagesFromPagination = getText(totalPages, "Total Pages").split(" ")[3];
        int tempIssuedCount = 0;
        CommonPage commonPage = new CommonPage(getDriver());
        for (int i = 0; i < Integer.parseInt(totalPagesFromPagination); i++) {
            log.info("Getting all Issued status count from page " + (i + 1));
            tempIssuedCount = tempIssuedCount + allTableIssuedStatus.size();
            if (i != Integer.parseInt(totalPagesFromPagination) - 1) {
                commonPage.clickOnNextBtn();
            }
        }
        Assert.assertEquals(totalIssuedCountValue, String.valueOf(tempIssuedCount), "Total Issued count mismatched");
    }

    public void verifyTotalValue() {
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
        String totalValueCountValue = getText(totalValueCount, "Total Value Count");
        String totalPagesFromPagination = getText(totalPages, "Total Pages").split(" ")[3];
        boolean match = validateTotal(Integer.parseInt(totalPagesFromPagination), totalValueCountValue);
        Assert.assertTrue(match, "Total value is incorrect");
    }

    public boolean validateTotal(int totalPagesFromPagination, String expectedText) {
        CommonPage commonPage = new CommonPage(getDriver());
        BigDecimal actualTotal = BigDecimal.ZERO;

        for (int i = 0; i < totalPagesFromPagination; i++) {
            for (WebElement el : allTableAmount) {
                String amountText = el.getText().replace("₹", "").trim();
                if (!amountText.isEmpty()) {
                    try {
                        Number number = NumberFormat.getNumberInstance(new Locale("en", "IN"))
                                .parse(amountText);
                        BigDecimal amount = new BigDecimal(number.toString());
                        actualTotal = actualTotal.add(amount);
                    } catch (ParseException e) {
                        log.error("Failed to parse amount: " + amountText);
                    }
                }
            }

            if (i != totalPagesFromPagination - 1) {
                commonPage.clickOnNextBtn();
            }
        }

        // Convert expected into rupees
        String cleanExpected = expectedText.replace("₹", "").replace("L", "").trim();
        BigDecimal expectedInRupees = new BigDecimal(cleanExpected).multiply(new BigDecimal("100000"));

        // Allow tolerance of ±5000 rupees
        BigDecimal diff = actualTotal.subtract(expectedInRupees).abs();
        boolean match = diff.compareTo(new BigDecimal("5000")) <= 0;

        log.info("Expected (in rupees): " + expectedInRupees);
        log.info("Actual (in rupees):   " + actualTotal);
        log.info("Difference:           " + diff);

        return match;
    }
}
