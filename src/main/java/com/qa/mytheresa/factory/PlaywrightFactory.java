package com.qa.mytheresa.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	Properties prop;
	Page page;


	public Page initBrowser(Properties prop, String enviornment) {
		String browserName = prop.getProperty("browser").trim();
		String url = prop.getProperty("url_" + enviornment);
		System.out.println("URL is "+url);
		System.out.println("Browser name is " + browserName);
		playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		String headless = prop.getProperty("headless");
		if (!headless.equalsIgnoreCase("true")) {
			lp.setHeadless(false);
		}

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(lp);
			break;

		case "chrome":
			lp.setChannel("chrome");
			browser = playwright.chromium().launch(lp);
			break;

		case "firefox":
			browser = playwright.firefox().launch(lp);
			break;

		case "safari":
			browser = playwright.webkit().launch(lp);
			break;

		default:
			browser = playwright.chromium().launch(lp);
			break;
		}

		browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		page = browserContext.newPage();
		page.navigate(url);

		return page;

	}

	public Properties init_prop() {
		try {
			FileInputStream fp = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(fp);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		String url = prop.getProperty("url");
		System.out.println("Browser name is " + browserName);
		playwright = Playwright.create();
		LaunchOptions lp = new LaunchOptions();
		lp.setHeadless(false);

		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(lp);
			break;

		case "chrome":
			lp.setChannel("chrome");
			browser = playwright.chromium().launch(lp);
			break;

		case "firefox":
			browser = playwright.firefox().launch(lp);
			break;

		case "safari":
			browser = playwright.webkit().launch(lp);
			break;

		default:
			browser = playwright.chromium().launch(lp);
			break;
		}

		browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
		page = browserContext.newPage();
		page.navigate(url);

		return page;

	}

}
