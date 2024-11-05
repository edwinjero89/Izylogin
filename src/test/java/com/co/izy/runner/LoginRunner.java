package com.co.izy.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        snippets = SnippetType.CAMELCASE,
        glue = "com.co.izy.stepdefinitions"
        //tags = "@login"
)
public class LoginRunner {
}
