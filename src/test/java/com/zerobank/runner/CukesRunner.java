package com.zerobank.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features ="src/test/resources/features/",
        glue = "com/zerobank/step_definitions",
        dryRun = false ,
        tags = "@savings",
        strict =true
)

public class CukesRunner {
}
