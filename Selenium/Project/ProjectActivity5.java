package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class ProjectActivity5 extends BaseClass {

    @BeforeTest
    public void setUp(){
       login();
    }
    @Test
    public void verifyEditInfo() throws InterruptedException {
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[6]")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]")).click();
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave")));
        driver.findElement(By.id("btnSave")).click();//editbtn
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal_txtEmpFirstName")));
        driver.findElement(By.id("personal_txtEmpFirstName")).clear();
        driver.findElement(By.id("personal_txtEmpFirstName")).sendKeys("Sheetal");
        driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("emplastname1");
        Select select=new Select(driver.findElement(By.id("personal_cmbNation")));
        select.selectByVisibleText("Indian");
        //save
        driver.findElement(By.id("btnSave")).click();
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
