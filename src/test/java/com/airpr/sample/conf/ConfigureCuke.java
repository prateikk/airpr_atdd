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

    Scenario scenario ;

    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
        System.out.println("Execution Started");
        System.out.println("Scenario: "+scenario.getName());
        DriverManager.setDriver(getBrowserDriver());
        setDefaultBrowserProperties(DriverManager.getDriver());


    }

    private void setDefaultBrowserProperties(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private WebDriver getBrowserDriver() {

        switch (getAppProperties().getProperty("browser")){
            case "ie":
                System.setProperty("webdriver.ie.driver","IEDriverServer");
                return new InternetExplorerDriver();

            case "firefox":
                System.setProperty("webdriver.gecko.driver","geckodriver");
                return new FirefoxDriver();

            default:
                System.setProperty("webdriver.chrome.driver","chromedriver");
                return new ChromeDriver();

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
    public void tearDown(){
        DriverManager.getDriver().quit();
        System.out.println();
    }
}
