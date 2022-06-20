package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity6 extends BaseClass {

    @BeforeTest
    public void setUp(){
        login();
    }
    @Test
    public void verifyDirectorymenu() throws InterruptedException {
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[9]/a/b")));
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/ul/li[9]/a/b")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[9]/a/b")).click();
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")));
        String headerpg=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/h1")).getText();
        System.out.println("headerpg-"+headerpg);
        Assert.assertEquals(headerpg,"Search Directory");
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
