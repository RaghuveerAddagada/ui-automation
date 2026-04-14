# UI Automation Framework
A robust Java-based UI automation framework built with Maven, TestNG, and Selenium. This project implements system patterns for scalable, maintainable, and reliable automated testing.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Prerequisites](#prerequisites)
3. [Project Structure](#project-structure)
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
## Project Structure

The project follows Maven standard structure:

```
src/
├── main/java/
│   └── com/
│       └── example/
│           └── automation/
│               ├── pages/           # Page objects for UI elements
│               ├── utilities/       # Common utilities and helpers
│               ├── base/            # Base classes and configurations
│               ├── services/        # API and data services
│               └── config/          # Configuration files
├── test/java/
│   └── com/
│       └── example/
│           └── automation/
│               ├── test/           # Individual test classes
│               ├── suite/          # Test suites
│               ├── listeners/       # Test listeners
│               └── reporters/       # Custom reporters
├── resources/
│   ├── config/                     # Properties files for configuration
│   ├── reports/                    # Report templates and outputs
│   ├── templates/                  # HTML/Excel report templates
│   └── scripts/                    # Utility scripts
└── memory-bank/                    # Project documentation
    ├── projectbrief.md             # High-level project description
    ├── techContext.md              # Technical architecture and decisions
    ├── productContext.md           # Product requirements and scope
    ├── systemPatterns.md           # Design patterns and architecture
    ├── activeContext.md            # Current development context
    └── progress.md                 # Development progress and milestones
```

### Key Directories Explained

**Main Source (main/java):**
- **pages/**: Contains Page Object classes for different UI modules
- **utilities/**: Utility classes for common operations (file handling, date formatting, etc.)
- **base/**: Base classes for test runners, page objects, and browser management
- **services/**: Service classes for API testing and data management
- **config/**: Configuration classes and loaders

**Test Source (test/java):**
- **test/**: Individual test classes implementing test scenarios
- **suite/**: TestNG suites for organizing and running test groups
- **listeners/**: Custom listeners for test lifecycle events
- **reporters/**: Custom reporting components

**Resources (resources/):**
- **config/**: Properties files for different environments
- **reports/**: Generated reports and report outputs
- **templates/**: HTML/Excel templates for reports
- **scripts/**: External scripts for setup/teardown

