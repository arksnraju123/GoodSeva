package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.common.pages.CommonPage;
import com.goodseva.goodsply.integrity.pages.*;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class WMSDashboardSteps {
    WMSDashboardPage wmsDashboardPage = new WMSDashboardPage(WebDriverHelper.getDriver());
    FacilitiesPage facilitiesPage = new FacilitiesPage(WebDriverHelper.getDriver());
    BinsPage binsPage = new BinsPage(WebDriverHelper.getDriver());
    ZonesPage zonesPage = new ZonesPage(WebDriverHelper.getDriver());
    ProductsAndSKUsPage productsPage = new ProductsAndSKUsPage(WebDriverHelper.getDriver());
    StockOverviewPage stockOverviewPage = new StockOverviewPage(WebDriverHelper.getDriver());
    CommonPage commonPage = new CommonPage(WebDriverHelper.getDriver());

    @Then("^Verify total Facilities$")
    public void verifyTotalFacility() throws InterruptedException {
        commonPage.openFacilitiesPage();
        String expected = facilitiesPage.getTotalFacilities();
        commonPage.openWMSDashboardPage();
        String actual = wmsDashboardPage.getTotalFacilities();
        Assert.assertEquals(actual, expected, "Total Facility is wrong");
    }

    @Then("^Verify total Zones$")
    public void verifyTotalZones() throws InterruptedException {
        commonPage.openZonesPage();
        String expected = zonesPage.getTotalZones();
        commonPage.openWMSDashboardPage();
        String actual = wmsDashboardPage.getTotalZones();
        Assert.assertEquals(actual, expected, "Total Zones is wrong");
    }

    @Then("^Verify total Bins$")
    public void verifyTotalBins() throws InterruptedException {
        commonPage.openBinsPage();
        String expected = binsPage.getTotalBins();
        commonPage.openWMSDashboardPage();
        String actual = wmsDashboardPage.getTotalBins();
        Assert.assertEquals(actual, expected, "Total Bins is wrong");
    }

    @Then("^Verify total Products$")
    public void verifyTotalProducts() throws InterruptedException {
        commonPage.openProductsAndSKUsPage();
        String expected = productsPage.getTotalProducts();
        commonPage.openWMSDashboardPage();
        String actual = wmsDashboardPage.getTotalProducts();
        Assert.assertEquals(actual, expected, "Total Products is wrong");
    }

    @Then("^Verify total Inventory$")
    public void verifyTotalInventory() throws InterruptedException {
        commonPage.openStockOverviewPage();
        String expected = stockOverviewPage.getTotalQuantity();
        commonPage.openWMSDashboardPage();
        String actual = wmsDashboardPage.getTotalInventory();
        Assert.assertEquals(actual, expected, "Total Inventory is wrong");
    }

    @When("^User click on each link in WMS Overview Quick Actions and validate navigation$")
    public void clickEachLinkAndValidate(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String actualdPage;
        String expectedPage;
        String link;
        for (Map<String, String> row : data) {
            expectedPage = row.get("ExpectedPage");
            link = row.get("Link");
            wmsDashboardPage.clickOnEachLink(wmsDashboardPage.getElement(By.xpath("//h3/following::button[text()='" + link + "']"), link + " link"), link + " link");
            actualdPage = wmsDashboardPage.getPageURL();
            Assert.assertTrue(actualdPage.contains(expectedPage), "Navigated to wrong page when click on " + link + ", Expected page is: " + expectedPage + ", Actual page is: " + actualdPage);
            wmsDashboardPage.navigateBack();
        }
    }
}
