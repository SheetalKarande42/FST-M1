package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

public class ProjectActivity7 extends BaseClass{
    @BeforeTest
    public void setUp(){
       login();
    }
    @Test
    public void verifyQualificationAdd() throws InterruptedException {
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[6]")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[9]")).click();
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addWorkExperience")));
        //add
        driver.findElement(By.id("addWorkExperience")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("experience_employer")));
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test");
        driver.findElement(By.id("btnWorkExpSave")).click();
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
