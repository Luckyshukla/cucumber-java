package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
glue = {"stepDefinitions"},
tags="@RegressionTest",
plugin = {"html:target/reports/cucumber-html-report.html", "json:target/reports/cucumber.json", "pretty"},
monochrome = true
		)
public class TestRunner {

}
