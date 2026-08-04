package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.BinsPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class BinsSteps {
    BinsPage binsPage = new BinsPage(WebDriverHelper.getDriver());

    @When("^User Add new Bin$")
    public void addBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.createNewBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Level"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @When("^User Edit new Bin$")
    public void editBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.editBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Level"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @Then("^Verify newly (.*) Bin$")
    public void verifyBin(String action, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.verifyBin(row.get("Location"), row.get("Type"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @Then("^Verify newly (.*) Bin from Facilities$")
    public void verifyBinCreatedInFacilities(String action, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.verifyBinCreatedInFacilities(row.get("Location"), row.get("Type"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @When("^User search with Bin Name in Bins page$")
    public void searchWithBinName() {
        binsPage.searchWithBinName();
    }

    @Then("^Verify search results with searched Bin Codes in Bins page$")
    public void verifySearchBin() {
        binsPage.verifySearchBin();
    }

    @When("^User search with Zone in Bins page$")
    public void searchWithZone() {
        binsPage.searchWithZone();
    }

    @Then("^Verify search results with searched Zone in Bins page$")
    public void verifySearchZone() {
        binsPage.verifySearchZone();
    }

    @When("^User search with Type in Bins page$")
    public void searchWithType() {
        binsPage.searchWithType();
    }

    @Then("^Verify search results with searched Type in Bins page")
    public void verifySearchType() {
        binsPage.verifySearchType();
    }

    @When("^User search with Status in Bins page$")
    public void searchWithStatus() {
        binsPage.searchWithStatus();
    }

    @Then("^Verify search results with searched Status in Bins page")
    public void verifySearchStatus() {
        binsPage.verifySearchStatus();
    }

    @When("^User reset (.*) search in Bins page")
    public void resetSearch(String searchField) {
        binsPage.resetSearch(searchField);
    }

    @When("^User search for invalid Bin$")
    public void searchWithInvalidBinName() {
        binsPage.searchWithInvalidBinName();
    }

    @Then("^Verify No bins found in table")
    public void verifyTableMessage() {
        binsPage.verifyTableMessage();
    }

    @Then("^Verify No bins yet — use \"Add Bin\" above to create one")
    public void verifyNoBinMessage() {
        binsPage.verifyNoBinMessage();
    }

    @When("^User delete Bin in Bins page")
    public void clickOnDelete() {
        binsPage.deleteBin();
    }

    @Then("^Verify Bin has deleted in Bins page")
    public void verifyBinDeleted() {
        binsPage.verifyBinDeleted();
    }

    @Then("^User click on Print button")
    public void clickOnPrint() {
        binsPage.clickOnPrint();
    }

    @Then("^Verify downloaded PDF file$")
    public void verifyPDFFile(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.verifyPDFFile(row.get("Type"), row.get("Capacity"), row.get("Status"));
        }
    }

    @Then("^Verify all edited fields in edit Bin page$")
    public void verifyEditBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.verifyEditBinPage(row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Level"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }
}
