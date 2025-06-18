# Technical Context - DJI Bangalore UI Automation

## Technology Stack

### Core Technologies
1. **Java 11**
   - Language version: 11
   - Compiler compliance: 11
   - Source encoding: UTF-8

2. **Selenium WebDriver**
   - Version: 4.14.1
   - Purpose: Browser automation
   - Features used:
     - WebDriver interface
     - WebElement interactions
     - Wait conditions
     - Screenshot capture

3. **TestNG**
   - Version: 7.7.0
   - Purpose: Test execution framework
   - Features used:
     - Test annotations
     - Assertions
     - Test suite configuration
     - Test reporting

### Build & Dependency Management
1. **Maven**
   - Version: Based on wrapper
   - Build phases configured
   - Dependency management
   - Plugin configuration:
     - maven-compiler-plugin: 3.10.1
     - maven-surefire-plugin: 2.18.1

### Supporting Libraries
1. **WebDriverManager**
   - Version: 5.5.3
   - Purpose: Automated driver management
   - Features:
     - Chrome driver setup
     - Firefox driver setup
     - Version compatibility

2. **Lombok**
   - Version: 1.18.26
   - Purpose: Reduce boilerplate code
   - Features used:
     - @Log annotation
     - Constructor generation
     - Getter/Setter generation

3. **AspectJ**
   - Version: 1.8.10
   - Purpose: AOP support
   - Used by: maven-surefire-plugin

## Development Setup

### Prerequisites
1. **Java Development Kit (JDK)**
   - Version: 11 or higher
   - Environment variables:
     - JAVA_HOME set
     - Path updated

2. **Maven**
   - Version: 3.x or higher
   - Environment variables:
     - M2_HOME set
     - Path updated

3. **Browsers**
   - Chrome (latest version)
   - Firefox (latest version)

### IDE Configuration
1. **Recommended IDE**
   - IntelliJ IDEA or Eclipse
   - Required plugins:
     - Lombok plugin
     - TestNG plugin
     - Maven integration

2. **Project Import**
   - Import as Maven project
   - Enable annotation processing
   - Set Java compiler version

### Environment Variables
1. **Required**
   - JAVA_HOME
   - M2_HOME
   - PATH (including Java and Maven)

2. **Optional**
   - MAVEN_OPTS for memory settings
   - CHROME_BINARY for custom Chrome path
   - FIREFOX_BINARY for custom Firefox path

## Technical Constraints

### Browser Support
1. **Chrome**
   - Headless mode supported
   - Custom options configured
   - Window size: 1920x1200

2. **Firefox**
   - Standard mode only
   - Default configuration used

### Test Execution
1. **Timeouts**
   - Implicit wait: 5 seconds (Chrome)
   - Implicit wait: 15 seconds (Firefox)
   - Page load timeout: Default
   - Script timeout: Default

2. **Screenshots**
   - Format: PNG
   - Storage: User's Desktop
   - Naming: Test method name

### Resource Management
1. **Memory**
   - Default JVM settings
   - Configurable through MAVEN_OPTS

2. **Disk Space**
   - Required for:
     - Project files
     - Maven dependencies
     - Browser drivers
     - Test screenshots

## Dependencies

### Direct Dependencies
```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>${selenium.java.version}</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>${testng.version}</version>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
    </dependency>

    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>${webdrivermanager.version}</version>
    </dependency>
</dependencies>
```

### Build Plugins
```xml
<plugins>
    <!-- Compiler Plugin -->
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>${maven.compiler.version}</version>
    </plugin>

    <!-- Surefire Plugin -->
    <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.18.1</version>
    </plugin>
</plugins>
