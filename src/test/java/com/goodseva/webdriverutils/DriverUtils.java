package com.goodseva.webdriverutils;

import com.goodseva.utils.WebDriverHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.goodseva.webdriverutils.WaitUtils.wait;

public class DriverUtils extends WebDriverHelper {
    public static Logger log = LogManager.getLogger();

    public void enterText(WebElement element, String text, String elementName) {
        log.info("Entering " + text + " in " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        clearData(element, elementName);
        element.sendKeys(text);
    }

    public void enterTextUsingJS(WebElement element, String text, String elementName) {
        log.info("Entering " + text + " in " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].value='" + text + "';", element);
    }

    public void click(WebElement element, String elementName) {
        log.info("Clicking on " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        element.click();
    }

    public void click(By element, String elementName) {
        log.info("Clicking on " + elementName);
        WaitUtils.waitForElementClickable(getDriver().findElement(element));
        highlightElement(getDriver().findElement(element));
        getDriver().findElement(element).click();
    }

    public void clickUntil(WebElement element1, By element2, String elementName) {
        log.info("Clicking on " + elementName);
        WaitUtils.waitForElementClickable(element1);
        highlightElement(element1);
        element1.click();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(500));
        try {
            wait.until(driver1 -> {
                try {
                    WebElement el = driver1.findElement(element2); // replace with your locator
                    return el.isDisplayed();
                } catch (NoSuchElementException | StaleElementReferenceException e) {
                    element1.click();
                    return false;
                }
            });
        } catch (Exception ignored) {
        }
    }

    public void jsClick(WebElement element, String elementName) {
        log.info("Clicking on " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverHelper.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void mouseClick(WebElement element, String elementName) {
        log.info("Clicking on " + elementName);
        WaitUtils.waitForElementClickable(element);
        new Actions(getDriver()).click(element).build().perform();
    }

    public String getText(WebElement element, String elementName) {
        log.info("Getting text from " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        String text = element.getText().trim();
        log.info("GetText is: " + text);
        return text;
    }

    public WebElement getElement(By element, String elementName) {
        log.info("Get element " + elementName);
        WaitUtils.waitForElementClickable(getDriver().findElement(element));
        highlightElement(getDriver().findElement(element));
        return getDriver().findElement(element);
    }

    public String getTextBoxValue(WebElement element, String elementName) {
        log.info("Getting text from textbox " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        return element.getAttribute("value").trim();
    }

    public void highlightElement(WebElement element) {
        if (getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='2px solid red'", element);
        }
    }

    public boolean isElementDisplayed(WebElement element, String elementName) {
        log.info("Finding " + elementName + " is displayed or not");
        try {
            //WaitUtils.waitForElementClickable(element);
            if (element.isDisplayed()) {
                highlightElement(element);
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public void mouseHover(WebElement element, String elementName) {
        log.info("Mouse hover on " + elementName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        new Actions(getDriver()).moveToElement(element).build().perform();
    }

    public void selectDropdownValueByVisibleText(WebElement element, String dropdownValue, String dropdownName) {
        log.info("Selecting " + dropdownValue + " from " + dropdownName);
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(dropdownValue);
    }

    public void selectDropdownValueByIndex(WebElement element, String index, String dropdownName) {
        WaitUtils.waitForElementClickable(element);
        highlightElement(element);
        Select select = new Select(element);
        log.info("Selecting " + select.getOptions().get(Integer.parseInt(index)).getText() + " from " + dropdownName);
        select.selectByIndex(Integer.parseInt(index));
    }

    public String getDropdownValueByIndex(WebElement element, String index) {
        return new Select(element).getOptions().get(Integer.parseInt(index)).getText();
    }

    public void pressDownArrow() {
        Actions act = new Actions(getDriver());
        act.sendKeys(Keys.chord(Keys.ARROW_DOWN)).build().perform();
    }

    public void pressLeftArrow() {
        Actions act = new Actions(getDriver());
        act.sendKeys(Keys.chord(Keys.ARROW_LEFT)).build().perform();
    }

    public void pressEnter() {
        Actions act = new Actions(getDriver());
        act.sendKeys(Keys.chord(Keys.ENTER)).build().perform();
    }

    public void pressEscape() {
        Actions act = new Actions(getDriver());
        act.sendKeys(Keys.chord(Keys.ESCAPE)).build().perform();
    }

    public void clearData(WebElement element, String fieldName) {
        click(element, fieldName);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public static String getAttribute(WebElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public String getPageURL() {
        return getDriver().getCurrentUrl();
    }

    public void selectDropdownValue(WebElement dropdownName, List<WebElement> dropdownOptions, String dropdownOptionToSelect, String message) {
        boolean temp = false;
        click(dropdownName, message);
        WaitUtils.sleepFor(2000);
        for (int i = 0; i < dropdownOptions.size(); i++) {
            if (dropdownOptions.get(i).getText().trim().equalsIgnoreCase(dropdownOptionToSelect)) {
                pressEnter();
                temp = true;
                break;
            }
            pressDownArrow();
        }
        if (!temp) {
            Assert.fail("Given dropdown value '" + dropdownOptionToSelect + "' not exist in '" + message + "' dropdown");
        }
    }

    public void selectDropdownValues(WebElement dropdownName, List<WebElement> dropdownOptions, String dropdownOptionToSelect, String message) {
        click(dropdownName, message);
        WaitUtils.sleepFor(2000);
        for (int i = 0; i < dropdownOptions.size(); i++) {
            if (dropdownOptions.get(i).getText().trim().equalsIgnoreCase(dropdownOptionToSelect)) {
                click(dropdownOptions.get(i), "Dropdown value");
                break;
            }
        }
    }

    public List<String> getAllElementsValues(List<WebElement> allElements) {
        highlightElement(allElements.get(0));
        return allElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void acceptAlert() {
        log.info("Accepting alert");
        WaitUtils.waitForAlert();
        getDriver().switchTo().alert().accept();
        WaitUtils.sleepFor(2000);
    }

    public void dismissAlert() {
        log.info("Dismiss alert");
        WaitUtils.waitForAlert();
        getDriver().switchTo().alert().dismiss();
        WaitUtils.sleepFor(2000);
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }
}

