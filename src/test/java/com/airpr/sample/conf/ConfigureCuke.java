package com.airpr.sample.conf;

import com.airpr.driver.DriverManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ConfigureCuke {

    Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        System.out.println("Execution Started");
        System.out.println("Scenario: " + scenario.getName());
        DriverManager.setDriver(getBrowserDriver());
        setDefaultBrowserProperties(DriverManager.getDriver());


    }

    private void setDefaultBrowserProperties(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private WebDriver getBrowserDriver() {
        setDriverExecutable();
        switch (getAppProperties().getProperty("browser")) {

            case "ie":

                return new InternetExplorerDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();

        }

    }

    private void setDriverExecutable() {

        if (System.getProperty("os.name").startsWith("Windows")) {

            System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            System.setProperty("webdriver.firefox.driver", "/drivers/geckodriver.exe");

        } else if (System.getProperty("os.name").startsWith("Mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mchromedriver");
            System.setProperty("webdriver.firefox.driver", "src/test/resources/drivers/mgeckodriver");

        } else if (System.getProperty("os.name").startsWith("u")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/lchromedriver");
            System.setProperty("webdriver.firefox.driver", "src/test/resources/drivers/lgeckodriver");

        }
    }

    private Properties getAppProperties() {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("atddConfiguration.properties")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    @After
    public void tearDown() {
        DriverManager.getDriver().quit();
        System.out.println();
    }
}
