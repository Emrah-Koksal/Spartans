package com.spartans.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={
                "json:target/cucumber.json",
                "html:target/default-html-reports",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/spartans/step_definitions",
        dryRun =true,
        tags = "@api_practice"

)
public class CukesRunner {
}
