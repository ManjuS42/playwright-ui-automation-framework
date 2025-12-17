package org.automation.playwrightframework.base;

import com.microsoft.playwright.*;
import org.automation.playwrightframework.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

  protected Playwright playwright;
  protected Browser browser;
  protected BrowserContext context;
  public Page page;

  @Parameters("browser")
  @BeforeMethod
  public void setUp(@Optional("chromium") String browserName) {

    playwright = Playwright.create();

    BrowserType.LaunchOptions options =
        new BrowserType.LaunchOptions().setHeadless(Boolean.parseBoolean(ConfigReader.get("headless")));

    switch (browserName.toLowerCase()) {
      case "chromium":
        browser = playwright.chromium().launch(options);
        break;
      case "firefox":
        browser = playwright.firefox().launch(options);
        break;
      case "webkit":
        browser = playwright.webkit().launch(options);
        break;
      default:
        browser = playwright.chromium().launch(options);
    }

    context = browser.newContext();
    page = context.newPage();
    page.navigate(ConfigReader.get("base.url"));
  }

  @AfterMethod
  public void tearDown() {
    context.close();
    browser.close();
    playwright.close();
  }
}
