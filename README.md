# demo.realworld.io-automation-tests
This project contains automatic scripts to check the filtering of posts by tags on https://demo.realworld.io

# Tech
- Java 8
- Selenium WebDriver
- TestNG
- Apache Maven
- Allure Framework

# Configuration
- Tests configuration in ```testng.xml```
- Plugins, dependencies in ```pom.xml```

# Installation and running the tests
The following instructions assume you have installed Java 8 and Apache Maven

1. Open Git Bash where you are going to store the project.
2. Run ```$ git clone https://github.com/VyacheslavArtyomenko/demo.realworld.io-automation-tests.git```
3. Open command line in project folder and run ```testng.xml``` file using ```$ mvn clean test```

# Key components
- ```\src\main\java\pages\MainPage``` class that contains locators and methods necessary for running tests
- ```\src\main\java\utils\WebDriverFactory``` class that contains logic for instantiating ```driver``` variable with an instance of a specific driver depending on the desired browser
- ```\src\test\java\TagSelectionTest``` class that contains main logic of tests and assertions 
