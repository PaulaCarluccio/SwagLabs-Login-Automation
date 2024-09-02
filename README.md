# SwagLabs-Login-Automation
Automation project for the Swag Labs login functionality, implemented in Java using the Page Object Model (POM) pattern and Cucumber/Gherkin for behavior-driven development (BDD).

## Requirements

This project was developed and tested with the following versions:

- **Java 22** 
- **Maven 3.9.9** 

These versions are recommended to ensure compatibility, but the project may work with older versions as well.

# Project Structure
- src/test/resources/: Contains feature files (.feature) for Cucumber.
- src/test/java/: Contains step definitions and page object classes.
- src/test/java/runner/: Contains the test runner class.
- pom.xml: Maven configuration file.

# Known Issues
- One of the tests, specifically the "Problem User" scenario that validates images, is expected to fail due to the current setup.
