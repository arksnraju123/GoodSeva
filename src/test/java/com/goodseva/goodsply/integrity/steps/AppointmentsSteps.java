package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.AppointmentsPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AppointmentsSteps {
    AppointmentsPage appointmentsPage = new AppointmentsPage(WebDriverHelper.getDriver());

    @Given("^User click on New Appointment button$")
    public void clickOnNewAppointmentButton() {
        appointmentsPage.clickOnNewAppointmentButton();
    }

    @Then("^Verify Book Appointment page has opened$")
    public void verifyBookAppointmentPage() {
        Assert.assertEquals(appointmentsPage.getBookAppointmentPageHeading(), "Book Appointment", "Book Appointment page has not opened");
    }

    @When("^User enter basic info$")
    public void enterBasicInfo(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            appointmentsPage.enterBasicInfo(row.get("Facility"), row.get("Carrier"), row.get("BookedBy"));
        }
    }

    @When("^User enter schedule details$")
    public void enterScheduleDetails() throws InterruptedException {
        appointmentsPage.enterScheduleDetails();
    }

    @When("^User enter Load Information$")
    public void enterLoadInfo(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            appointmentsPage.enterLoadInfo(row.get("LoadType"), row.get("EstimatedDuration"));
        }
    }

    @When("^User book appointment$")
    public void bookAppointment() {
        appointmentsPage.clickOnBookAppointment();
    }
}
