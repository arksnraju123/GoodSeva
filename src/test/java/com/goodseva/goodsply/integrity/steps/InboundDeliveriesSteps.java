package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.InboundDeliveriesPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class InboundDeliveriesSteps {
    InboundDeliveriesPage inboundDeliveriesPage = new InboundDeliveriesPage(WebDriverHelper.getDriver());

    @When("^User click on (.*) tab$")
    public void openPendingPOsTab(String tabName) {
        inboundDeliveriesPage.openPendingPOsTab(tabName);
    }

    @Then("^User verify purchase order details in Inbound Deliveries Pending POs tab$")
    public void verifyPurchaseOrderDetailsInInboundDeliveries(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            inboundDeliveriesPage.verifyPurchaseOrderDetailsInInboundDeliveries(row.get("Items"), row.get("Status"));
        }
    }

    @When("^User click on Receive button$")
    public void clickOnReceiveButton() {
        inboundDeliveriesPage.clickOnReceiveButton();
    }

    @Then("^User verify create GRN Report with default values$")
    public void verifyGRNReportDefaultValues(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            inboundDeliveriesPage.verifyGRNReportDefaultValues(row.get("ReceiptType"));
        }
    }

    @Then("^User create new GRN$")
    public void createGRN(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            inboundDeliveriesPage.createGRN(row.get("VehicleNumber"), row.get("DriverName"), row.get("LRNumber"), row.get("Notes"));
        }
    }

    @Then("^User verify purchase order details in Inbound Deliveries GRNs tab$")
    public void verifyPurchaseOrderDetailsInInboundDeliveriesGRNsTab(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            inboundDeliveriesPage.verifyPurchaseOrderDetailsInInboundDeliveriesGRNsTab(row.get("Items"), row.get("ReceivedQty"), row.get("QCStatus"));
        }
    }

    @When("^User click on Complete button$")
    public void clickOnCompleteButton() {
        inboundDeliveriesPage.clickOnCompleteButton();
    }

    @When("^User get latest GRN number$")
    public void getLatestGRNNumber() {
        inboundDeliveriesPage.getLatestGRNNumber();
    }

    @Then("^User complete GRN$")
    public void completeGRN(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            inboundDeliveriesPage.completeGRN(row.get("Received"), row.get("Accepted"), row.get("Rejected"), row.get("LotNumber"), row.get("ExpiryDate"));
        }
    }

    @When("^User search with PO Number in Inbound Deliveries Pending POs tab$")
    public void searchPONumber() {
        inboundDeliveriesPage.searchPONumber();
    }

    @Then("^Verify Pending POs total count$")
    public void verifyPendingPOs() {
        inboundDeliveriesPage.verifyPendingPOsCount();
    }

    @Then("^Verify In-Progress GRNs total count$")
    public void verifyInProgressGRNCount() {
        inboundDeliveriesPage.verifyInProgressGRNCount();
    }

    @Then("^Verify Completed GRNs total count$")
    public void verifyCompletedGRNCount() {
        inboundDeliveriesPage.verifyCompletedGRNCount();
    }

    @Then("^Verify Total GRNs total count$")
    public void verifyTotalGRNCount() {
        inboundDeliveriesPage.verifyTotalGRNCount();
    }

    @Then("^Verify search PO number filter in Pending POs Tab$")
    public void verifyPONumberSearchInPendingPOs() {
        inboundDeliveriesPage.verifyPONumberSearchInPendingPOs();
    }

    @Then("^Verify Vendors filter in Pending POs Tab$")
    public void verifyVendorsSearchInPendingPOs() {
        inboundDeliveriesPage.verifyVendorsSearchInPendingPOs();
    }

    @When("^User reset POs search in Pending POs Tab$")
    public void resetPOsSearch() {
        inboundDeliveriesPage.clearPOsSearch();
    }

    @Then("^Verify search GRN number filter in GRNs tab$")
    public void verifyGRNSearchInGRNs() {
        inboundDeliveriesPage.verifyGRNSearchInGRNs();
    }

    @When("^User reset GRN search in GRNs tab$")
    public void resetGRNSearch() {
        inboundDeliveriesPage.clearGRNSearch();
    }

    @Then("^Verify Vendors filter in GRN Tab$")
    public void verifyVendorsSearchInGRNs() {
        inboundDeliveriesPage.verifyVendorsSearchInGRNs();
    }
}
