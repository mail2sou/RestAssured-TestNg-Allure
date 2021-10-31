<h1><B>API Test Automation - Using RestAssured Framework</B></h1>

**Pre-Requisites**

1. Download and install Java JDK 8
2. Download and install Apache Maven and set up environment variables for Maven
3. Download and install Allure CLI to get allure reports

**Project Specification**

1. Framework: RestAssured with TestNG and Allure Reporting (with JUnit assertions)
2. Operating System configured in the framework: Windows, macOS, and Unix like environment
3. Build tool: Maven
4. IDE used to develop the framework: IntelliJ IDEA Community Edition 2021.2.2

**API Authorization**

1. Currently, a sample bearer token is provided in the <I><B>config/config.properties</I></B> file. If required, you may update your own token before execution

**Steps to run this project from the terminal**

1. Clone this project from GitHub: https://github.com/mail2sou/RestAssured-TestNg-Allure.git
2. Run maven build lifecycle <I><B>mvn clean install test</I></B>
3. You can also use IDE and run the <I><B>testng.xml</I></B> present in the project

**Generating the test report**

1. Once the execution is complete, the test reports can be found in <I><B>RestAssured-TestNg-Allure\target\surefire-reports\emailable-report.html</I></B>
2. To generate allure report, you must install the allure CLI. This can be installed through npm (if you have nodejs and npm installed or by downloading the allure CLI)
3. If you want to install allure through npm then, following is the command <I><B>npm install -g allure-commandline</I></B>
4. You also have to set the allure CLI path to your environment variable. If successfully installed, then you can check your allure version using command <I><B>allure --version</I></B>
5. To generate the report, run the following command from the terminal <I><B>allure serve allure-results --clean and allure open</I></B>
6. If allure does not work due to running scripts disabled error, then run this through terminal <I><B>Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy Unrestricted</I></B> to fix the issue and generate the report again

**Probable challenges while setup**

1. While resolving the maven dependencies of the project, disconnect any VPN or go behind the firewall as it may not let the <I><B>pom.xml</I></B> to connect to the Maven repo and download the dependencies which are required to run this project
2. If allure does not work due to running scripts disabled error, then run this through terminal <I><B>Set-ExecutionPolicy -Scope CurrentUser -ExecutionPolicy Unrestricted</I></B> to fix the issue and generate the report again

**Things that I would have improved, if I had more time**

1. Would have added detailed test scenarios to validate each API in detail with more edge cases
2. Would have increased the scope of testing by validating other APIs like Login, Logout etc.
