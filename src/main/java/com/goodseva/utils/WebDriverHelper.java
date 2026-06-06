package com.goodseva.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.HashMap;

public class WebDriverHelper {
    static WebDriver driver;
    public static Logger log = LogManager.getLogger();
    public static HashMap<String, String> globalVariables = new HashMap<>();
    public static void launchBrowser() throws Exception {
        String baseURL = null;
        String browser = FileUtils.getProperty("config.properties", "browser");
        String appName = FileUtils.getProperty("config.properties", "appName");
        if (appName.equalsIgnoreCase("goodsply")) {
            baseURL = FileUtils.getProperty("config.properties", "goodsplyURL");
        } else {
            log.error("Invalid app name '" + appName + "' provided in config.properties. Valid app names is goodsply");
        }

        if (browser.equalsIgnoreCase("Chrome")) {
            log.info("Launching " + browser + " browser");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            log.info("Launching " + browser + " browser");
            driver = new EdgeDriver();
        } else {
            throw new Exception("Invalid browser name provided");
        }
        driver.manage().window().maximize();
        log.info("Navigating to: " + baseURL);
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        globalVariables.clear();
        if (driver != null) {
            driver.quit();
        }
    }
}
