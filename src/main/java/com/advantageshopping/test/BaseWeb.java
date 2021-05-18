package com.advantageshopping.test;

import com.advantageshopping.config.Configuration;
import com.advantageshopping.config.ConfigurationManager;
import com.advantageshopping.driver.DriverFactory;
import com.advantageshopping.driver.DriverManager;
import com.advantageshopping.report.AllureManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners({TestListener.class})
public abstract class BaseWeb {

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        Configuration configuration = ConfigurationManager.getConfiguration();

        WebDriver driver = DriverFactory.createInstance(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(configuration.url());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }
}
