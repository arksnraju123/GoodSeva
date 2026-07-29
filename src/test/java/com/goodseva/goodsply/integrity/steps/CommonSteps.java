package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.CommonPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {
    CommonPage commonPage = new CommonPage(WebDriverHelper.getDriver());

    @Then("^Verify Previous button disabled by default in Bins page")
    public void verifyPrevBtn() {
        commonPage.verifyPrevBtn();
    }

    @When("^User click on Next button in Bins page")
    public void clickNextBtn() {
        commonPage.clickOnNextBtn();
    }

    @When("^User click on Previous button in Bins page")
    public void clickPreviousBtn() {
        commonPage.clickOnPrevBtn();
    }

    @Then("^Verify page navigated to page (.*) in Bins page")
    public void verifyPagination(String pageNum) {
        commonPage.verifyPagination(pageNum);
    }
}
