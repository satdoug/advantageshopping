package com.advantageshopping.driver;

import org.openqa.selenium.WebDriver;

public interface IDriver {

    WebDriver createInstance(String browser);
}
