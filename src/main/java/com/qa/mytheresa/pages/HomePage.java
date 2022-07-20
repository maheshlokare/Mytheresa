package com.qa.mytheresa.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	private String myAccount = "text= My account";
	private String username = "input[title= 'Email address']:below(:text('Already registered?'))";
	private String password = "input[title= 'Password']:below(:text('Already registered?'))";
	private String loginButton = "//span[text()='Login']";
	private String links = "//a[@href]";
	private String loginValidation = "text=Hello, Mahesh Lokare!";

	public HomePage(Page Page) {
		this.page = Page;
	}

	public String getHomePageTitle() {
		return page.title();
	}

	public String getUrl() {
		return page.url();
	}

	public void acceptCookies() {
		page.frameLocator("#privacy-iframe").locator("'Accept all and continue'").click();
	}

	public Locator getAllLiniks() {
		return page.locator(links);
	}

	public void login(String userName, String password) {
		acceptCookies();
		page.click(myAccount);
		page.fill(username, userName);
		page.fill(this.password, password);
		page.click(loginButton);
	}

	public boolean welcomeMessageValidation(String firstName, String lastName) {
		boolean result = true;
		try {
			Locator welcome = page.locator("text=Hello, " + firstName + " " + lastName + "!");
			if(welcome.count()==0) {
				result = false;
			}
		} catch (Exception e) {
			return false;
		}
		return result;
	}

}
