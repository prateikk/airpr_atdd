package com.airpr.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

    @FindBy(how = How.CSS,using = "input[placeholder='Email']" )
    public static WebElement userName;

    @FindBy(how = How.CSS,using = "input[placeholder='Password']" )
    public static WebElement password;

    @FindBy(how = How.CSS,using = "input[value='LOGIN']" )
    public static WebElement loginBtn;



}
