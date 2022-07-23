package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("Page title is: "+driver.getTitle());
        //Find the input fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Testfirstname");
        lastName.sendKeys("TestlastName");

        //Enter the email
        driver.findElement(By.id("email")).sendKeys("testemail@example.com");

        //Enter the contact number
        driver.findElement(By.id("number")).sendKeys("9234567890");

        //Click Submit
        driver.findElement(By.cssSelector(".ui.green.button")).click();

        driver.quit();

    }
}
