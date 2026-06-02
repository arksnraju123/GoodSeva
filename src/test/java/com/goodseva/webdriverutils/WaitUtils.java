package com.goodseva.webdriverutils;

import com.goodseva.utils.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils extends WebDriverHelper {
	static WebDriverWait wait;

	public static void waitForElementClickable(WebElement element) {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForExpectedAttributeValue(WebElement element, String attribute, String value) {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}

	public static void waitForPageLoads() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
	}

	public static void waitForPageLoads(WebElement element) {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForDropdownOptions(WebElement dropdownElement) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		// Wait until dropdown has at least one option
		wait.until(d -> {
			try {
				Select select = new Select(dropdownElement);
				List<WebElement> options = select.getOptions();
				// ✅ Ensure dropdown has more than 1 option (often first is "Select..." placeholder)
				return options.size() > 1;
			} catch (StaleElementReferenceException e) {
				// If DOM refreshes, retry
				return false;
			}
		});
	}
}
