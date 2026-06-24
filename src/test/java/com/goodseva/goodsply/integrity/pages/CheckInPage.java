package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.DateTimeUtils;
import com.goodseva.utils.StringUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckInPage extends DriverUtils {
    public CheckInPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-walk-in-checkin']/preceding-sibling::button[1]")
    private WebElement quickCheckInButton;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-walk-in-checkin']")
    private WebElement walkInCheckInButton;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='tab-current-checkins']")
    private WebElement currentCheckInTab;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='tab-checkin-history']")
    private WebElement checkInHistoryTab;

    @FindBy(how = How.XPATH, using = "//button[@role='combobox']")
    private WebElement appointmentDDown;

    @FindBy(how = How.XPATH, using = "(//form//select)[1]")
    private WebElement appointDropdown;

    @FindBy(how = How.NAME, using = "driverName")
    private WebElement driverName;

    @FindBy(how = How.NAME, using = "vehicleLicense")
    private WebElement vehicleLicense;

    @FindBy(how = How.NAME, using = "notes")
    private WebElement notes;

    @FindBy(how = How.XPATH, using = "//form//button[text()='Check In']")
    private WebElement checkInButtonOnPopup;

    @FindBy(how = How.NAME, using = "carrierName")
    private WebElement carrierName;

    @FindBy(how = How.XPATH, using = "(//form//select)[1]")
    private WebElement loadTypeDropdown;

    @FindBy(how = How.XPATH, using = "(//div[contains(@data-testid, 'card-checkin-')]//div[@class='text-muted-foreground'])[1]")
    private WebElement checkInAppointmentType;

    @FindBy(how = How.XPATH, using = "(//div[contains(@data-testid, 'card-checkin-')]//div[@class='text-muted-foreground'])[2]")
    private WebElement checkInNotes;

    @FindBy(how = How.XPATH, using = "(//div[contains(@data-testid, 'card-checkin-')]//h3[contains(@data-testid, 'text-driver-name')])[1]")
    private WebElement checkInDriverName;

    @FindBy(how = How.XPATH, using = "(//div[contains(@data-testid, 'card-checkin-')]//p[@class='text-sm text-muted-foreground'])[1]")
    private WebElement checkInVehicleLicense;

    @FindBy(how = How.XPATH, using = "(//div[contains(@data-testid, 'card-checkin-')]//div[@class='flex items-center text-muted-foreground'])[1]")
    private WebElement checkInDate;

    @FindBy(how = How.XPATH, using = "(//div[contains(@data-testid, 'card-checkin-')]//following::div[2])[1]")
    private WebElement checkInStatus;

    public void createNewQuickCheckIn(String license, String notesValue) throws InterruptedException {
        click(quickCheckInButton, "Quick Checkin button");
        WaitUtils.waitForVisibilityOfElement(appointmentDDown);
        click(appointmentDDown, "Appointment dropdown");
        Thread.sleep(2000);
        globalVariables.put("Appointment", getDropdownValueByIndex(appointDropdown, "3"));
        pressDownArrow();
        pressDownArrow();
        pressEnter();
        enterText(vehicleLicense, license + "_" + StringUtils.getRandomNumber(), "Vehicle License");
        enterText(notes, notesValue + "_" + StringUtils.getRandomNumber(), "Notes");
        globalVariables.put("DriverName", getTextBoxValue(driverName, "Driver Name"));
        globalVariables.put("VehicleLicense", getTextBoxValue(vehicleLicense, "Vehicle License"));
        globalVariables.put("Notes", getTextBoxValue(notes, "Notes"));
        click(checkInButtonOnPopup, "Checkin button");
        WaitUtils.waitForVisibilityOfElement(checkInButtonOnPopup);
        Thread.sleep(2000);
    }

    public void verifyQuickCheckIn() {
        String checkInAppointmentTypeValue = getText(checkInAppointmentType, "Appointment Type");
        Assert.assertTrue(checkInAppointmentTypeValue.contains(globalVariables.get("Appointment").split("—")[1].split("\\|")[0]), "Appointment Type is wrong, Actual: " + checkInAppointmentTypeValue + ", Expected: " + globalVariables.get("Appointment"));
        String checkInNotesValue = getText(checkInNotes, "Notes");
        Assert.assertTrue(checkInNotesValue.contains(globalVariables.get("Notes")), "Notes is wrong, Actual: " + checkInNotesValue + ", Expected: " + globalVariables.get("Notes"));
        String checkInDriverNameValue = getText(checkInDriverName, "Driver");
        Assert.assertTrue(checkInDriverNameValue.contains(globalVariables.get("DriverName")), "Driver name is wrong, Actual: " + checkInDriverNameValue + ", Expected: " + globalVariables.get("DriverName"));
        String checkInVehicleLicenseValue = getText(checkInVehicleLicense, "Vehicle License");
        Assert.assertTrue(checkInVehicleLicenseValue.contains(globalVariables.get("VehicleLicense")), "Vehicle License name is wrong, Actual: " + checkInVehicleLicenseValue + ", Expected: " + globalVariables.get("VehicleLicense"));
        String checkInDateValue = getText(checkInDate, "CheckIn Date");
        Assert.assertTrue(checkInDateValue.contains(DateTimeUtils.getFutureDate(0, "dd MMM yyyy")), "CheckIn Date name is wrong, Actual: " + checkInDateValue + ", Expected: " + DateTimeUtils.getFutureDate(0, "dd/MM/yyyy"));
        Assert.assertEquals(getText(checkInStatus, "Status"), "CHECKED IN", "Status name is wrong");
    }

    public void createNewWalkInCheckIn(String dName, String license, String carrier, String loadType, String notesValue) throws InterruptedException {
        click(walkInCheckInButton, "Walk-In Checkin button");
        String driverNameValue = dName + StringUtils.getRandomNumber();
        String licenseValue = license + StringUtils.getRandomNumber();
        String carrierValue = carrier + StringUtils.getRandomNumber();
        String nValue = notesValue + StringUtils.getRandomNumber();
        globalVariables.put("DriverName", driverNameValue);
        globalVariables.put("VehicleLicense", licenseValue);
        globalVariables.put("Notes", nValue);
        enterText(driverName, driverNameValue, "Driver Name");
        enterText(vehicleLicense, licenseValue, "Vehicle License");
        enterText(carrierName, carrierValue, "Carrier Name");
        selectDropdownValueByVisibleText(loadTypeDropdown, loadType, "Load Type");
        enterText(notes, nValue, "Notes");
        click(checkInButtonOnPopup, "Checkin button");
        WaitUtils.waitForVisibilityOfElement(checkInButtonOnPopup);
        Thread.sleep(2000);
    }

    public void verifyWalkInCheckIn() {
        String checkInAppointmentTypeValue = getText(checkInAppointmentType, "Appointment Type");
        Assert.assertTrue(checkInAppointmentTypeValue.contains("Walk-In"), "Appointment Type is wrong, Actual: " + checkInAppointmentTypeValue + ", Expected: Walk-In");
        String checkInNotesValue = getText(checkInNotes, "Notes");
        Assert.assertTrue(checkInNotesValue.contains(globalVariables.get("Notes")), "Notes is wrong, Actual: " + checkInNotesValue + ", Expected: " + globalVariables.get("Notes"));
        String checkInDriverNameValue = getText(checkInDriverName, "Driver");
        Assert.assertTrue(checkInDriverNameValue.contains(globalVariables.get("DriverName")), "Driver name is wrong, Actual: " + checkInDriverNameValue + ", Expected: " + globalVariables.get("DriverName"));
        String checkInVehicleLicenseValue = getText(checkInVehicleLicense, "Vehicle License");
        Assert.assertTrue(checkInVehicleLicenseValue.contains(globalVariables.get("VehicleLicense")), "Vehicle License name is wrong, Actual: " + checkInVehicleLicenseValue + ", Expected: " + globalVariables.get("VehicleLicense"));
        String checkInDateValue = getText(checkInDate, "CheckIn Date");
        Assert.assertTrue(checkInDateValue.contains(DateTimeUtils.getFutureDate(0, "dd MMM yyyy")), "CheckIn Date name is wrong, Actual: " + checkInDateValue + ", Expected: " + DateTimeUtils.getFutureDate(0, "dd/MM/yyyy"));
        Assert.assertEquals(getText(checkInStatus, "Status"), "CHECKED IN", "Status name is wrong");
    }
}
