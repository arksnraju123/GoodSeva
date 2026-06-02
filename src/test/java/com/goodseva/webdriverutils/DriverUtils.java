package com.goodseva.webdriverutils;

import com.goodseva.utils.WebDriverHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DriverUtils extends WebDriverHelper {
	public static Logger log = LogManager.getLogger();
	public void enterText(WebElement element, String text, String elementName) {
		log.info("Entering "+text+" in "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		element.clear();
		element.sendKeys(text);
	}

	public void enterTextUsingJS(WebElement element, String text, String elementName) {
		log.info("Entering "+text+" in "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value='" + text + "';", element);
	}

	public void click(WebElement element, String elementName) {
		log.info("Clicking on "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		element.click();
	}

	public void jsClick(WebElement element, String elementName) {
		log.info("Clicking on "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		JavascriptExecutor js = (JavascriptExecutor) WebDriverHelper.getDriver();
		js.executeScript("arguments[0].click();", element);
	}
	
	public String getText(WebElement element, String elementName) {
		log.info("Getting text from "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		return element.getText().trim();
	}
	
	public String getTextBoxValue(WebElement element, String elementName) {
		log.info("Getting text from textbox "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		return element.getAttribute("value").trim();
	}
	
	public void highlightElement(WebElement element) {
		if (getDriver() instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].style.border='2px solid red'", element);
	    }
	}
	
	public boolean isElementDisplayed(WebElement element, String elementName) {
		log.info("Finding "+elementName+" is displayed or not");
		try {
			if(element.isDisplayed()) {
				highlightElement(element);
				return true;
			}
		}catch(Exception e) {
		}
		return false;
	}
	
	public void mouseHover(WebElement element, String elementName) {
		log.info("Mouse hover on "+elementName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		new Actions(getDriver()).moveToElement(element).build().perform();
	}
	
	public void selectDropdownValueByVisibleText(WebElement element, String dropdownValue, String dropdownName) {
		log.info("Selecting "+dropdownValue+" from "+dropdownName);
		WaitUtils.waitForElementClickable(element);
		highlightElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(dropdownValue);
	}

	public void pressDownArrow(){
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.chord(Keys.ARROW_DOWN)).build().perform();
	}
	public void pressLeftArrow(){
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.chord(Keys.ARROW_LEFT)).build().perform();
	}

	public void pressEnter(){
		Actions act = new Actions(getDriver());
		act.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
	}

	public void clearData(WebElement element, String fieldName){
		click(element, fieldName);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		element.sendKeys(Keys.DELETE);
	}
}

