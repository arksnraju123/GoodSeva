package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.FacilitiesPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class FacilitiesSteps {
    FacilitiesPage facilitiesPage = new FacilitiesPage(WebDriverHelper.getDriver());

    @When("^User Add new Facility$")
    public void createNewFacility(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.createNewFacility(row.get("FacilityName"), row.get("Address"), row.get("HoursStart"), row.get("HoursEnd"), row.get("TotalDockDoors"));
        }
    }

    @When("^User search with newly created Facility$")
    public void searchFacility() {
        facilitiesPage.searchFacility();
    }

    @Then("^Verify bellow facility details$")
    public void verifyFacilityDetails$(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.verifyNewFacility(row.get("FacilityName"), row.get("Address"), row.get("HoursStart"), row.get("HoursEnd"), row.get("TotalDockDoors"), row.get("Status"));
        }
    }

    @When("^User click on newly created facility$")
    public void clickOnFacility() {
        facilitiesPage.clickOnFacility();
    }

    @Then("^Verify selected facility name$")
    public void verifyFacilityName() {
        facilitiesPage.verifyFacilityName();
    }

    @When("^User open (Dock Door|Zones|Bins) tab$")
    public void openTab(String tab) {
        facilitiesPage.openTab(tab);
    }

    @Then("^Verify default (No dock doors yet|No zones yet|Create a zone first) message$")
    public void verifyDefaultDocMsg(String msg) {
        facilitiesPage.verifyDefaultDockZoneBinMsg(msg);
    }

    @Then("^Verify Add Bin button disabled when no Zones exist$")
    public void verifyAddBinDisabled() {
        facilitiesPage.verifyAddBinDisabled();
    }

    @When("^User add new Dock Door in facility$")
    public void addDockDoor(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.addDockDoor(row.get("DoorType"), row.get("MaxHeight"), row.get("MaxWidth"));
        }
    }

    @Then("^Verify Dock Door details in facility$")
    public void verifyNewDockDoor(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.verifyNewDockDoor(row.get("DoorType"), row.get("Status"));
        }
    }

    @When("^User add new Zones in facility$")
    public void addZone(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.addZone(row.get("ZoneName"), row.get("ZoneCode"), row.get("ZoneType"), row.get("MaxCapacity"), row.get("Description"));
        }
    }

    @Then("^Verify Zones details in facility$")
    public void verifyZone(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.verifyNewZone(row.get("ZoneCode"), row.get("ZoneType"), row.get("MaxCapacity"), row.get("Status"));
        }
    }

    @When("^User add new Bins in facility$")
    public void addBins(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.addBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"));
        }
    }

    @Then("^Verify Bin details in facility$")
    public void verifyBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            facilitiesPage.verifyNewBin(row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Status"));
        }
    }

    @Then("^Verify total Doors (1), Zones (1) and Bins (1) from tabs$")
    public void verifyTotalCount(String doorsCount, String zoneCount, String binsCount) {
        facilitiesPage.verifyTotalCount(doorsCount, zoneCount, binsCount);
    }

    @When("^User delete the Zone in facility$")
    public void deleteZone() {
        facilitiesPage.deleteZone();
    }

    @Then("^Verify Zone deleted in Facilities$")
    public void verifyDeletedZone() {
        facilitiesPage.verifyDeletedZone();
    }

    @When("^User delete the Bin in facility$")
    public void deleteBin() {
        facilitiesPage.deleteBin();
    }

    @Then("^Verify Bin deleted in Facilities$")
    public void verifyDeletedBin() {
        facilitiesPage.verifyDeletedBin();
    }
}
