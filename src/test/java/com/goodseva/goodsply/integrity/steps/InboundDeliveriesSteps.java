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

    @When("^User Add new Purchase Orders$")
    public void createPurchaseOrder(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
        }
    }

    @Then("^Verify newly created Purchase Orders$")
    public void verifyPurchaseOrder(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
        }
    }


}
