package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new FirefoxDriver();

        driver.get("https://www.training-support.net");

    }

    @Test
    public void homepageTest(){
       String pageTitle1= driver.getTitle();
        Assert.assertEquals(pageTitle1,"Training Support");
        driver.findElement(By.id("about-link")).click();

        String pageTitle=driver.getTitle();
        System.out.println("pageTitle- "+pageTitle);
        Assert.assertEquals(pageTitle,"About Training Support");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
