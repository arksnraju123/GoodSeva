package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductsAndSKUsPage extends DriverUtils {
    public ProductsAndSKUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Previous']/preceding::div[1]")
    private WebElement totalProducts;

    public String getTotalProducts() throws InterruptedException {
        Thread.sleep(2000);
        return getText(totalProducts, "Total Products").split("\\(")[1].replaceAll("\\D+", "");
    }
}
