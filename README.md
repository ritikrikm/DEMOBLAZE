# Selenium + TestNG + POM Framework (Carbohydrate Calculator)

This repository contains a **corporate-style automation framework design** for a carbohydrate calculator web application.

> As requested, test methods are created but **test logic is intentionally not implemented**.

## Tech Stack
- Java 11
- Maven
- Selenium WebDriver
- TestNG
- Page Object Model (POM)
- Log4j2 logging
- Extent Reports
- Screenshot capture utility

## Framework Design

### 1) Configuration Layer
- `src/test/resources/config/config.properties`
  - Central place for base URL, browser, headless mode, timeouts, screenshot behavior.
- `com.carbocalc.utils.ConfigReader`
  - Reads config values and supports system property overrides.

### 2) Driver Layer
- `com.carbocalc.driver.DriverFactory`
  - Thread-safe WebDriver lifecycle using `ThreadLocal`.
  - Supports Chrome/Firefox/Edge.
  - Applies waits and page-load timeout.

### 3) Base Layer
- `com.carbocalc.base.BaseTest`
  - Test-level setup/teardown.
  - Opens app URL before each test and closes browser after each test.
- `com.carbocalc.base.BasePage`
  - Shared wrapper methods (`click`, `type`, `read`) for page objects.

### 4) Page Object Layer (POM)
- `com.carbocalc.pages.CarbohydrateCalculatorPage`
  - Calculator locators and reusable business actions.
  - Keeps UI interaction separate from test classes.

### 5) Reporting + Logging Layer
- `src/test/resources/log4j2.xml`
  - Console + rolling file logging.
- `com.carbocalc.utils.ExtentManager`
  - Creates and configures Extent report instance.
- `com.carbocalc.listeners.TestListener`
  - TestNG listener for pass/fail/skip hooks.
  - Adds logs and screenshots to Extent on failures.
- `com.carbocalc.utils.ScreenshotUtils`
  - Captures screenshots with timestamped names.

### 6) Test Layer
- `com.carbocalc.tests.CarbohydrateCalculatorTestCases`
  - Contains TC-001 to TC-008 method stubs.
  - All methods are disabled (`enabled = false`) so you can implement them yourself.

---

## Step-by-Step Build Order (How the Framework Was Designed)
This is the exact sequence used so you can reuse it in future projects:

1. **Set up Maven and dependencies** in `pom.xml`.
2. **Create runtime config** (`config.properties`) for environment-driven execution.
3. **Implement `ConfigReader`** so everything reads from one source.
4. **Build `DriverFactory`** for browser creation + thread safety.
5. **Build `BaseTest`** for centralized setup/teardown.
6. **Build `BasePage`** for common web actions and explicit waits.
7. **Add logging config** with `log4j2.xml`.
8. **Add report manager** (`ExtentManager`) and **screenshot utility**.
9. **Add TestNG listener** (`TestListener`) to connect execution, logs, screenshots, and reports.
10. **Create page objects** for the calculator screen.
11. **Create test case class and empty methods** for TC-001 to TC-008.
12. **Wire suite execution** through `testng.xml`.
13. **Add `.gitignore`** to keep repo clean from generated files.

---

## Project Structure

```text
src
└── test
    ├── java
    │   └── com
    │       └── carbocalc
    │           ├── base
    │           │   ├── BasePage.java
    │           │   └── BaseTest.java
    │           ├── driver
    │           │   └── DriverFactory.java
    │           ├── listeners
    │           │   └── TestListener.java
    │           ├── pages
    │           │   └── CarbohydrateCalculatorPage.java
    │           ├── tests
    │           │   └── CarbohydrateCalculatorTestCases.java
    │           └── utils
    │               ├── ConfigReader.java
    │               ├── ExtentManager.java
    │               └── ScreenshotUtils.java
    └── resources
        ├── config
        │   └── config.properties
        └── log4j2.xml
```

## How to Run
```bash
mvn test
```

## Notes
- Test methods are placeholders only, by design.
- You can enable a test method and add your own flow/assertions when ready.
- Reports and screenshots are generated under `target/extent-reports` and `target/screenshots`.
