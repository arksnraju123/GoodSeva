package com.goodseva.goodsply.velocity.steps;

import com.goodseva.goodsply.velocity.pages.VelocityHubPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class VelocityHubSteps {
    VelocityHubPage velocityHubPage = new VelocityHubPage(WebDriverHelper.getDriver());

    @When("^User click on each link and validate navigation in Velocity Hub$")
    public void clickEachLinkAndValidate(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String actualdPage;
        String expectedPage;
        String link;
        for (Map<String, String> row : data) {
            expectedPage = row.get("ExpectedPage");
            link = row.get("Link");
            velocityHubPage.clickOnEachLink(velocityHubPage.getElement(By.xpath("//h1[text()='Velocity']/following::div[text()='" + link + "']  |  //h1[text()='Velocity']/following::span[text()='" + link + "']"), link + " link"), link + " link");
            Thread.sleep(500);
            actualdPage = velocityHubPage.getPageURL();
            Assert.assertTrue(actualdPage.contains(expectedPage), "Navigated to wrong page when click on " + link + ", Expected page is: " + expectedPage + ", Actual page is: " + actualdPage);
            velocityHubPage.navigateBack();
        }
    }
}
