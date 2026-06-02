package com.goodseva.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Appointments01",
        glue = { "com.goodseva", "com.goodseva.hooks" },
        features = "src/test/resources/features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/rerun.txt" })
public class TestRunnerGoodSeva {
}
