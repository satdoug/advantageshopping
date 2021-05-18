package com.advantageshopping.driver.local;

import com.advantageshopping.config.Configuration;
import com.advantageshopping.config.ConfigurationManager;
import com.advantageshopping.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.lang.reflect.InvocationTargetException;

import static java.lang.Boolean.TRUE;

@Log4j2
public class LocalDriverManager implements IDriver {

    @Override
    public WebDriver createInstance(String browser) {
        WebDriver driverInstance = null;

        try {
            DriverManagerType driverManagerType = DriverManagerType.valueOf(browser.toUpperCase());
            Class<?> driverClass = Class.forName(driverManagerType.browserClass());
            WebDriverManager.getInstance(driverManagerType).setup();
            Configuration configuration = ConfigurationManager.getConfiguration();

            if (TRUE.equals(configuration.headless())) {
                driverInstance = defineHeadless(driverClass);
            } else {
                driverInstance = (WebDriver) driverClass.getDeclaredConstructor().newInstance();
            }

        } catch (IllegalAccessException | ClassNotFoundException e) {
            log.error("The class could not be found", e);
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            log.error("Problem during driver instantiation", e);
        }
        return driverInstance;
    }

    private WebDriver defineHeadless(Class<?> driverClass) {
        WebDriver driver;

        if (ChromeDriver.class == driverClass) {
            driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        } else if (FirefoxDriver.class == driverClass) {
            driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
        } else {
            throw new IllegalArgumentException("Headless is only supported by Google Chrome or Firefox");
        }

        return driver;
    }
}
