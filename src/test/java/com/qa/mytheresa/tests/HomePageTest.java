package com.qa.mytheresa.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.qa.mytheres.tests.base.BaseTest;
import com.qa.mytheresa.utils.Utility;

public class HomePageTest extends BaseTest {

	Utility utility = new Utility();
	int respCode = 200;

	@Test()
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		boolean result = true;
		homePage.acceptCookies();
		Locator locator = homePage.getAllLiniks();
		System.out.println("Total number of links found "+locator.count());
		HashMap<String, Integer> brokenLinks = new HashMap<>();
		for (int i = 0; i < locator.count(); i++) {
			String url = locator.nth(i).getAttribute("href");
			if (url.startsWith("http")) {
				respCode = utility.getResponse(url);
				if (respCode >= 400) {
					if (brokenLinks.containsKey(url.trim()))
						;
					else {
						brokenLinks.put(url.trim(), respCode);
						result = false;
					}
				} else {
				}
			}

		}
		for (Map.Entry<String, Integer> entry : brokenLinks.entrySet()) {
			System.out.println("Link is " + entry.getKey() + " status code " + entry.getValue());
		}

		Assert.assertTrue(result);

	}
	

	@Test()
	public void login() throws InterruptedException {

		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		homePage.login(userName, password);
		Thread.sleep(10000);
		Assert.assertTrue(
				homePage.welcomeMessageValidation(prop.getProperty("firstname"), prop.getProperty("lastname")));

	}

}
