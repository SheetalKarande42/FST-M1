package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity4 extends BaseClass {

    @BeforeTest
    public void setUp(){
       login();
    }
    @Test
    public void verifyAddemployee() throws InterruptedException {
        Thread.sleep(200);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[2]")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]")).click();
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));
        driver.findElement(By.id("btnAdd")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
        driver.findElement(By.id("firstName")).sendKeys("empname");
        driver.findElement(By.id("lastName")).sendKeys("emplastname");
        driver.findElement(By.id("btnSave")).click();
        //PIM
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName")));
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys("empname");
        driver.findElement(By.id("searchBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[3]/a")));
        String name=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[3]/a")).getText();
        Assert.assertTrue(name.contains("empname"));
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
