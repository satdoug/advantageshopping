package com.advantageshopping.driver;

import com.advantageshopping.config.Configuration;
import com.advantageshopping.config.ConfigurationManager;
import com.advantageshopping.driver.local.LocalDriverManager;
import com.advantageshopping.driver.remote.RemoteDriverManager;
import com.advantageshopping.enums.Target;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;


@Log4j2
public class DriverFactory {

    private DriverFactory() {}

    public static WebDriver createInstance(String browser) {
        Configuration configuration = ConfigurationManager.getConfiguration();
        Target target = Target.valueOf(configuration.target().toUpperCase());
        WebDriver webdriver;

        switch (target) {

            case LOCAL:
                //override the browser value from @Optional on BeseWeb
                webdriver = new LocalDriverManager().createInstance(configuration.browser());
                break;
            case GRID:
                // getting the browser from the suite file or @Optional on BaseWeb
                webdriver = new RemoteDriverManager().createInstance(browser);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + target);
        }

        return webdriver;
    }
}
