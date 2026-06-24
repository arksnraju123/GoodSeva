package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.CheckInPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CheckInSteps {
    CheckInPage checkInPage = new CheckInPage(WebDriverHelper.getDriver());

    @When("^User create Quick Check-In$")
    public void newQuickCheckIn(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            checkInPage.createNewQuickCheckIn(row.get("VehicleLicense"), row.get("Notes"));
        }
    }

    @Then("^Verify Quick CheckIn$")
    public void verifyQuickCheckIn() {
        checkInPage.verifyQuickCheckIn();
    }

    @When("^User create Walk In Check-In$")
    public void newWalkInCheckIn(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            checkInPage.createNewWalkInCheckIn(row.get("DriverName"), row.get("VehicleLicense"), row.get("CarrierName"), row.get("LoadType"), row.get("Notes"));
        }
    }

    @Then("^Verify Walk-In CheckIn$")
    public void verifyWalkInCheckIn() {
        checkInPage.verifyWalkInCheckIn();
    }
}
