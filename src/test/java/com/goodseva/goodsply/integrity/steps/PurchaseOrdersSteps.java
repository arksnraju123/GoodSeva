package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.AppointmentsPage;
import com.goodseva.goodsply.integrity.pages.PurchaseOrdersPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class PurchaseOrdersSteps {
    PurchaseOrdersPage purchaseOrdersPage = new PurchaseOrdersPage(WebDriverHelper.getDriver());

    @When("^User Add new Purchase Orders$")
    public void createPurchaseOrder(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            purchaseOrdersPage.createPurchaseOrder(row.get("Vendor"), row.get("ExpectedDeliveryDate"), row.get("PaymentTerms"), row.get("Description"), row.get("Quantity"), row.get("UnitOfMeasure"), row.get("UnitPrice"), row.get("Notes"));
        }
    }

    @Then("^Verify newly created Purchase Orders$")
    public void verifyPurchaseOrder(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            purchaseOrdersPage.verifyPurchaseOrder(row.get("Vendor"), row.get("Date"), row.get("Amount"), row.get("Status"));
        }
    }

    @Then("^Verify newly created Purchase Orders Details on view popup$")
    public void verifyPurchaseOrderDetailsOnPopup(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            purchaseOrdersPage.verifyPurchaseOrderDetailsOnPopup(row.get("Vendor"), row.get("Status"), row.get("PODate"), row.get("DeliveryDate"), row.get("PaymentTerms"), row.get("TotalAmount"), row.get("Notes"), row.get("Description"), row.get("Quantity"), row.get("UnitOfMeasure"), row.get("UnitPrice"), row.get("Tax"));
        }
    }

    @When("^User click on (Approve|Issue) action$")
    public void clickOnAction(String action) {
        purchaseOrdersPage.clickOnAction(action);
    }

    @Then("^Verify status is (approved|issued)$")
    public void verifyStatusInTable(String status) {
        purchaseOrdersPage.verifyStatusInTable(status);
    }

    @Then("^Verify (approved|issued) status on view popup$")
    public void verifyStatusOnPopup(String status) {
        purchaseOrdersPage.verifyStatusOnPopup(status);
    }

    @When("^User Add bellow Line Items on Create Purchase Orders Popup$")
    public void addLineItems(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            purchaseOrdersPage.addLineItems(row.get("Description"), row.get("Quantity"), row.get("UnitOfMeasure"), row.get("UnitPrice"));
        }
    }

    @Given("^User click on Create PO button$")
    public void createPO() {
        purchaseOrdersPage.createPO();
    }

    @When("^User close Create PO popup$")
    public void closeCreatePOPopup() {
        purchaseOrdersPage.closeCreatePOPopup();
    }

    @Then("^Verify added Line Items on Create Purchase Orders Popup$")
    public void verifyLineItems(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row;
        for (int i = 0; i < data.size(); i++) {
            row = data.get(i);
            purchaseOrdersPage.verifyLineItem(i, row.get("Description"), row.get("Quantity"), row.get("UnitOfMeasure"), row.get("Price"), row.get("Total"));
        }
    }

    @Then("^Verify SUbTotal, Tax_GST and Total$")
    public void verifyTotals(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            purchaseOrdersPage.verifyTotals(row.get("SubTotal"), row.get("Tax"), row.get("Total"));
        }
    }

    @When("^User delete row (.*) in Line Items$")
    public void deleteLineItem(String row) {
        purchaseOrdersPage.deleteLineItem(row);
    }

    @When("^User search for PO number$")
    public void searchForPO() {
        purchaseOrdersPage.searchForPO();
    }

    @Then("^Verify search results with searched PO number in Purchase Orders page$")
    public void verifyPoSearchResults() {
        purchaseOrdersPage.verifyPOSearchResults();
    }

    @When("^User reset PO number search in Purchase Orders page$")
    public void resetPOSearchTextbox() {
        purchaseOrdersPage.resetPOSearchTextbox();
    }

    @When("^User search for (HPCL) Vendors$")
    public void resetPOSearchTextbox(String vendor) {
        purchaseOrdersPage.searchForVendor(vendor);
    }

    @Then("^Verify search results with (HPCL) Vendors in Purchase Orders page$")
    public void verifyVendorSearch(String vendor) {
        purchaseOrdersPage.verifyVendorSearch(vendor);
    }

    @Then("^Verify total Purchase Orders$")
    public void verifyTotalPurchaseOrders() {
        purchaseOrdersPage.verifyTotalPurchaseOrders();
    }
}
