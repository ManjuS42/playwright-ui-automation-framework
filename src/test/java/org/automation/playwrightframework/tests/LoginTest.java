package org.automation.playwrightframework.tests;

import io.qameta.allure.*;
import org.automation.playwrightframework.base.BaseTest;
import org.automation.playwrightframework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Login Feature")
@Feature("User Authentication")
public class LoginTest extends BaseTest {

  @Test(description = "Verify valid user login")
  @Story("Valid Login")
  @Severity(SeverityLevel.CRITICAL)
  public void verifyValidLogin() {

    LoginPage loginPage = new LoginPage(page);
    loginPage.login("admin", "admin123");

    Assert.assertTrue(loginPage.getSuccessMessage().contains("Login Page"), "Login failed!");
    Assert.assertTrue(page.title().equals("The Internet"), "Page title mismatch after login");
  }
}
