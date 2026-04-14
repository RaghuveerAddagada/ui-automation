# UI Automation Framework
A robust Java-based UI automation framework built with Maven, TestNG, and Selenium. This project implements system patterns for scalable, maintainable, and reliable automated testing.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
4. [Project Structure](#project-structure)
5. [Getting Started](#getting-started)
6. [Configuration](#configuration)
7. [Running Tests](#running-tests)
8. [Documentation](#documentation)
9. [Contribution](#contribution)
10. [License](#license)

## Project Overview

This UI automation framework provides:
- **Cross-browser** testing support (Chrome, Firefox, Edge, Safari)
- **Page Object Model** architecture for maintainability
- **Flexible data-driven** test execution
- **Visual comparison** and screenshot capabilities
- **Robust reporting** with TestNG and extent reports
- **CI/CD integration** with Jenkins pipelines
- **Parallel execution** for faster test cycles
- **Memory management** optimization for long-running tests

## Features

### Architecture
- Page Object Model (POM) design pattern
- Singleton factory pattern for browser management
- Service layer abstraction for reusable components

### Testing Capabilities
- Keyword-driven and data-driven testing
- Visual regression testing
- Cross-browser and cross-platform compatibility
- API testing integration

### Infrastructure
- Docker container support for Selenium Grid
- Jenkins CI/CD pipeline integration
- Maven-based dependency management
- Comprehensive logging with SLF4J/Logback

### Reporting
- Allure reports
- Extent reports with custom templates
- HTML and XML test reports

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- TestNG
