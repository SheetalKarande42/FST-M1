package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity8 extends BaseClass{
    @BeforeTest
    public void setUp(){
        login();
    }
    @Test
    public void verifyLeaveApply() throws InterruptedException {
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/span")));
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/div/div/div/fieldset/div/div/table/tbody/tr/td[4]/div/a/span")).click();
        Thread.sleep(200);
       Select select =new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
       select.selectByVisibleText("DayOff");
       driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2022-06-20");
        driver.findElement(By.id("applyBtn")).click();
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[6]/a")));
        String leavestatus=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[6]/a")).getText();
        System.out.println("leavestatus-"+leavestatus);
        Assert.assertTrue(leavestatus.contains("Cancelled"));
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
