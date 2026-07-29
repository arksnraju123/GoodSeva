package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.ProductsAndSKUsPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ProductsAndSKUsSteps {
    ProductsAndSKUsPage productsAndSKUsPage = new ProductsAndSKUsPage(WebDriverHelper.getDriver());

    @When("^User Add new Product$")
    public void addProduct(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            productsAndSKUsPage.createNewProduct(row.get("SKU"), row.get("ProductName"), row.get("Description"), row.get("Category"), row.get("Brand"), row.get("UnitOfMeasure"), row.get("Weight"), row.get("Length"), row.get("Width"), row.get("Height"), row.get("BarcodeType"), row.get("BarcodeValue"), row.get("ActiveProduct"), row.get("SerialTracked"), row.get("LotTracked"), row.get("ShelfLife"), row.get("ReorderPoint"), row.get("ReorderQuantity"));
        }
    }

    @Then("^Verify newly created Product$")
    public void verifyProduct(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            productsAndSKUsPage.verifyProduct(row.get("Category"), row.get("Brand"), row.get("Unit"), row.get("Status"), row.get("Tracking"));
        }
    }

    @Then("^Verify newly edited Product$")
    public void verifyUpdatedProduct(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            productsAndSKUsPage.verifyUpdatedProduct(row.get("Category"), row.get("Brand"), row.get("Unit"), row.get("Status"), row.get("Tracking"));
        }
    }

    @When("^User search with SKU in Products page$")
    public void searchSKU() {
        productsAndSKUsPage.searchWithSKU();
    }

    @Then("^Verify search results with searched SKU in Products page$")
    public void verifySearchSKU() {
        productsAndSKUsPage.verifySearchSKU();
    }

    @When("^User reset (.*) search in Products page$")
    public void verifySearchSKU(String field) {
        productsAndSKUsPage.resetSearch(field);
    }

    @When("^User search with Name in Products page$")
    public void searchName() {
        productsAndSKUsPage.searchWithName();
    }

    @Then("^Verify search results with searched Name in Products page$")
    public void verifySearchName() {
        productsAndSKUsPage.verifySearchProductName();
    }

    @When("^User search with Category in Products page$")
    public void searchCategory() {
        productsAndSKUsPage.searchCategory();
    }

    @Then("^Verify search results with searched Category in Products page$")
    public void verifySearchCategory() {
        productsAndSKUsPage.verifySearchCategory();
    }

    @When("^User search with Status in Products page$")
    public void searchStatus() {
        productsAndSKUsPage.searchWithStatus();
    }

    @Then("^Verify search results with searched Status in Products page$")
    public void verifySearchStatus() {
        productsAndSKUsPage.verifySearchStatus();
    }

    @When("^User Edit new Product$")
    public void editProduct(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            productsAndSKUsPage.editProduct(row.get("ProductName"), row.get("Description"), row.get("Category"), row.get("Brand"), row.get("UnitOfMeasure"), row.get("Weight"), row.get("Length"), row.get("Width"), row.get("Height"), row.get("BarcodeType"), row.get("BarcodeValue"), row.get("ActiveProduct"), row.get("SerialTracked"), row.get("LotTracked"), row.get("ShelfLife"), row.get("ReorderPoint"), row.get("ReorderQuantity"));
        }
    }

    @Then("^Verify all edited fields in edit Product page$")
    public void verifyEditedProduct(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            productsAndSKUsPage.verifyEditedInEditScreen(row.get("SKU"), row.get("ProductName"), row.get("Description"), row.get("Category"), row.get("Brand"), row.get("UnitOfMeasure"), row.get("Weight"), row.get("Length"), row.get("Width"), row.get("Height"), row.get("BarcodeType"), row.get("BarcodeValue"), row.get("ActiveProduct"), row.get("SerialTracked"), row.get("LotTracked"), row.get("ShelfLife"), row.get("ReorderPoint"), row.get("ReorderQuantity"));
        }
    }

    @When("^User click on Delete in Products page$")
    public void deleteProduct() {
        productsAndSKUsPage.deleteProduct();
    }

    @When("^Verify Bin has deleted in Products page$")
    public void verifyDelete() {
        productsAndSKUsPage.verifyDelete();
    }
}
