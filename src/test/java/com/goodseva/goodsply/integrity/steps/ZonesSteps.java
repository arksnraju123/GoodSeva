package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.ZonesPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class ZonesSteps {
    ZonesPage zonesPage = new ZonesPage(WebDriverHelper.getDriver());

    @Given("^User click on Add Zone button$")
    public void clickOnAddZone() {
        zonesPage.clickOnAddZone();
    }

    @When("^User (.*) Zone with bellow data$")
    public void createNewZone(String action, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            zonesPage.createUpdateNewZone(row.get("Facility"), row.get("ZoneName"), row.get("ZoneCode"), row.get("ZoneType"), row.get("Temperature"), row.get("MaximumCapacity"), row.get("Status"));
        }
    }

    @When("^User search for Zone$")
    public void searchForZone() {
        zonesPage.searchZone();
    }

    @When("^Verify (.*) Zone details$")
    public void verifyNewZone(String action, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            zonesPage.verifyZone(row.get("ZoneType"), row.get("Temperature"), row.get("MaximumCapacity"), row.get("Status"));
        }
    }

    @When("^User click on edit Zone$")
    public void clickEdit() {
        zonesPage.editZone();
    }

    @When("^User Delete Zone$")
    public void deleteZone() {
        zonesPage.deleteZone();
    }

    @Then("^Verify Zone has deleted$")
    public void verifyZoneDeleted() {
        zonesPage.searchZone();
        zonesPage.verifyZoneDeleted();
    }

    @Then("^Verify search results with searched Zone in Zones page$")
    public void verifyZoneSearch() {
        zonesPage.verifyZoneSearch();
    }

    @When("^User reset (Zone|Zone Code|Facility) search in Zones page$")
    public void resetSearch(String field) {
        zonesPage.resetSearch(field);
    }

    @When("^User search for Zone Code$")
    public void searchForZoneCode() {
        zonesPage.searchZoneCode();
    }

    @Then("^Verify search results with searched Zone Code in Zones page$")
    public void verifyZoneCodeSearch() {
        zonesPage.verifyZoneCodeSearch();
    }

    @When("^User search for Facility$")
    public void searchForFacility() {
        zonesPage.searchForFacility();
    }

    @Then("^Verify search results with searched Facility in Zones page$")
    public void verifyFacilitySearch() {
        zonesPage.verifyFacilitySearch();
    }

    @When("^User search for Type")
    public void searchForType() {
        zonesPage.searchForType();
    }

    @Then("^Verify search results with searched Type in Zones page$")
    public void verifyTypeSearch() {
        zonesPage.verifyTypeSearch();
    }
}
