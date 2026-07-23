package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.BinsPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class BinsSteps {
    BinsPage binsPage = new BinsPage(WebDriverHelper.getDriver());

    @When("^User Add new Bin$")
    public void addBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.createNewBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Lever"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }

    @When("^Verify newly created Bin$")
    public void verifyBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.verifyBin(row.get("Location"), row.get("Type"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }
}
