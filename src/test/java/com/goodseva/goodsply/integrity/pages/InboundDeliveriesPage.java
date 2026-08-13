package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InboundDeliveriesPage extends DriverUtils {
    public InboundDeliveriesPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

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
    private WebElement posTableNumbers;

    @FindBy(how = How.XPATH, using = "//table//tr/td[2]")
    private WebElement posTableVendors;

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
}
