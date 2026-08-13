package com.goodseva.goodsply.common.steps;

import com.goodseva.goodsply.common.pages.CommonPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class CommonSteps {
    CommonPage commonPage = new CommonPage(WebDriverHelper.getDriver());

    @Given("^User open (.*) page$")
    public void openFeaturesPage(String page) {
        if (page.equalsIgnoreCase("Appointments")) {
            commonPage.openAppointmentPage();
        } else if (page.equalsIgnoreCase("Zones")) {
            commonPage.openZonesPage();
        } else if (page.equalsIgnoreCase("Integrity Hub")) {
            commonPage.openIntegrityHubPage();
        } else if (page.equalsIgnoreCase("WMS Dashboard")) {
            commonPage.openWMSDashboardPage();
        } else if (page.equalsIgnoreCase("Slot Booking")) {
            commonPage.openSlotBookingPage();
        } else if (page.equalsIgnoreCase("Booking Management")) {
            commonPage.openBookingManagementPage();
        } else if (page.equalsIgnoreCase("Check-In")) {
            commonPage.openCheckInPage();
        } else if (page.equalsIgnoreCase("Velocity Hub")) {
            commonPage.openVelocityHubPage();
        } else if (page.equalsIgnoreCase("Publish Trip")) {
            commonPage.openPublishTripPage();
        } else if (page.equalsIgnoreCase("Bins")) {
            commonPage.openBinsPage();
        } else if (page.equalsIgnoreCase("Products & SKUs")) {
            commonPage.openProductsAndSKUs();
        } else if (page.equalsIgnoreCase("Facilities")) {
            commonPage.openFacilitiesPage();
        } else if (page.equalsIgnoreCase("Purchase Orders")) {
            commonPage.openPurchaseOrdersPage();
        }else if (page.equalsIgnoreCase("Inbound Deliveries")) {
            commonPage.openInboundDeliveriesPage();
        } else {
            Assert.fail("Invalid Page name provided, Provided page name is: " + page);
        }
    }

    @Given("^User login into GoodsPly$")
    public void loginIntoGoodsPly() {
        commonPage.loginGoodsPly();
    }
}
