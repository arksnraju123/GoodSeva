package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.ZonesPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
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
    public void createNewZone(String action, DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            zonesPage.createUpdateNewZone(row.get("Facility"), row.get("ZoneName"), row.get("ZoneCode"), row.get("ZoneType"), row.get("Temperature"), row.get("MaximumCapacity"), row.get("Status"));
        }
    }

    @When("^User search for Zone$")
    public void searchForZone()  {
        zonesPage.searchZone();
    }

    @When("^Verify (.*) Zone details$")
    public void verifyNewZone(String action, DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            zonesPage.verifyZone(row.get("Facility"), row.get("ZoneName"), row.get("ZoneCode"), row.get("ZoneType"), row.get("Temperature"), row.get("MaximumCapacity"), row.get("Status"));
        }
    }

    @When("^User click on edit Zone$")
    public void clickEdit()  {
        zonesPage.editZone();
    }

    @When("^User Delete Zone$")
    public void deleteZone() throws InterruptedException {
        zonesPage.deleteZone();
    }

    @When("^Verify Zone has deleted$")
    public void verifyZoneDeleted()  {
        zonesPage.searchZone();
        zonesPage.verifyZoneDeleted();
    }
}
