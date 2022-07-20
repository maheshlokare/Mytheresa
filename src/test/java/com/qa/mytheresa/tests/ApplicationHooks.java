package com.qa.mytheresa.tests;

import java.util.Properties;


import com.microsoft.playwright.Page;
import com.qa.mytheresa.factory.PlaywrightFactory;
import com.qa.mytheresa.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	
	PlaywrightFactory pw;
	Page page;
	protected HomePage homePage;
	protected Properties prop;
	

	@Before
	public void setupCucumber() {
		pw = new PlaywrightFactory();
		prop = pw.init_prop();
		page = pw.initBrowser(prop);
		homePage = new HomePage(page);
	}
	
	
	@After
	public void tearDownCucmber() {
		page.context().browser().close();
	}

}
