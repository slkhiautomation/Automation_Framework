package Test.Automation;

import Test.Automation.Utils.DriverFactory;
import TestSuite.AfterSuite;
import TestSuite.BeforeSuite;
import TestSuite.ExtendedCucumberRunner;
//import com.cucumber.listener.Reporter;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import io.qameta.allure.Epic;
import org.junit.runner.RunWith;
import io.qameta.allure.Link;
import io.qameta.allure.Issue;
import java.io.IOException;
import java.sql.SQLException;

@Epic("Regression Test")
@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(


        //Execution//
//        tags = {"@Search"},
        features = {"src/test/resources/features/SearchPage.feature"},
//        (plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
        plugin = {"pretty", "html:target/cucumber-html-report-Sanity",
                "json:target/cucumber-json-report-Sanity.json",
                "rerun:target/rerun-Sanity.txt",
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "io.qameta.allure.cucumberjvm.AllureCucumberJvm",
                })
//        plugin = { "json:target/positive/cucumber.json", "pretty",
//                "html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
//                "html:target/cucumber/cucumber.html",
//                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",})
//        monochrome = true)

public class RunAll_Sanity extends DriverFactory  {

    public RunAll_Sanity() throws IOException, SQLException, ClassNotFoundException {


    }

    @BeforeSuite
    public static void setUp() {

    }

    @AfterSuite
    public static void tearDown() throws Exception {

        System.out.println("Test Suit Execution Completed.");
        System.out.println("Test Suit Execution Completed.");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("Machine", System.getProperty("os.name"));
        Reporter.setSystemInfo("Selenium", "3.7.0");
        Reporter.setSystemInfo("Maven", "3.5.2");
        Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
//		SendEmail.sendEmailBody(TestData.Email.EMAIL_RESULT_SUBJECT, "cucumber-json-report-Sanity");
        System.setProperty("extent.reporter.avent.start", "true");
        System.setProperty("extent.reporter.avent.config", "avent-config.xml");
        System.setProperty("extent.reporter.avent.out", "test-output/AventReport/");
        System.setProperty("extent.reporter.klov.start", "true");
        System.setProperty("extent.reporter.klov.config", "klov.properties");
        quitDriver();
    }
}


