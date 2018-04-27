package com.airpr.sample.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions
        (plugin = {"pretty", "html:Folder_Name",
                "json:Folder_Name/cucumber.json"}, features = "src/test/resources/features", glue = {"com.airpr.sample"}, tags = "@dashboard", monochrome = true)

public class RunCukeTest {
}
