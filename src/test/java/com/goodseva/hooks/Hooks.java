package com.goodseva.hooks;

import com.goodseva.utils.FileUtils;
import com.goodseva.utils.VideoRecoderUtil;
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
    static String videoRecording = null;
	@Before
    public static void setUp(Scenario scenario) throws Exception {
		WebDriverHelper.launchBrowser();
        videoRecording = FileUtils.getProperty("config.properties", "videoRecording");
        if(videoRecording.equalsIgnoreCase("true")){
            VideoRecoderUtil.startRecord(scenario.getName());
        }
    }
 
    @After
    public static void tearDown(Scenario scenario) throws Exception {
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) WebDriverHelper.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }
        if(videoRecording.equalsIgnoreCase("true")){
            log.info("Stopping '"+scenario.getName()+"' scenario video recording");
            VideoRecoderUtil.stopRecord();
        }
        log.info("Closing browser");
        WebDriverHelper.tearDown();
    }

}

