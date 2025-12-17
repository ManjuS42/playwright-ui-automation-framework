package org.automation.playwrightframework.listeners;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.automation.playwrightframework.base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class AllureTestListener implements ITestListener {

  @Override
  public void onTestFailure(ITestResult result) {
    Object testClass = result.getInstance();

    if (testClass instanceof BaseTest) {
      Page page = ((BaseTest) testClass).page;

      // Captures screenshot as byte[] (full page) for attaching directly to Allure reports (CI & parallel safe)
      byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));

      Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(screenshot));
    }
  }
}

// Saves screenshot to local file system; not preferred for Allure or parallel execution due to file conflicts
// page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
