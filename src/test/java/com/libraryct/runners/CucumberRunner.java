package com.libraryct.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com/libraryct/step_definitions",
    dryRun = true,
   // tags = "@add_user",
    publish = true
)

public class CucumberRunner {
}
