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

import java.util.List;

public class InboundDeliveriesPage extends DriverUtils {
    public InboundDeliveriesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    CommonPage commonPage = new CommonPage(getDriver());

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[1]")
    private WebElement pendingPOsCount;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[2]")
    private WebElement inProgressGRNCount;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[3]")
    private WebElement completedGRNCount;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsContent']//p[2])[4]")
    private WebElement totalGRNCCount;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsList'])[2]/button[1]")
    private WebElement grnsTab;

    @FindBy(how = How.XPATH, using = "(//div[@data-component-name='TabsList'])[2]/button[2]")
    private WebElement pendingPOsTab;

    @FindBy(how = How.XPATH, using = "//span[@data-component-name='SelectPrimitive.ItemText']")
    private List<WebElement> dropdownValues;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-grn-number']")
    private WebElement searchGRNTextbox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-grn-vendor']")
    private WebElement grnSearchVendorsDropdown;

    @FindBy(how = How.XPATH, using = "//table//tr/td[1]")
    private List<WebElement> grnTableNumbers;

    @FindBy(how = How.XPATH, using = "//table//tr/td[2]")
    private List<WebElement> grnTableVendors;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[3]")
    private WebElement grnTableItems;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[4]")
    private WebElement grnTableReceivedQuantity;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[5]")
    private WebElement grnTableReceivedAt;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[6]/div")
    private WebElement grnTableQCStatus;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[7]/button")
    private WebElement grnTableCompleteButton;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-po-number']")
    private WebElement posSearchTextbox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-po-vendor']")
    private WebElement posSearchVendorDropdown;

    @FindBy(how = How.XPATH, using = "//table//tr/td[1]")
    private List<WebElement> posTableNumbers;

    @FindBy(how = How.XPATH, using = "//table//tr/td[2]")
    private List<WebElement> posTableVendors;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[3]")
    private WebElement posTableExpectedDate;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[4]")
    private WebElement posTableItems;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[5]/div")
    private WebElement posTableStatus;

    @FindBy(how = How.XPATH, using = "//table//tr[1]/td[6]/button")
    private WebElement posTableAction;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-create-grn']")
    private WebElement createGRNButton;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-facility']/span")
    private WebElement facilityDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-receipt-type']/span")
    private WebElement receiptDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-po']/span")
    private WebElement purchaseOrderDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-vehicle-number']")
    private WebElement vehicleNumberTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-driver-name']")
    private WebElement driverNameTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-lr-number']")
    private WebElement lrNumberTxtBox;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='input-grn-notes']")
    private WebElement notesTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-vendor-name']")
    private WebElement vendorNameTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-submit-grn']/preceding-sibling::button")
    private WebElement closeBtnOnPopup;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-submit-grn']")
    private WebElement createGrnBtnOnPopup;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-create-grn']/preceding-sibling::button")
    private WebElement refreshButton;

    @FindBy(how = How.XPATH, using = "//div[@data-component-name='DialogContent']//button")
    private WebElement productDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-received-qty-0']")
    private WebElement receivedTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-received-qty-0']/following::input[1]")
    private WebElement acceptedTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-received-qty-0']/following::input[2]")
    private WebElement rejectedTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-lot-number-0']")
    private WebElement lotNumberTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-expiry-date-0']")
    private WebElement expiryDate;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='btn-confirm-complete-grn']")
    private WebElement completeGrnBtn;

    @FindBy(how = How.XPATH, using = "//td/div[text()='qc passed' or text()='completed']")
    private List<WebElement> totalCompletedAndPassed;

    @FindBy(how = How.XPATH, using = "//td/div[text()='draft']")
    private List<WebElement> totalInProgress;

    public void openPendingPOsTab(String tabName) {
        if (tabName.equalsIgnoreCase("Pending POs")) {
            click(pendingPOsTab, "Pending POs tab");
        } else {
            click(grnsTab, "GRN tab");
        }

        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(3000);
    }

    public void verifyPurchaseOrderDetailsInInboundDeliveries(String items, String status) {
        Assert.assertEquals(getText(posTableNumbers.get(0), "PO Number"), globalVariables.get("PurchaseOrder"), "Purchase Order is not correct");
        Assert.assertEquals(getText(posTableVendors.get(0), "Vendor"), globalVariables.get("Vendor"), "Vendor is not correct");
        Assert.assertEquals(getText(posTableExpectedDate, "Expected Date"), DateTimeUtils.convertDateFormat(globalVariables.get("ExpectDeliveryDate"), "dd-MM-yyyy", "M/dd/yyyy"), "Expected Date is not correct");
        Assert.assertEquals(getText(posTableItems, "Items"), items, "Items is not correct");
        Assert.assertEquals(getText(posTableStatus, "Status"), status, "Status is not correct");
    }

    public void clickOnReceiveButton() {
        click(getElement(By.xpath("//td[text()='" + globalVariables.get("PurchaseOrder") + "']/following-sibling::td/button"), "Receive button"), "Receive button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void clickOnCompleteButton() {
        click(getElement(By.xpath("//td[text()='" + globalVariables.get("NewGRNNumber") + "']/following-sibling::td/button"), "Receive button"), "Receive button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void getLatestGRNNumber() {
        String grnNumber = getText(grnTableNumbers.get(0), "GRN number").split("-")[2];
        String newGRNNumber = "GRN-" + DateTimeUtils.getFutureDate(0, "YYYYMM") + "-" + String.format("%0" + grnNumber.length() + "d", Integer.parseInt(grnNumber) + 1);
        globalVariables.put("NewGRNNumber", newGRNNumber);
    }

    public void verifyGRNReportDefaultValues(String receiptType) {
        Assert.assertEquals(getText(facilityDropdown, "Facility"), globalVariables.get("Facility"), "Facility is not correct on create GRN popup");
        Assert.assertEquals(getText(receiptDropdown, "Receipt"), receiptType, "Receipt Type is not correct on create GRN popup");
        Assert.assertEquals(getText(purchaseOrderDropdown, "Purchase Order"), globalVariables.get("PurchaseOrder") + " — " + globalVariables.get("Vendor"), "Purchase Order is not correct on create GRN popup");
        click(closeBtnOnPopup, "Close button");
        WaitUtils.waitForInvisibilityOfElement(closeBtnOnPopup);
    }

    public void createGRN(String vehicleNumber, String driverName, String lrNumber, String notes) {
        enterText(vehicleNumberTxtBox, vehicleNumber, "Vehicle number");
        enterText(driverNameTxtBox, driverName, "Driver name");
        enterText(lrNumberTxtBox, lrNumber, "LR Number");
        enterText(notesTxtBox, notes, "Notes");

        click(createGrnBtnOnPopup, "Create GRN button");
        WaitUtils.waitForInvisibilityOfElement(createGrnBtnOnPopup);
    }

    public void verifyPurchaseOrderDetailsInInboundDeliveriesGRNsTab(String items, String receivedQty, String qcStatus) {
        Assert.assertEquals(getText(grnTableNumbers.get(0), "GRN Number"), globalVariables.get("NewGRNNumber"), "GRN number is not correct in GRN table");
        Assert.assertEquals(getText(grnTableVendors.get(0), "Vendor"), globalVariables.get("Vendor"), "Vendor is not correct in GRN table");
        Assert.assertEquals(getText(grnTableItems, "Items"), items, "Items is not correct in GRN table");
        Assert.assertEquals(getText(grnTableReceivedQuantity, "Received Qty"), receivedQty, "Received Quantity is not correct in GRN table");
        Assert.assertEquals(getText(grnTableReceivedAt, "Received At"), DateTimeUtils.getFutureDate(0, "M/dd/yyyy"));
        Assert.assertEquals(getText(grnTableQCStatus, "QC Status"), qcStatus, "QC Status is not correct in GRN table");
    }

    public void completeGRN(String received, String accepted, String rejected, String lotNumber, String expiryDateValue) {
        selectDropdownValue(productDropdown, dropdownValues, globalVariables.get("ProductName"), "Product dropdown");
        enterText(receivedTxtBox, received, "Received");
        enterText(rejectedTxtBox, rejected, "Rejected");
        enterText(lotNumberTxtBox, lotNumber, "Lot Number");
        enterText(expiryDate, DateTimeUtils.getFutureDate(Integer.parseInt(expiryDateValue.split("\\+")[1]), "dd-MM-yyyy"), "Expiry Date");

        click(completeGrnBtn, "Complete GRN button");
        WaitUtils.waitForInvisibilityOfElement(completeGrnBtn);
    }

    public void searchPONumber() {
        enterText(posSearchTextbox, globalVariables.get("PurchaseOrder"), "Purchase Order");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyPendingPOsCount() {
        WaitUtils.sleepFor(5000);
        String pendingPOsTotalCount = getText(pendingPOsCount, "Pending POs count");
        String pendingPOsCountFromTab = getText(pendingPOsTab, "Pending POs count from tab").split("\\(")[1].replace(")", "");
        String totalPagesFromPagination = commonPage.getTotalPages().split("\\(")[1].split(" ")[0];
        Assert.assertEquals(pendingPOsCountFromTab, pendingPOsTotalCount, "Total count mismatch in card and tab");
        Assert.assertEquals(totalPagesFromPagination, pendingPOsTotalCount, "Total count mismatch in card and pagination");
    }

    public void verifyInProgressGRNCount() {
        String pendingPOsTotalCount = getText(inProgressGRNCount, "In progress GRN count");
        String totalPagesFromPagination = commonPage.getTotalPages().split(" ")[3];
        int tempInProgressGRNCount = 0;
        for (int i = 0; i < Integer.parseInt(totalPagesFromPagination); i++) {
            log.info("Getting all total in progress GRN count from page " + (i + 1));
            tempInProgressGRNCount = tempInProgressGRNCount + totalInProgress.size();
            if (i != Integer.parseInt(totalPagesFromPagination) - 1) {
                commonPage.clickOnNextBtn();
            }
        }
        Assert.assertEquals(pendingPOsTotalCount, String.valueOf(tempInProgressGRNCount), "Total In progress GRN count mismatched from card and all pages");
    }

    public void verifyCompletedGRNCount() {
        String completedPOsTotalCount = getText(completedGRNCount, "Completed GRN count");
        String totalPagesFromPagination = commonPage.getTotalPages().split(" ")[3];
        int tempCompletedGRNCount = 0;
        for (int i = 0; i < Integer.parseInt(totalPagesFromPagination); i++) {
            log.info("Getting all total in progress GRN count from page " + (i + 1));
            tempCompletedGRNCount = tempCompletedGRNCount + totalCompletedAndPassed.size();
            if (i != Integer.parseInt(totalPagesFromPagination) - 1) {
                commonPage.clickOnNextBtn();
            }
        }
        Assert.assertEquals(completedPOsTotalCount, String.valueOf(tempCompletedGRNCount), "Total Completed GRN count mismatched from card and all pages");
    }

    public void verifyTotalGRNCount() {
        String totalPOsTotalCount = getText(totalGRNCCount, "Total POs count");
        String pendingPOsTotalCount = getText(inProgressGRNCount, "In progress GRN count");
        String completedPOsTotalCount = getText(completedGRNCount, "Completed GRN count");
        String tempCount = String.valueOf(Integer.parseInt(pendingPOsTotalCount) + Integer.parseInt(completedPOsTotalCount));
        Assert.assertEquals(totalPOsTotalCount, tempCount, "Total count mismatch in card total and card inprogress + completed");
        Assert.assertTrue(commonPage.getTotalPages().contains(totalPOsTotalCount), "Total count mismatch in card and pagination");
    }

    public void verifyPONumberSearchInPendingPOs() {
        String poNumber = getText(posTableNumbers.get(0), "PO number");
        enterText(posSearchTextbox, poNumber, "PO number");
        List<String> allActualPoOrders = getAllElementsValues(posTableNumbers);
        boolean allMatch = allActualPoOrders.stream().allMatch(order -> order.equals(poNumber));
        Assert.assertTrue(allMatch, "Search not worked correctly when search with Po Order in Pending POs tab");
    }

    public void verifyVendorsSearchInPendingPOs() {
        String vendor = getText(posTableVendors.get(0), "Vendors");
        selectDropdownValue(posSearchVendorDropdown, dropdownValues, vendor, "Search Vendor dropdown");
        WaitUtils.sleepFor(2000);
        List<String> allActualVendors = getAllElementsValues(posTableVendors);
        boolean allMatch = allActualVendors.stream().allMatch(order -> order.equals(vendor));
        Assert.assertTrue(allMatch, "Search not worked correctly when search with Vendors in Pending POs tab");
    }

    public void clearPOsSearch() {
        clearData(posSearchTextbox, "POs search textbox");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifyVendorsSearchInGRNs() {
        String vendor = getText(grnTableVendors.get(0), "Vendors");
        selectDropdownValue(grnSearchVendorsDropdown, dropdownValues, vendor, "Search Vendor dropdown");
        WaitUtils.sleepFor(2000);
        List<String> allActualVendors = getAllElementsValues(grnTableVendors);
        boolean allMatch = allActualVendors.stream().allMatch(order -> order.equals(vendor));
        Assert.assertTrue(allMatch, "Search not worked correctly when search with Vendors in GRNs tab");
    }

    public void verifyGRNSearchInGRNs() {
        String grnNumber = getText(grnTableNumbers.get(0), "GRN number");
        enterText(searchGRNTextbox, grnNumber, "GRN number");
        WaitUtils.sleepFor(2000);
        List<String> allActualGRNOrders = getAllElementsValues(posTableNumbers);
        boolean allMatch = allActualGRNOrders.stream().allMatch(order -> order.equals(grnNumber));
        Assert.assertTrue(allMatch, "Search not worked correctly when search with GRN in GRNs tab");
    }

    public void clearGRNSearch() {
        clearData(searchGRNTextbox, "GRNs search textbox");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

}