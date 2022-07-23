package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("Page title is: "+driver.getTitle());
        //Find the "Get Started!" link and click it
        driver.findElement(By.xpath("/html/body/div/div/div/a")).click();

        //Print title of new page
        System.out.println("Heading is: " + driver.getTitle());
        driver.quit();
    }
}
