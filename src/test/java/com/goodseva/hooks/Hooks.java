package com.goodseva.hooks;

import com.goodseva.utils.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
	public static Logger log = LogManager.getLogger();
	@Before
    public static void setUp() throws Exception {
		WebDriverHelper.launchBrowser();
    }
 
    @After
    public static void tearDown(Scenario scenario) {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) WebDriverHelper.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }   
        log.info("Closing browser");
        WebDriverHelper.tearDown();
    }

}

