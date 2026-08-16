package com.goodseva.goodsply.integrity.steps;

import com.goodseva.goodsply.integrity.pages.CommonPage;
import com.goodseva.utils.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommonSteps {
    CommonPage commonPage = new CommonPage(WebDriverHelper.getDriver());

    @Then("^Verify Previous button disabled by default in (.*) page")
    public void verifyPrevBtn(String page) {
        commonPage.verifyPrevBtn();
    }

    @When("^User click on Next button in (.*) page")
    public void clickNextBtn(String page) {
        commonPage.clickOnNextBtn();
    }

    @When("^User click on Previous button in (.*) page")
    public void clickPreviousBtn(String page) {
        commonPage.clickOnPrevBtn();
    }

    @Then("^Verify page navigated to page (.*) in (.*) page")
    public void verifyPagination(String pageNum, String page) {
        commonPage.verifyPagination(pageNum);
    }
}
