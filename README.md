# 🧪 Scalable Cross-Browser UI Automation Framework using Playwright

## 📌 Overview

This project is a **modern UI automation framework** built using **Playwright, Java, TestNG, and Allure Reports**.
It is designed to be **scalable, maintainable, and CI/CD-friendly**, with support for **cross-browser execution**, **parallel runs**, and **rich reporting**.

The framework follows **clean architecture principles** and **Page Object Model (POM)** to ensure separation of concerns and long-term maintainability.

---

## 🛠 Tech Stack

* **Language:** Java
* **UI Automation:** Playwright
* **Test Runner:** TestNG
* **Build Tool:** Maven
* **Reporting:** Allure Reports
* **Design Pattern:** Page Object Model (POM)
* **CI/CD Ready:** Yes (Jenkins / GitHub Actions compatible)

---

## ✨ Key Features

* Cross-browser execution (Chromium, Firefox, WebKit)
* Parallel execution using TestNG
* Page Object Model for clean test design
* Config-driven execution (no hardcoding)
* Automatic screenshots on test failure
* Allure HTML reports with failure artifacts
* CI/CD compatible and parallel-safe

---

## 📁 Project Structure

```
playwrightFramework
│
├── src/main/java
│   └── org.automation.playwrightframework
│       ├── pages          # Page Objects (UI actions & locators)
│       ├── utils          # Config readers & utilities
│
├── src/test/java
│   └── org.automation.playwrightframework
│       ├── base           # BaseTest (browser lifecycle)
│       ├── listeners      # TestNG listeners (Allure)
│       └── tests          # Test classes
│
├── src/test/resources
│   └── config
│       └── config.properties
│
├── testng.xml
├── pom.xml
└── README.md
```

---

## ⚙️ Configuration

### `config.properties`

```properties
base.url=https://the-internet.herokuapp.com/login
browser=chromium
headless=false
```

* **base.url** → Application under test
* **browser** → Default browser for local runs
* **headless** → Enable/disable headless mode

> Browser can also be overridden via TestNG or CI pipeline.

---

## 🚀 Browser Management

The framework supports **all Playwright-supported browsers**:

| Browser Value | Engine        |
| ------------- | ------------- |
| chromium      | Chrome / Edge |
| firefox       | Firefox       |
| webkit        | Safari        |

Browser selection priority:

1. TestNG parameter (if provided)
2. `config.properties`
3. Default fallback → Chromium

---

## 🧱 Framework Architecture

### 🔹 BaseTest

* Manages Playwright lifecycle
* Handles browser launch and teardown
* Provides Page instance to tests

### 🔹 BasePage

* Contains common UI actions (click, type, getText, waits)
* All page objects extend BasePage
* Reduces duplication and improves readability

### 🔹 Page Objects

* Encapsulate locators and page-level actions
* No assertions inside page classes
* Reusable across tests

### 🔹 Tests

* Focus only on validations
* Extend BaseTest
* Clean and readable test logic

---

## 📸 Screenshot on Failure

On test failure:

* Screenshot is captured **in-memory as byte[]**
* Attached directly to Allure report
* Parallel execution safe
* No file system dependency

```java
byte[] screenshot = page.screenshot(
        new Page.ScreenshotOptions().setFullPage(true)
);
```

---

## 📊 Reporting (Allure)

### Generate and View Report

```bash
mvn clean test
mvn allure:serve
```

### Report Includes

* Test status
* Failure screenshots
* Execution timeline
* Browser-wise execution
* Test metadata

---

## ▶️ Running Tests

### Run via Maven

```bash
mvn clean test
```

### Run via IntelliJ

* Right-click `testng.xml`
* Click **Run**

---

## 🔁 Parallel Execution

Parallel execution is enabled at the **TestNG suite level**.

```xml
<suite parallel="tests" thread-count="3">
```

This allows:

* Browser-wise parallel runs
* Faster overall execution
* Better CI efficiency

---

## 🧠 Design Principles Followed

* Separation of concerns
* Config-driven execution
* No hardcoded test data
* Reusable and extensible components
* Fail-fast and debuggable tests

---

## 🔮 Future Enhancements

* Video recording on failure
* Retry logic for flaky tests
* API + UI hybrid testing
* Dockerized execution
* Environment-based test selection

---

## 🧑‍💻 Author

Automation Framework developed by **Manju S**

| Senior Software Development Engineer in Test (SDET) |

| 🔗 GitHub: https://github.com/ManjuS42 |

