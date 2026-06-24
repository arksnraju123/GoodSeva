package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.DateTimeUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AppointmentsPage extends DriverUtils {
    public AppointmentsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='New Appointment']")
    private WebElement newAppointmentButton;

    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement bookAppointmentPageHeading;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Facility')]/following::select[1]")
    private WebElement facilityInput;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Carrier')]/following::select[1]")
    private WebElement carrierInput;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Booked')]/following::select[1]")
    private WebElement bookedByInput;

    @FindBy(how = How.NAME, using = "scheduledDate")
    private WebElement date;

    @FindBy(how = How.NAME, using = "scheduledTimeStart")
    private WebElement startTime;

    @FindBy(how = How.NAME, using = "scheduledEndDate")
    private WebElement endDate;

    @FindBy(how = How.NAME, using = "scheduledTimeEnd")
    private WebElement endTime;

    @FindBy(how = How.XPATH, using = "//label[contains(text(), 'Load Type')]/following::select[1]")
    private WebElement loadTypeDropdown;

    @FindBy(how = How.NAME, using = "estimatedDuration")
    private WebElement estimatedDurationTextbox;

    @FindBy(how = How.XPATH, using = "//button[text()='Book Appointment']")
    private WebElement bookAppointment;

    public void clickOnNewAppointmentButton(){
        click(newAppointmentButton, "New Appointment button");
    }

    public String getBookAppointmentPageHeading(){
        return getText(bookAppointmentPageHeading, "Book Appointment Page Heading");
    }

    public void enterBasicInfo(String facility, String carrier, String bookedBy){
        WaitUtils.waitForDropdownOptions(facilityInput);
        selectDropdownValueByVisibleText(facilityInput, facility, "Facility dropdown");
        selectDropdownValueByVisibleText(carrierInput, carrier, "Carrier dropdown");
        selectDropdownValueByVisibleText(bookedByInput, bookedBy, "Booked By dropdown");
    }

    public void enterScheduleDetails(){
        String startTimeValue = DateTimeUtils.getCurrentTime("hh:mm a");
        String endTimeValue = DateTimeUtils.getFutureTimeInMinutes(1, "hh:mm a");
        globalVariables.put("startTime", DateTimeUtils.convertTime(startTimeValue, "hh:mm a", "h:mm a").toUpperCase());
        globalVariables.put("endTime", DateTimeUtils.convertTime(endTimeValue, "hh:mm a", "h:mm a").toUpperCase());
        enterText(date, DateTimeUtils.getFutureDate(0, "dd-MM-yyyy"), "Date textbox");
        enterText(startTime, startTimeValue, "Start Time textbox");
        pressEnter();
        enterText(endDate, DateTimeUtils.getFutureDate(1, "dd-MM-yyyy"), "End Date textbox");
        enterText(endTime, endTimeValue, "End Time textbox");
        pressLeftArrow();
        pressDownArrow();
        pressEnter();
    }

    public void enterLoadInfo(String loadType, String estimatedDuration){
        selectDropdownValueByVisibleText(loadTypeDropdown, loadType, "Load Type dropdown");
        clearData(estimatedDurationTextbox, "Estimated Duration (minutes) textbox");
        enterText(estimatedDurationTextbox, estimatedDuration, "Estimated Duration (minutes) textbox");
    }

    public void clickOnBookAppointment(){
        click(bookAppointment, "Book Appointment button");
    }
}
