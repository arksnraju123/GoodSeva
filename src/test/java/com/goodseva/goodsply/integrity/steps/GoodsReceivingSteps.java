package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.CheckInPage;
import com.goodseva.goodsply.integrity.pages.GoodsReceivingPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class GoodsReceivingSteps {
    GoodsReceivingPage goodsReceivingPage = new GoodsReceivingPage(WebDriverHelper.getDriver());

    @When("^User Add new Goods Receiving$")
    public void addNewGoodsReceiving(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            goodsReceivingPage.createNewGoodsReceiving(row.get("Quantity"), row.get("UnitCost"), row.get("LotNumber"), row.get("PONumber"), row.get("Notes"), row.get("IsSave"));
        }
    }

    @When("^User click on Clear Form button$")
    public void clearForm() {
        goodsReceivingPage.clearForm();
    }

    @Then("^Verify Receiving Details form has default values$")
    public void verifyDefaultValues() {
        goodsReceivingPage.verifyDefaultValues();
    }

    @Then("^User search with (Product|Bin|PO/Reference)$")
    public void search(String searchWith) {
        goodsReceivingPage.search(searchWith);
    }

    @Then("^Verify table data$")
    public void verifyTable(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            goodsReceivingPage.verifyTable(row.get("QtyReceived"), row.get("POReference"), row.get("Notes"));
        }
    }

}
