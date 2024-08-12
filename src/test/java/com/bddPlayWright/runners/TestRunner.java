package com.bddPlayWright.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.bddPlayWright.steps", "com.bddPlayWright.hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-reports.json",
        },
        monochrome = true,
        //  tags = "@SmokeTest", // Optional: use if you want to filter specific tags
        publish = true // Optional: enable this if you want to publish results to Cucumber's report service
)
public class TestRunner {
}
