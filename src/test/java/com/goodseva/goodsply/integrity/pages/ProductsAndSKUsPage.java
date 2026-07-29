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
    private List<WebElement> dropdownValues;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-filter-status']")
    private WebElement statusFilterDropdown;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[1]/div")
    private WebElement skuFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[1]/div")
    private List<WebElement> allSKUFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[2]/div/div/div")
    private WebElement nameFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[2]/div/div/div[2]")
    private WebElement descriptionFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[2]/div/div/div[1]")
    private List<WebElement> allNameFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow'][1]/td[3]/div")
    private WebElement categoryFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[3]/div")
    private List<WebElement> allCategoryFromTable;

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[6]/div")
    private List<WebElement> allStatusFromTable;

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

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-product-category']/span")
    private WebElement categoryDropdownValue;

    @FindBy(how = How.XPATH, using = "//input[@data-testid='input-product-brand']")
    private WebElement brandTxtBox;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-unit-measure']")
    private WebElement unitOfMeasureDropdown;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-unit-measure']/span")
    private WebElement unitOfMeasureDropdownValue;

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

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-barcode-type']/span")
    private WebElement barCodeDropdownValue;

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

    @FindBy(how = How.XPATH, using = "//tbody//tr[@data-component-name='TableRow']/td[1]")
    private WebElement tableMsg;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-cancel']")
    private WebElement cancelBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-save-product']")
    private WebElement createProductBtn;

    public String getTotalProducts() throws InterruptedException {
        WaitUtils.sleepFor(2000);
        return getText(totalProducts, "Total Products").split("\\(")[1].replaceAll("\\D+", "");
    }

    public void createNewProduct(String sku, String productName, String description, String category, String brand, String unitOfMeasure, String weight, String length, String width, String height, String barcodeType, String barcodeValue, String activeProduct, String serialTracked, String lotTracked, String shelfLife, String reorderPoint, String reorderQuantity) {
        click(addProductBtn, "Add Product button");
        WaitUtils.sleepFor(2000);
        WaitUtils.waitForElementClickable(skuTxtBox);
        String skuValue = sku.concat(StringUtils.getRandomNumber());
        String productNameValue = productName.concat(StringUtils.getRandomNumber());
        globalVariables.put("SKU", skuValue);
        globalVariables.put("ProductName", productNameValue);
        globalVariables.put("Category", category);
        globalVariables.put("Status", "Active");
        globalVariables.put("Description", description);
        enterText(skuTxtBox, skuValue, "SKU");
        enterText(productNameTxtBox, productNameValue, "Product Name");
        enterText(descriptionTxtBox, description, "Description");
        selectDropdownValue(categoryDropdown, dropdownValues, category, "Category dropdown");
        enterText(brandTxtBox, brand, "Brand");
        selectDropdownValue(unitOfMeasureDropdown, dropdownValues, unitOfMeasure, "Unit Of Measure dropdown");
        enterText(weightTxtBox, weight, "Weight");
        enterText(lengthTxtBox, length, "Length");
        enterText(widthTxtBox, width, "Width");
        enterText(heightTxtBox, height, "Height");
        selectDropdownValue(barCodeDropdown, dropdownValues, barcodeType, "Barcode Type");
        enterText(barCodeValueTxtBox, barcodeValue, "Barcode Value");
        if (activeProduct.equalsIgnoreCase("Yes")) {
            if (!getAttribute(activeProductRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(activeProductRadioBtn, "Active radio button");
        } else {
            if (!getAttribute(activeProductRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(activeProductRadioBtn, "Active radio button");
        }

        if (serialTracked.equalsIgnoreCase("Yes")) {
            if (!getAttribute(serialTrackedRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(serialTrackedRadioBtn, "Serial Tracked radio button");
        } else {
            if (!getAttribute(serialTrackedRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(serialTrackedRadioBtn, "Serial Tracked radio button");
        }

        if (lotTracked.equalsIgnoreCase("Yes")) {
            if (!getAttribute(lotTrackedRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(lotTrackedRadioBtn, "Lot Tracked radio button");
        } else {
            if (!getAttribute(lotTrackedRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(lotTrackedRadioBtn, "Lot Tracked radio button");
        }

        enterText(shelfLifeTxtBox, shelfLife, "Shelf Life");
        enterText(reorderPointTxtBox, reorderPoint, "Reorder Point");
        enterText(reorderQuantityTxtBox, reorderQuantity, "Reorder Quantity");

        click(createProductBtn, "Create Product");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(5000);
    }

    public void editProduct(String productName, String description, String category, String brand, String unitOfMeasure, String weight, String length, String width, String height, String barcodeType, String barcodeValue, String activeProduct, String serialTracked, String lotTracked, String shelfLife, String reorderPoint, String reorderQuantity) {
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("SKU") + "']//following::button[contains(@data-testid,'button-edit-product')][1]")), "Add Product button");
        WaitUtils.sleepFor(2000);
        WaitUtils.waitForElementClickable(skuTxtBox);
        String productNameValue = productName.concat(StringUtils.getRandomNumber());
        globalVariables.replace("ProductName", productNameValue);
        globalVariables.replace("Category", category);
        globalVariables.replace("Status", "Inactive");
        globalVariables.replace("Description", description);
        enterText(productNameTxtBox, productNameValue, "Product Name");
        enterText(descriptionTxtBox, description, "Description");
        selectDropdownValue(categoryDropdown, dropdownValues, category, "Category dropdown");
        enterText(brandTxtBox, brand, "Brand");
        selectDropdownValue(unitOfMeasureDropdown, dropdownValues, unitOfMeasure, "Unit Of Measure dropdown");
        enterText(weightTxtBox, weight, "Weight");
        enterText(lengthTxtBox, length, "Length");
        enterText(widthTxtBox, width, "Width");
        enterText(heightTxtBox, height, "Height");
        selectDropdownValues(barCodeDropdown, dropdownValues, barcodeType, "Barcode Type");
        enterText(barCodeValueTxtBox, barcodeValue, "Barcode Value");
        if (activeProduct.equalsIgnoreCase("Yes")) {
            if (!getAttribute(activeProductRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(activeProductRadioBtn, "Active radio button");
        } else {
            if (!getAttribute(activeProductRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(activeProductRadioBtn, "Active radio button");
        }

        if (serialTracked.equalsIgnoreCase("Yes")) {
            if (!getAttribute(serialTrackedRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(serialTrackedRadioBtn, "Serial Tracked radio button");
        } else {
            if (!getAttribute(serialTrackedRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(serialTrackedRadioBtn, "Serial Tracked radio button");
        }

        if (lotTracked.equalsIgnoreCase("Yes")) {
            if (!getAttribute(lotTrackedRadioBtn, "aria-checked").equalsIgnoreCase("true"))
                click(lotTrackedRadioBtn, "Lot Tracked radio button");
        } else {
            if (!getAttribute(lotTrackedRadioBtn, "aria-checked").equalsIgnoreCase("false"))
                click(lotTrackedRadioBtn, "Lot Tracked radio button");
        }

        enterText(shelfLifeTxtBox, shelfLife, "Shelf Life");
        enterText(reorderPointTxtBox, reorderPoint, "Reorder Point");
        enterText(reorderQuantityTxtBox, reorderQuantity, "Reorder Quantity");

        click(createProductBtn, "Update Product");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(5000);
    }

    public void verifyProduct(String category, String brand, String unit, String status, String tracking) {
        Assert.assertEquals(getText(skuFromTable, "SKU from table"), globalVariables.get("SKU"), "SKU is wrong");
        Assert.assertEquals(getText(nameFromTable, "Name from table"), globalVariables.get("ProductName"), "Product Name is wrong");
        Assert.assertEquals(getText(descriptionFromTable, "Description from table"), globalVariables.get("Description"), "Description is wrong");
        Assert.assertEquals(getText(categoryFromTable, "Category from table"), category, "Category is wrong");
        Assert.assertEquals(getText(brandFromTable, "Brand from table"), brand, "Brand is wrong");
        Assert.assertEquals(getText(unitFromTable, "Unit from table"), unit, "Unit is wrong");
        Assert.assertEquals(getText(trackingSerialFromTable, "Tracking Serial from table"), tracking.split(",")[0], "Tracking Serial is wrong");
        Assert.assertEquals(getText(trackingLotFromTable, "Tracking Lot from table"), tracking.split(",")[1], "Tracking Lot is wrong");
    }

    public void verifyUpdatedProduct(String category, String brand, String unit, String status, String tracking) {
        Assert.assertEquals(getText(skuFromTable, "SKU from table"), globalVariables.get("SKU"), "SKU is wrong");
        Assert.assertEquals(getText(nameFromTable, "Name from table"), globalVariables.get("ProductName"), "Product Name is wrong");
        Assert.assertEquals(getText(descriptionFromTable, "Description from table"), globalVariables.get("Description"), "Description is wrong");
        Assert.assertEquals(getText(categoryFromTable, "Category from table"), category, "Category is wrong");
        Assert.assertEquals(getText(brandFromTable, "Brand from table"), brand, "Brand is wrong");
        Assert.assertEquals(getText(unitFromTable, "Unit from table"), unit, "Unit is wrong");
        Assert.assertEquals(getText(trackingNoneFromTable, "Tracking None from table"), tracking, "Tracking None is wrong");
    }

    public void searchWithSKU() {
        enterText(productsSearchTxtBox, globalVariables.get("SKU"), "SKU");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void searchWithName() {
        enterText(productsSearchTxtBox, globalVariables.get("ProductName"), "ProductName");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void searchWithStatus() {
        selectDropdownValues(statusFilterDropdown, dropdownValues, globalVariables.get("Status"), "Status dropdown");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void searchCategory() {
        selectDropdownValues(categoryFilterDropdown, dropdownValues, globalVariables.get("Category"), "Category dropdown");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
    }

    public void verifySearchSKU() {
        List<String> allValues = getAllElementsValues(allSKUFromTable);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("SKU"))), "Search not worked correctly when search with SKU");
    }

    public void verifySearchProductName() {
        List<String> allValues = getAllElementsValues(allNameFromTable);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("ProductName"))), "Search not worked correctly when search with Product Name");
    }

    public void verifySearchCategory() {
        List<String> allValues = getAllElementsValues(allCategoryFromTable);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("Category"))), "Search not worked correctly when search with Category");
    }

    public void verifySearchStatus() {
        List<String> allValues = getAllElementsValues(allStatusFromTable);
        Assert.assertTrue(allValues.stream().allMatch(s -> s.contains(globalVariables.get("Status"))), "Search not worked correctly when search with Status");
    }

    public void resetSearch(String searchField) {
        if (searchField.equalsIgnoreCase("SKU") || searchField.equalsIgnoreCase("Name")) {
            clearData(productsSearchTxtBox, "Clearing " + searchField + " textbox");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }

        if (searchField.equalsIgnoreCase("Category")) {
            selectDropdownValues(categoryFilterDropdown, dropdownValues, "All Categories", "Category dropdown");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }

        if (searchField.equalsIgnoreCase("Status")) {
            selectDropdownValues(statusFilterDropdown, dropdownValues, "All Status", "Status dropdown");
            WaitUtils.waitForPageLoads();
            WaitUtils.sleepFor(2000);
        }
    }

    public void verifyEditedInEditScreen(String sku, String productName, String description, String category, String brand, String unitOfMeasure, String weight, String length, String width, String height, String barcodeType, String barcodeValue, String activeProduct, String serialTracked, String lotTracked, String shelfLife, String reorderPoint, String reorderQuantity) {
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("SKU") + "']//following::button[contains(@data-testid,'button-edit-product')][1]")), "Edit Product button");
        WaitUtils.sleepFor(2000);
        WaitUtils.waitForElementClickable(skuTxtBox);
        Assert.assertEquals(getTextBoxValue(skuTxtBox, "SKU In Edit page"), globalVariables.get("SKU"), "SKU is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(productNameTxtBox, "ProductName In Edit page"), globalVariables.get("ProductName"), "ProductName is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(descriptionTxtBox, "Description In Edit page"), globalVariables.get("Description"), "Description is wrong in Edit page");
        Assert.assertEquals(getText(categoryDropdownValue, "Category In Edit page"), globalVariables.get("Category"), "Category is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(brandTxtBox, "Brand In Edit page"), brand, "Brand is wrong in Edit page");
        Assert.assertEquals(getText(unitOfMeasureDropdownValue, "Unit Of Measure In Edit page"), unitOfMeasure, "Unit Of Measure is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(weightTxtBox, "Weight In Edit page"), weight, "Weight is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(lengthTxtBox, "Length In Edit page"), length, "Length is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(widthTxtBox, "Width In Edit page"), width, "Width is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(heightTxtBox, "Height In Edit page"), height, "Height is wrong in Edit page");
        Assert.assertEquals(getText(barCodeDropdownValue, "Barcode In Edit page"), barcodeType, "Barcode is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(barCodeValueTxtBox, "Barcode Value In Edit page"), barcodeValue, "Barcode Value is wrong in Edit page");

        if (activeProduct.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(activeProductRadioBtn, "aria-checked"), "true", "Edited Active Product is wrong");
        } else {
            Assert.assertEquals(getAttribute(activeProductRadioBtn, "aria-checked"), "false", "Edited Active Product is wrong");
        }

        if (serialTracked.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(serialTrackedRadioBtn, "aria-checked"), "true", "Edited Serial Tracked is wrong");
        } else {
            Assert.assertEquals(getAttribute(serialTrackedRadioBtn, "aria-checked"), "false", "Edited Serial Tracked is wrong");
        }

        if (lotTracked.equalsIgnoreCase("Yes")) {
            Assert.assertEquals(getAttribute(lotTrackedRadioBtn, "aria-checked"), "true", "Edited Lot Tracked is wrong");
        } else {
            Assert.assertEquals(getAttribute(lotTrackedRadioBtn, "aria-checked"), "false", "Edited Lot Tracked is wrong");
        }

        Assert.assertEquals(getTextBoxValue(shelfLifeTxtBox, "Shelf Life Value In Edit page"), shelfLife, "Shelf Life Value is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(reorderPointTxtBox, "Reorder Point Value In Edit page"), reorderPoint, "Reorder Point Value is wrong in Edit page");
        Assert.assertEquals(getTextBoxValue(reorderQuantityTxtBox, "Reorder Quantity Value In Edit page"), reorderQuantity, "Reorder Quantity Value is wrong in Edit page");

        click(cancelBtn, "Cancel button");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(5000);
    }

    public void deleteProduct() {
        click(getDriver().findElement(By.xpath("//div[text()='" + globalVariables.get("SKU") + "']//following::button[contains(@data-testid,'button-delete-product')][1]")), "Delete Product button");
        WaitUtils.sleepFor(1000);
        acceptAlert();
    }

    public void verifyDelete() {
        WaitUtils.sleepFor(1000);
        enterText(productsSearchTxtBox, globalVariables.get("SKU"), "SKU");
        WaitUtils.waitForPageLoads();
        WaitUtils.sleepFor(2000);
        Assert.assertEquals(getText(tableMsg, "Table message"), "No products found", "Product has not deleted when delete it");
    }
}
