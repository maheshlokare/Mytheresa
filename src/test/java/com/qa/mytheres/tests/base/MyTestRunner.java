package com.qa.mytheres.tests.base;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty","json:cucumber-json-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"
				}, 
		dryRun = false,
		monochrome = true,
		glue = { "com.qa.mytheresa.tests" },
		features = { "src/test/resources/features/login.feature"}
)

public class MyTestRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}