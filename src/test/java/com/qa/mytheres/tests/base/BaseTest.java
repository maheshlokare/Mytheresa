package com.qa.mytheres.tests.base;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.mytheresa.factory.PlaywrightFactory;
import com.qa.mytheresa.pages.HomePage;


public class BaseTest {
	
	PlaywrightFactory pw;
	Page page;
	protected HomePage homePage;
	protected Properties prop;
	protected String environment="test";
	
	@Parameters({ "environment" })
	@BeforeSuite
	public void beforeSuite(String env) {
		System.out.println("Enviornment is "+env);
		environment = env;
		
	}
	@BeforeMethod
	public void setup() {
		pw = new PlaywrightFactory();
		prop = pw.init_prop();
		page = pw.initBrowser(prop, environment);
		homePage = new HomePage(page);
	}
	
	
	@AfterMethod
	public void tearDown() {
		page.context().browser().close();
	}
	
	


}
