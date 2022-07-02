package liveproject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity3 {
    AndroidDriver driver;
    WebDriverWait wait;
    //set up method
    @BeforeClass
    public void setup() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("OnePlus Nord");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();
        //server url
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        //drive initialization
        driver=new AndroidDriver(serverUrl,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.training-support.net/selenium");
    }

    //test method
    @Test
    public void GoogleChrome() {
      String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
// Just scroll
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        // Locate element
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"To-Do List \uF0AE Elements get added at run time\"]"))).click();

        String[] tasks={
                "Add tasks to list",
                "Get number of tasks",
                "Clear the list"

        };
    for(String task: tasks) {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("taskInput"))).click();
        driver.findElement(AppiumBy.id("taskInput")).sendKeys(task);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text="+task+"]")).click();
    }

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\" Clear List\"]")).click();
        for(String task: tasks) {
            Assert.assertFalse(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text="+task+"]")).isDisplayed());
        }
    }

    //tear down method
    @AfterClass
    public void tear_down(){
        driver.quit();
    }
}

