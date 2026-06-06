package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.AppointmentsSchedulingPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AppointmentsSchedulingSteps {
    AppointmentsSchedulingPage appointmentsSchedulingPage = new AppointmentsSchedulingPage(WebDriverHelper.getDriver());

    @Then("^Verify (.*) status$")
    public void verifyScheduled(String status) {
        if (status.equalsIgnoreCase("Scheduled")) {
            Assert.assertTrue(appointmentsSchedulingPage.isScheduledStatusDisplayed(), "Scheduled status has not displayed");
        } else if (status.equalsIgnoreCase("Arrived")) {
            Assert.assertTrue(appointmentsSchedulingPage.isArrivedStatusDisplayed(), "Arrived status has not displayed");
        } else if (status.equalsIgnoreCase("Loading")) {
            Assert.assertTrue(appointmentsSchedulingPage.isLoadingStatusDisplayed(), "Loading status has not displayed");
        }else if (status.equalsIgnoreCase("Departed")) {
            Assert.assertTrue(appointmentsSchedulingPage.isLoadingStatusDisplayed(), "Departed status has not displayed");
        } else {
            Assert.assertTrue(false, "Invalid status has provided. Provided status is: " + status);
        }

    }

    @Then("^Verify (.*) button$")
    public void verifyMarkArrived(String buttonName) {
        if (buttonName.equalsIgnoreCase("Mark Arrived")) {
            Assert.assertTrue(appointmentsSchedulingPage.isMarkArrivedButtonDisplayed(), "Mark Arrived button has not displayed");
        } else if (buttonName.equalsIgnoreCase("Start Loading")) {
            Assert.assertTrue(appointmentsSchedulingPage.isStartLoadingButtonDisplayed(), "Start Loading button has not displayed");
        } else if (buttonName.equalsIgnoreCase("Mark Departed")) {
            Assert.assertTrue(appointmentsSchedulingPage.isMarkDepartedButtonDisplayed(), "Mark Departed button has not displayed");
        } else {
            Assert.assertTrue(false, "Invalid button name has provided. Provided button is: " + buttonName);
        }
    }

    @When("^User click on (.*) button in appointments scheduling page$")
    public void clickOnMarkArrived(String buttonName) {
        if (buttonName.equalsIgnoreCase("Mark Arrived")) {
            appointmentsSchedulingPage.clickOnMarkArrived();
        } else if (buttonName.equalsIgnoreCase("Start Loading")) {
            appointmentsSchedulingPage.clickOnStartLoading();
        } else if (buttonName.equalsIgnoreCase("Mark Departed")) {
            appointmentsSchedulingPage.clickOnMarkDeparted();
        } else {
            Assert.assertTrue(false, "Invalid button name has provided. Provided button is: " + buttonName);
        }

    }
}
