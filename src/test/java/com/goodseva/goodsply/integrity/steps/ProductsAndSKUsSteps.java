package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.ProductsAndSKUsPage;
import com.goodseva.utils.WebDriverHelper;

public class ProductsAndSKUsSteps {
    ProductsAndSKUsPage binsPage = new ProductsAndSKUsPage(WebDriverHelper.getDriver());

    /*@When("^User Add new Bin$")
    public void addBin(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            binsPage.createNewBin(row.get("BinCode"), row.get("BinType"), row.get("Aisle"), row.get("Rack"), row.get("Shelf"), row.get("Lever"), row.get("Status"), row.get("Capacity"), row.get("Pickable"), row.get("Receivable"));
        }
    }*/


}
