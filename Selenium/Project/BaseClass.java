package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    static WebDriver driver=new FirefoxDriver();

    static WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

    public void login(){
      //  driver=new FirefoxDriver();
       // wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLogo")));
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }
    public void closeBrowser(){
        driver.quit();
    }
}
