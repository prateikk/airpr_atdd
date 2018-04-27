import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class Test {

    WebDriver driver;

    public void setUp(){

        Ocular.config()
                .resultPath(Paths.get("/result"))
                .snapshotPath(Paths.get("/snapshot"))
                .globalSimilarity(95)
                .saveSnapshot(true);


        System.setProperty("webdriver.chrome.driver","/home/velotio/Downloads/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
@org.testng.annotations.Test
    public void firstTest(){
    driver.get("http://analyst.airpr.com");
    driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("pushkar.deshpande@velotio.com");
    driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("pushkar123");
    driver.findElement(By.cssSelector("input[value='LOGIN']")).click();

    Assert.assertTrue(driver.getTitle().equals("Dashboard - AirPR Analyst"));


}

    @AfterTest
    public void tearDown(){
//        driver.close();
//        driver.quit();

        System.out.println("END");
    }
}
