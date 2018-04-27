package com.airpr.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    private static DriverManager driverManager = new DriverManager();
    private static WebDriver driver;


    private DriverManager() {
    }

    public static DriverManager instance(){
        return driverManager;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
