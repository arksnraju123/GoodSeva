package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.IntegrityHubPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class IntegrityHubSteps {
    IntegrityHubPage integrityHubPage = new IntegrityHubPage(WebDriverHelper.getDriver());

    @When("^User click on each link and validate navigation$")
    public void clickEachLinkAndValidate(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String actualdPage;
        String expectedPage;
        String link;
        for (Map<String, String> row : data) {
            expectedPage = row.get("ExpectedPage");
            link = row.get("Link");
            if (link.equalsIgnoreCase("Stock Overview") || link.equalsIgnoreCase("Inventory Control") || link.equalsIgnoreCase("Safety Stock & Reorder") ||
                    link.equalsIgnoreCase("Adjustments") || link.equalsIgnoreCase("Cycle Counts") || link.equalsIgnoreCase("Stock Movement")) {
                integrityHubPage.clickOnStorageTab();
            }
            if (link.equalsIgnoreCase("Sales Orders") || link.equalsIgnoreCase("Picking Console") || link.equalsIgnoreCase("Packing & Labeling") ||
                    link.equalsIgnoreCase("Dispatch Console") || link.equalsIgnoreCase("Returns") || link.equalsIgnoreCase("Fulfillment Hub") ||
                    link.equalsIgnoreCase("Shipping") || link.equalsIgnoreCase("Proof of Delivery")) {
                integrityHubPage.clickOnOutboundTab();
            }
            integrityHubPage.clickOnEachLink(integrityHubPage.getElement(By.xpath("//h1[text()='Integrity']/following::div[text()='" + link + "']"), link + " link"), link + " link");
            actualdPage = integrityHubPage.getPageURL();
            Assert.assertTrue(actualdPage.contains(expectedPage), "Navigated to wrong page when click on " + link + ", Expected page is: " + expectedPage + ", Actual page is: " + actualdPage);
            integrityHubPage.navigateBack();
        }
    }

    @When("^User click on Storage Tab$")
    public void clickOnStorageTab() {
        integrityHubPage.clickOnStorageTab();
    }

    @When("^User click on Outbound Tab$")
    public void clickOnSOutboundTab() {
        integrityHubPage.clickOnOutboundTab();
    }
}
