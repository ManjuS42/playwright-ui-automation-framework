package org.automation.playwrightframework.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

  private final Page page;

  public LoginPage(Page page) {
    this.page = page;
  }

  // Locators
  private String username = "#username";
  private String password = "#password";
  private String loginBtn = "button[type='submit']";
  private String successMsg = "h2";

  // Actions
  public void login(String user, String pass) {
    page.fill(username, user);
    page.fill(password, pass);
    page.click(loginBtn);
  }

  public String getSuccessMessage() {
    return page.textContent(successMsg);
  }


}

