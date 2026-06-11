package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.SlotBookingAndBookingManagementPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class SlotBookingAndBookingManagementSteps {
    SlotBookingAndBookingManagementPage slotBookingAndBookingManagementPage = new SlotBookingAndBookingManagementPage(WebDriverHelper.getDriver());

    @When("^User create new Slot Booking$")
    public void createNewSlot(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            slotBookingAndBookingManagementPage.createNewSlot(row.get("VehicleNumber"), row.get("VehicleType"), row.get("DriverName"), row.get("LicenseNumber"), row.get("MobileNumber"), row.get("ExpectedArrivalDate"), row.get("ArrivalTime"), row.get("DepartureTime"), row.get("LoadType"), row.get("GoodsType"));
        }
    }

    @When("^Select calendar date (.*)$")
    public void selectCalendarDate(String date) {
        slotBookingAndBookingManagementPage.selectWeeklyCalendarDate(date);
    }

    @Then("^Verify slot booking details$")
    public void verifySlotBookingDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            slotBookingAndBookingManagementPage.verifySlotBookingDetails(row.get("Status"));
        }
    }

    @When("^Verify all details on Booking Details popup$")
    public void verifyBookingDetailsPopup(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            slotBookingAndBookingManagementPage.verifyBookingDetailsPopup(row.get("Status"));
        }
    }

    @When("^User open newly created slot booking$")
    public void openSlot() {
        slotBookingAndBookingManagementPage.openSlot();
    }

    @When("^User Reject the booking on Booking Details popup$")
    public void rejectBooking() {
        slotBookingAndBookingManagementPage.rejectBooking();
    }

    @When("^Verify all details on Booking Details popup after reject$")
    public void verifyBookingDetailsPopupAfterReject(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            slotBookingAndBookingManagementPage.verifyBookingDetailsPopupAfterReject(row.get("Status"));
        }
    }
}
