# Selenium TestNG Automation Framework

A Page Object Model (POM) based test automation framework built with 
Selenium WebDriver, Java, TestNG, and Maven, targeting the SauceDemo 
(https://www.saucedemo.com) demo e-commerce site.

## Features
- Page Object Model design pattern for maintainable test code
- TestNG for test execution, assertions, and suite management
- Maven for dependency management and build automation
- WebDriverManager for automatic browser driver management
- Custom TestNG listener for automatic screenshot capture on test failure
- GitHub Actions CI/CD pipeline for automated test execution on every push
- HTML test reports generated automatically via TestNG

## Test Coverage
- Login: valid credentials, invalid credentials, empty credentials
- Add to cart: product addition and cart badge verification
- End-to-end checkout: login → add to cart → checkout → order confirmation

## Tech Stack
- Java 17
- Selenium WebDriver 4.22.0
- TestNG 7.10.2
- Maven
- GitHub Actions

## How to run locally
1. Clone the repository
2. Open in Eclipse/IntelliJ as a Maven project
3. Run `mvn clean test` or right-click `testng.xml` → Run As TestNG Suite
4. View report at `test-output/index.html`

## CI/CD
Tests run automatically on every push via GitHub Actions. The TestNG HTML 
report is uploaded as a downloadable artifact after each run.