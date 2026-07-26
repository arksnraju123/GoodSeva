package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsAndSKUsPage extends DriverUtils {
    public ProductsAndSKUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Previous']/preceding::div[1]")
    private WebElement totalProducts;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-add-product']")
    private WebElement addProductBtn;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-search-products']")
    private WebElement productsSearchTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-category']")
    private WebElement categoryFilterDropdown;

    @FindBy(how = How.XPATH, using = "//span[@data-component-name='SelectPrimitive.ItemText']")
    private List<WebElement> filterByDropdownValues;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-status']")
    private WebElement statusFilterDropdown;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[1]/div")
    private WebElement skuFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[2]/div/div/div")
    private WebElement nameFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[3]/div")
    private WebElement categoryFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[4]")
    private WebElement brandFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[5]/div")
    private WebElement unitFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[6]/div")
    private WebElement statusFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[7]/div/div[1]")
    private WebElement trackingSerialFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[7]/div/div[2]")
    private WebElement trackingLotFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[7]/div/span")
    private WebElement trackingNoneFromTable;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-sku']")
    private WebElement skuTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-name']")
    private WebElement productNameTxtBox;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='input-product-description']")
    private WebElement descriptionTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-product-category']")
    private WebElement categoryDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-brand']")
    private WebElement brandTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-unit-measure']")
    private WebElement unitOfMeasureTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-weight']")
    private WebElement weightTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-length']")
    private WebElement lengthTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-width']")
    private WebElement widthTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-height']")
    private WebElement heightTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-barcode-type']")
    private WebElement barCodeDropdown;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-barcode-value']")
    private WebElement barCodeValueTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='checkbox-is-active']")
    private WebElement activeProductRadioBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='checkbox-serial-tracked']")
    private WebElement serialTrackedRadioBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='checkbox-lot-tracked']")
    private WebElement lotTrackedRadioBtn;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-shelf-life']")
    private WebElement shelfLifeTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-reorder-point']")
    private WebElement reorderPointTxtBox;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-reorder-quantity']")
    private WebElement reorderQuantityTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-cancel']")
    private WebElement cancelBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-save-product']")
    private WebElement createProductBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-next-page']")
    private WebElement nextBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-prev-page']")
    private WebElement previousBtn;

    public String getTotalProducts() throws InterruptedException {
        WaitUtils.sleepFor(2000);
        return getText(totalProducts, "Total Products").split("\\(")[1].replaceAll("\\D+", "");
    }
}
