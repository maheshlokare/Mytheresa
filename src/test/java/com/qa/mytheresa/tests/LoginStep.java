package com.qa.mytheresa.tests;



import java.util.Properties;

import com.microsoft.playwright.Page;
import com.qa.mytheresa.factory.PlaywrightFactory;
import com.qa.mytheresa.pages.HomePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep{
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

	
	
	
	@Given("user navigates to website and accepts cookies")
	public void user_navigates_to_website_and_accepts_cookies() {
		homePage.acceptCookies();
	}

	@When("user performs login with username {string} and {string}")
	public void user_performs_login_with_username_and(String username, String password) {
		homePage.login(username, password);
	}
	
	@Then("verify user is logged in successfully")
	public void verify_user_is_logged_in_successfully() {
	    System.out.println("Done");
	}

	

}
