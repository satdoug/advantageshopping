package com.advantageshopping.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.advantageshopping.steps",
        plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false)
public class TestRunner {

    private static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setup() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        WebDriverManager.chromedriver().setup();
        driver.get("http://advantageonlineshopping.com/#/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void after(){
        driver.quit();
    }
}
