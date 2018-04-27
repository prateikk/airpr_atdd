package com.airpr.sample.steps;

import com.airpr.PageObjects.Dashboard;
import com.airpr.PageObjects.Login;
import com.airpr.driver.DriverManager;
import com.airpr.utils.WaitUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardSteps {
    WebDriver driver = DriverManager.getDriver();

    final String userName = "pushkar.deshpande@velotio.com";
    final String pwd = "pushkar123";

    @Given("^User logs in to \"([^\"]*)\" UI as a \"([^\"]*)\" user$")
    public void userLogsInToUIAsAUser(String profile, String user) throws Throwable {
        PageFactory.initElements(driver,Login.class);
        PageFactory.initElements(driver,Dashboard.class);

        driver.get("http://analyst.airpr.com");
        Login.userName.sendKeys(userName);
        Login.password.sendKeys(pwd);
        Login.loginBtn.click();
        WaitUtils.waitFor(Dashboard.btnCustomize);
        System.out.println(driver.getTitle());

        Assert.assertTrue(driver.getTitle().equals("Dashboard - AirPR Analyst"));
    }

    @Then("^user is shown Dashboard screen by default$")
    public void user_is_shown_screen_by_default() {
        Assert.assertTrue(Dashboard.hdDashboard.isDisplayed());
    }
}
