package com.airpr.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Dashboard {

    @FindBy(how = How.XPATH,using = "//button[@class=\"btn btn-primary ember-view\"]" )
    public static WebElement btnCustomize;

    @FindBy(how = How.XPATH,using = ".//*[@class='p-0']/h1" )
    public static WebElement hdDashboard;

    @FindBy(how = How.CSS,using = "input[value='LOGIN']" )
    public static WebElement loginBtn;
}
