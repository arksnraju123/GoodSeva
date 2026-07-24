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
            binsPage.createNewBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Lever"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @When("^User Edit new Bin$")
    public void editBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.editBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Lever"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @When("^Verify newly created Bin$")
    public void verifyBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.verifyBin(row.get("Location"), row.get("Type"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @When("^User search with Bin Name$")
    public void searchWithBinName() {
        binsPage.searchWithBinName();
    }

    @Then("^Verify search results with searched Bin Codes$")
    public void verifySearchBin() {
        binsPage.verifySearchBin();
    }

    @When("^User search with Zone$")
    public void searchWithZone() {
        binsPage.searchWithZone();
    }

    @Then("^Verify search results with searched Zone$")
    public void verifySearchZone() {
        binsPage.verifySearchZone();
    }

    @When("^User search with Type$")
    public void searchWithType() {
        binsPage.searchWithType();
    }

    @Then("^Verify search results with searched Type")
    public void verifySearchType() {
        binsPage.verifySearchType();
    }

    @When("^User search with Status$")
    public void searchWithStatus() {
        binsPage.searchWithStatus();
    }

    @Then("^Verify search results with searched Status")
    public void verifySearchStatus() {
        binsPage.verifySearchStatus();
    }

    @When("^User reset (.*) search")
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
}
