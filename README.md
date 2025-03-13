# Unified Automation Template

## Overview
The Unified Automation Template is designed to facilitate automated testing across Web UI, Mobile UI, and API platforms. It supports scenario tagging for selective test execution, making the process flexible and manageable.

## Features
- **Multi-Platform Testing:** Supports Web UI, Mobile UI, and API automation.
- **Scenario Tagging:** Enables running specific test scenarios using tags.
- **Customizable Driver Selection:** Defaults to Chrome for Web UI, with the option to choose other drivers.
- **Headless Execution:** Supports headless mode via configuration.

## Prerequisites
- Java 17
- Maven
- Appium (for mobile testing)

## Setup
1. Clone the repository:
```bash
git clone https://github.com/egecansen/Unified-Automation-Template.git
cd Unified-Automation-Template
```
2. Configure the `test.properties` file to set desired properties such as headless execution, appium configurations and api auth credentials.

## Running Tests
- Run all tests:
```bash
mvn clean test
```
- Run specific scenarios using tags:
```bash
mvn clean test -q -Dcucumber.filter.tags="@SCN-RestfulBooker-01"
```
- Headless execution (adjust in `test.properties`):
```
headless=true
```


