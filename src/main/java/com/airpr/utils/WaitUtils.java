package com.airpr.utils;

import com.airpr.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtils {
    static WebDriver driver = DriverManager.getDriver();
    static WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

    public static void waitFor(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
}
