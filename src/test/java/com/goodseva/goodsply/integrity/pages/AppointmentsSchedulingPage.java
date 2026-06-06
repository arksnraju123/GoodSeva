package com.goodseva.goodsply.integrity.pages;

import com.goodseva.webdriverutils.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AppointmentsSchedulingPage extends DriverUtils {
    public AppointmentsSchedulingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public boolean isScheduledStatusDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::span[contains(@class, 'status-scheduled')]"), "Scheduled Status"), "Scheduled Status");
    }

    public boolean isArrivedStatusDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::span[contains(@class, 'status-arrived')]"), "Arrived Status"), "Scheduled Status");
    }

    public boolean isLoadingStatusDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::span[contains(@class, 'status-loading')]"), "Arrived Status"), "Scheduled Status");
    }

    public boolean isDepartedStatusDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::span[contains(@class, 'status-departed')]"), "Departed Status"), "Departed Status");
    }

    public boolean isMarkArrivedButtonDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::button[contains(@data-testid, 'mark-arrived')]"), "Mark Arrived button"), "Mark Arrived button");
    }

    public boolean isStartLoadingButtonDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::button[contains(@data-testid, 'start-loading')]"), "Start Loading button"), "Start Loading button");
    }

    public boolean isMarkDepartedButtonDisplayed(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        return isElementDisplayed(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::button[contains(@data-testid, 'mark-departed')]"), "Mark Departed button"), "Mark Departed button");
    }

    public void clickOnMarkArrived(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        click(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::button[contains(@data-testid, 'mark-arrived')]"), "Mark Arrived button"), "Book Appointment button");
    }

    public void clickOnStartLoading(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        click(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::button[contains(@data-testid, 'start-loading')]"), "Start Loading button"), "Start Loading button");
    }

    public void clickOnMarkDeparted(){
        String startTime = globalVariables.get("startTime");
        String endTime = globalVariables.get("endTime");
        click(getElement(By.xpath("//span[contains(text(), '"+startTime+"') or contains(text(), '"+endTime+"')]/following::button[contains(@data-testid, 'mark-departed')]"), "mark-departed button"), "mark-departed button");
    }
}
