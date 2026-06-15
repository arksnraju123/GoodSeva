package com.goodseva.goodsply.integrity.pages;

import com.goodseva.utils.DateTimeUtils;
import com.goodseva.utils.StringUtils;
import com.goodseva.webdriverutils.DriverUtils;
import com.goodseva.webdriverutils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;

public class SlotBookingAndBookingManagementPage extends DriverUtils {

    public SlotBookingAndBookingManagementPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.ID, using = "vehicleNumber")
    private WebElement vehicleNumber;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-vehicle-type']/following::select[1]")
    private WebElement vehicleType;

    @FindBy(how = How.ID, using = "driverName")
    private WebElement driverName;

    @FindBy(how = How.ID, using = "driverLicense")
    private WebElement licenseNumber;

    @FindBy(how = How.ID, using = "driverMobile")
    private WebElement mobileNumber;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-select-date']")
    private WebElement expectedArrivalDate;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-arrival-time']/following::select[1]")
    private WebElement arrivalTime;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-departure-time']/following::select[1]")
    private WebElement departureTime;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-load-type']/following::select[1]")
    private WebElement loadType;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='select-goods-type']/following::select[1]")
    private WebElement goodsType;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-submit-booking']")
    private WebElement submitBooking;

    @FindBy(how = How.XPATH, using = "//ol[@data-component-name='ToastViewport']")
    private WebElement bookingSubmitted;

    @FindBy(how = How.XPATH, using = "//button[contains(@class, 'aria-selected:opacity-100') and not(contains(@class, 'foreground opacity-50'))]")
    private List<WebElement> calendarDates;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-next-week']")
    private WebElement nextButton;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//h2")
    private WebElement popUpHeaderVehNum;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[@data-component-name='Badge']")
    private WebElement popUpStatus;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-approve-booking']")
    private WebElement popUpApproveBtn;

    @FindBy(how = How.XPATH, using = "//button[@data-testid='button-reject-booking']")
    private WebElement popUpRejectBtn;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='textarea-rejection-reason']")
    private WebElement popUpRejectTxtBox;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='textarea-rejection-reason']/following::button[1]")
    private WebElement confirmRejectionBtn;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='textarea-approval-comments']")
    private WebElement popUpApproveTxtBox;

    @FindBy(how = How.XPATH, using = "//textarea[@data-testid='textarea-approval-comments']/following::button[1]")
    private WebElement confirmApproveBtn;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//div[@data-state='active']//p[1]")
    private WebElement popUpVehicleNum;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[2]")
    private WebElement popUpVehType;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//button[text()='Driver']")
    private WebElement driverTab;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//button[text()='Schedule']")
    private WebElement scheduleTab;

    @FindBy(how = How.XPATH, using = "//div[@role='dialog']//button[text()='Load']")
    private WebElement loadTab;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[1]")
    private WebElement popUpDriverName;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[2]")
    private WebElement popUpLicenseNumber;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[3]")
    private WebElement popUpMobileNumber;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[1]")
    private WebElement popUpExpectedArrival;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[2]")
    private WebElement popUpExpectedDeparture;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[3]")
    private WebElement popUpRequestedAt;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[1]")
    private WebElement popUpLoadType;

    @FindBy(how = How.XPATH, using = "(//div[@role='dialog']//div[@data-state='active']//p)[2]")
    private WebElement popUpGoodsType;

    @FindBy(how = How.XPATH, using = "//button[@data-component-name='DialogPrimitive.Close']")
    private WebElement closePopup;

    @FindBy(how = How.XPATH, using = "(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[1]//p[2]")
    private WebElement totalPending;

    @FindBy(how = How.XPATH, using = "(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[2]//p[2]")
    private WebElement totalApproved;

    @FindBy(how = How.XPATH, using = "(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[3]//p[2]")
    private WebElement totalRejected;

    @FindBy(how = How.XPATH, using = "(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[4]//p[2]")
    private WebElement totalActions;

    public void createNewSlot(String vehicleNum, String vehicleTypeValue, String driverNameValue, String licenseNumberValue, String mobileNum, String expectedArrivalDt, String arrivalTimeValue, String departureTimeValue, String loadTypeValue, String goodsTypeValue) throws InterruptedException {
        vehicleNum = vehicleNum.concat(StringUtils.getRandomNumber(1000, 9999));
        driverNameValue = driverNameValue.concat(StringUtils.getRandomNumber());
        globalVariables.put("VehicleNumber", vehicleNum);
        globalVariables.put("DriverName", driverNameValue);
        globalVariables.put("VehicleType", vehicleTypeValue);
        globalVariables.put("LicenseNumber", licenseNumberValue);
        globalVariables.put("MobileNumber", mobileNum);
        enterText(vehicleNumber, vehicleNum, "Vehicle Number");
        selectDropdownValueByVisibleText(vehicleType, vehicleTypeValue, "Vehicle Type");
        enterText(driverName, driverNameValue, "Driver name");
        enterText(licenseNumber, licenseNumberValue, "License Number");
        enterText(mobileNumber, mobileNum, "Mobile Number");
        click(expectedArrivalDate, "Expected Arrival Time");
        if (expectedArrivalDt.contains("Today+")) {
            int date = Integer.parseInt(expectedArrivalDt.split("\\+")[1]) + Integer.parseInt(DateTimeUtils.getFutureDate(0, "dd"));
            for (int i = 0; i < calendarDates.size(); i++) {
                if (calendarDates.get(i).getText().equalsIgnoreCase(String.valueOf(date))) {
                    click(calendarDates.get(i), "calendar date");
                    break;
                }
            }
        }
        globalVariables.put("Arrival", DateTimeUtils.getFutureDate(Integer.parseInt(expectedArrivalDt.split("\\+")[1]), "MMM d, yyyy") + ", " + arrivalTimeValue);
        globalVariables.put("Departure", DateTimeUtils.getFutureDate(Integer.parseInt(expectedArrivalDt.split("\\+")[1]), "MMM d, yyyy") + ", " + departureTimeValue);
        globalVariables.put("Requested", DateTimeUtils.getFutureDate(0, "MMM d, yyyy"));
        globalVariables.put("LoadType", loadTypeValue);
        globalVariables.put("GoodsType", goodsTypeValue);
        selectDropdownValueByVisibleText(arrivalTime, arrivalTimeValue, "Arrival Time");
        selectDropdownValueByVisibleText(departureTime, departureTimeValue, "Departure Time");
        selectDropdownValueByVisibleText(loadType, loadTypeValue, "Load Type");
        selectDropdownValueByVisibleText(goodsType, goodsTypeValue, "Goods Type");
        click(submitBooking, "Submit Spot Booking button");
        WaitUtils.waitForElement(By.xpath("//button[@data-testid='button-submit-booking']"));
        //Thread.sleep(5000);
    }

    public void selectWeeklyCalendarDate(String date) {
        date = DateTimeUtils.getFutureDate(Integer.parseInt(date.split("\\+")[1]), "yyyy-MM-dd");
        WebElement dateElement = getElement(By.xpath("//div[@data-testid='calendar-day-" + date + "']"), "Calendar date");
        if (!isElementDisplayed(dateElement, "Weekly Calendar")) {
            click(nextButton, "Next button");
        }
        click(dateElement, "Weekly Calendar");
    }

    public void verifySlotBookingDetails(String status) {
        String vehicleNum = globalVariables.get("VehicleNumber");
        WaitUtils.waitForElement(By.xpath("//span[text()='" + vehicleNum + "']/following::div[1]"));
        String actualStatus = getText(getElement(By.xpath("//span[text()='" + vehicleNum + "']/following::div[1]"), "Vehicle number"), "Driver Name");
        Assert.assertEquals(actualStatus, status, "Status is wrong");
        String driverName = getText(getElement(By.xpath("//span[text()='" + vehicleNum + "']/following::div[2]/div[1]"), "Driver Namer"), "Driver Name");
        Assert.assertTrue(driverName.contains(globalVariables.get("DriverName")), "Driver name is wrong. Actual: " + driverName + ", Expected: " + globalVariables.get("DriverName"));
        String arrivalDeparture = getText(getElement(By.xpath("//span[text()='" + vehicleNum + "']/following::div[2]/div[2]"), "Arrival Departure"), "Arrival Departure");
        Assert.assertTrue(globalVariables.get("Arrival").contains(arrivalDeparture.split("-")[0].trim()) && globalVariables.get("Departure").contains(arrivalDeparture.split("-")[1].trim()), "Arrival Departure is wrong. Actual Arrival: " + arrivalDeparture + ", Expected Arrival: " + globalVariables.get("Arrival") + ", Expected Departure: " + globalVariables.get("Departure"));
        String loadGoodsType = getText(getElement(By.xpath("//span[text()='" + vehicleNum + "']/following::div[2]/div[3]"), "Load Goods Type"), "Load Goods Type");
        Assert.assertTrue(loadGoodsType.contains(globalVariables.get("LoadType").toLowerCase()) && loadGoodsType.contains(globalVariables.get("GoodsType").toLowerCase()), "Load Goods Type is wrong. Actual: " + arrivalDeparture + ", Expected Load Type: " + globalVariables.get("LoadType") + ", Expected Goods Type: " + globalVariables.get("GoodsType"));
    }

    public void openSlot() {
        clickUntil(getElement(By.xpath("//span[text()='" + globalVariables.get("VehicleNumber") + "']"), "Vehicle number"), By.xpath("//div[@role='dialog']//h2"), "Vehicle Slot");
    }

    public void verifyBookingDetailsPopup(String status) throws InterruptedException {
        WaitUtils.waitForElement(By.xpath("//div[@role='dialog']//div[@data-component-name='Badge']"));
        String popUpHeaderVehNumber = getText(popUpHeaderVehNum, "Popup Heading Vehicle Number");
        Assert.assertTrue(popUpHeaderVehNumber.contains(globalVariables.get("VehicleNumber")), "Vehicle Number is wrong on popup. Expected: " + globalVariables.get("VehicleNumber") + ", Actual: " + popUpHeaderVehNumber);
        String popUpStat = getText(popUpStatus, "Popup Status");
        Assert.assertEquals(popUpStat, status, "Status is wrong on popup");
        Assert.assertTrue(isElementDisplayed(popUpApproveBtn, "Approved button on popup"), "Approved button is not displayed on popup");
        Assert.assertTrue(isElementDisplayed(popUpRejectBtn, "Rejected button on popup"), "Rejected button is not displayed on popup");
        String popUpVehNumber = getText(popUpVehicleNum, "Popup Vehicle Number");
        Assert.assertEquals(popUpVehNumber, globalVariables.get("VehicleNumber"), "Vehicle Number is wrong on popup");
        String popUpVehicleType = getText(popUpVehType, "Popup Vehicle Type");
        Assert.assertEquals(popUpVehicleType.toLowerCase(), globalVariables.get("VehicleType").toLowerCase(), "Vehicle Type is wrong on popup");
        click(driverTab, "Driver tab");
        Thread.sleep(1000);
        String driverNm = getText(popUpDriverName, "Popup driver name");
        Assert.assertEquals(driverNm, globalVariables.get("DriverName"), "Driver name is wrong on popup");
        String popUpLicNum = getText(popUpLicenseNumber, "Popup License Number");
        Assert.assertEquals(popUpLicNum, globalVariables.get("LicenseNumber"), "License Number is wrong on popup");
        String popupMobileNum = getText(popUpMobileNumber, "Popup Mobile Number");
        Assert.assertEquals(popupMobileNum, globalVariables.get("MobileNumber"), "Mobile Number is wrong on popup");
        click(scheduleTab, "Schedule tab");
        Thread.sleep(1000);
        String popupExpArr = getText(popUpExpectedArrival, "Popup Expected Arrival");
        Assert.assertTrue(popupExpArr.contains(globalVariables.get("Arrival")), "Expected Arrival is wrong on popup. Actual: " + popupExpArr + ", Expected: " + globalVariables.get("Arrival"));
        String popupExpDep = getText(popUpExpectedDeparture, "Popup Expected Departure");
        Assert.assertTrue(popupExpDep.contains(globalVariables.get("Departure")), "Expected Departure is wrong on popup. Actual: " + popupExpArr + ", Expected: " + globalVariables.get("Departure"));
        String popupRequested = getText(popUpRequestedAt, "Popup Requested At");
        Assert.assertTrue(popupRequested.contains(globalVariables.get("Requested")), "Requested is wrong on popup. Actual: " + popupExpArr + ", Expected: " + globalVariables.get("Requested"));
        click(loadTab, "Load tab");
        Thread.sleep(1000);
        String popUpLoadTp = getText(popUpLoadType, "Popup Load Type");
        Assert.assertEquals(popUpLoadTp.toLowerCase(), globalVariables.get("LoadType").toLowerCase(), "Load Type is wrong on popup");
        String popUpGoodsTp = getText(popUpGoodsType, "Popup Goods Type");
        Assert.assertEquals(popUpGoodsTp.toLowerCase(), globalVariables.get("GoodsType").toLowerCase(), "Goods Type is wrong on popup");
    }

    public void approveRejectBooking(String action) throws InterruptedException {
        if (action.equalsIgnoreCase("Reject")) {
            click(popUpRejectBtn, "Reject booking button");
            enterText(popUpRejectTxtBox, StringUtils.getRandomString(10), "Popup rejection message");
            click(confirmRejectionBtn, "Confirm Reject booking button");
        } else {
            click(popUpApproveBtn, "Approve booking button");
            enterText(popUpApproveTxtBox, StringUtils.getRandomString(10), "Popup Approve message");
            click(confirmApproveBtn, "Confirm Approve booking button");
        }
        WaitUtils.waitForElementNotExist(By.xpath("(//div[@role='dialog']//div[@data-state='active']//p)[1]"));
    }

    public void verifyBookingDetailsPopupAfterReject(String status) throws InterruptedException {
        WaitUtils.waitForElement(By.xpath("//div[@role='dialog']//div[@data-component-name='Badge']"));
        String popUpHeaderVehNumber = getText(popUpHeaderVehNum, "Popup Heading Vehicle Number");
        Assert.assertTrue(popUpHeaderVehNumber.contains(globalVariables.get("VehicleNumber")), "Vehicle Number is wrong on popup. Expected: " + globalVariables.get("VehicleNumber") + ", Actual: " + popUpHeaderVehNumber);
        String popUpStat = getText(popUpStatus, "Popup Status");
        Assert.assertEquals(popUpStat, status, "Status is wrong on popup");
        String popUpVehNumber = getText(popUpVehicleNum, "Popup Vehicle Number");
        Assert.assertEquals(popUpVehNumber, globalVariables.get("VehicleNumber"), "Vehicle Number is wrong on popup");
        String popUpVehicleType = getText(popUpVehType, "Popup Vehicle Type");
        Assert.assertEquals(popUpVehicleType.toLowerCase(), globalVariables.get("VehicleType").toLowerCase(), "Vehicle Type is wrong on popup");
        click(driverTab, "Driver tab");
        Thread.sleep(1000);
        String driverNm = getText(popUpDriverName, "Popup driver name");
        Assert.assertEquals(driverNm, globalVariables.get("DriverName"), "Driver name is wrong on popup");
        String popUpLicNum = getText(popUpLicenseNumber, "Popup License Number");
        Assert.assertEquals(popUpLicNum, globalVariables.get("LicenseNumber"), "License Number is wrong on popup");
        String popupMobileNum = getText(popUpMobileNumber, "Popup Mobile Number");
        Assert.assertEquals(popupMobileNum, globalVariables.get("MobileNumber"), "Mobile Number is wrong on popup");
        click(scheduleTab, "Schedule tab");
        Thread.sleep(1000);
        String popupExpArr = getText(popUpExpectedArrival, "Popup Expected Arrival");
        Assert.assertTrue(popupExpArr.contains(globalVariables.get("Arrival")), "Expected Arrival is wrong on popup. Actual: " + popupExpArr + ", Expected: " + globalVariables.get("Arrival"));
        String popupExpDep = getText(popUpExpectedDeparture, "Popup Expected Departure");
        Assert.assertTrue(popupExpDep.contains(globalVariables.get("Departure")), "Expected Departure is wrong on popup. Actual: " + popupExpArr + ", Expected: " + globalVariables.get("Departure"));
        String popupRequested = getText(popUpRequestedAt, "Popup Requested At");
        Assert.assertTrue(popupRequested.contains(globalVariables.get("Requested")), "Requested is wrong on popup. Actual: " + popupExpArr + ", Expected: " + globalVariables.get("Requested"));
        click(loadTab, "Load tab");
        Thread.sleep(1000);
        String popUpLoadTp = getText(popUpLoadType, "Popup Load Type");
        Assert.assertEquals(popUpLoadTp.toLowerCase(), globalVariables.get("LoadType").toLowerCase(), "Load Type is wrong on popup");
        String popUpGoodsTp = getText(popUpGoodsType, "Popup Goods Type");
        Assert.assertEquals(popUpGoodsTp.toLowerCase(), globalVariables.get("GoodsType").toLowerCase(), "Goods Type is wrong on popup");
        click(closePopup, "Close popup");
        Thread.sleep(1000);
    }

    public void getAllActionValues() {
        WaitUtils.waitForElement(By.xpath("(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[1]//p[2]"));
        globalVariables.put("TotalPending", getText(totalPending, "Total Pending"));
        globalVariables.put("TotalApproved", getText(totalApproved, "Total Approved"));
        globalVariables.put("TotalRejected", getText(totalRejected, "Total Rejected"));
        globalVariables.put("TotalActions", getText(totalActions, "Total Actions"));
    }

    public void verifyPendingAndRejected(String action1, String action2) {
        WaitUtils.waitForElement(By.xpath("(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[1]//p[2]"));
        int actualPending = Integer.parseInt(getText(totalPending, "Total Pending"));
        int expectedPending = Integer.parseInt(globalVariables.get("TotalPending")) - 1;
        Assert.assertEquals(actualPending, expectedPending, "Pending count has not updated when Reject");
        if (action1.equalsIgnoreCase("Rejected")) {
            int actualReject = Integer.parseInt(getText(totalRejected, "Total Rejected"));
            int expectedRejected = Integer.parseInt(globalVariables.get("TotalRejected")) + 1;
            Assert.assertEquals(actualReject, expectedRejected, "Rejected count has not updated when Reject");
        }
        if (action1.equalsIgnoreCase("Approved")) {
            int actualApproved = Integer.parseInt(getText(totalApproved, "Total Approved"));
            int expectedApproved = Integer.parseInt(globalVariables.get("TotalApproved")) + 1;
            Assert.assertEquals(actualApproved, expectedApproved, "Approved count has not updated when Approve");
        }
    }

    public void verifyTotal() {
        WaitUtils.waitForElement(By.xpath("(//div[@data-testid='content-booking-mgmt']//div[@data-component-name='Card'])[1]//p[2]"));
        int total1 = Integer.parseInt(globalVariables.get("TotalPending"));
        int total2 = Integer.parseInt(globalVariables.get("TotalApproved"));
        int total3 = Integer.parseInt(globalVariables.get("TotalRejected"));
        Assert.assertEquals(Integer.parseInt(globalVariables.get("TotalActions")), total1 + total2 + total3, "Total count of Pending, Approved and Rejected is wrong");
    }
}
