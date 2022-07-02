package liveproject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ProjectActivity1 {
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();
        //server url
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        //drive initialization
        driver=new AndroidDriver(serverUrl,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //test method
    @Test
    public void GoogleTasks(){

        String[] tasks={"Complete Activity with Google Tasks",
                "Complete Activity with Google Keep",
                "Complete the second Activity Google Keep"};
        for(String task: tasks) {
            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"))).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title"))).
                    sendKeys(task);

            driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
        }

        String T3=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name"))
                .getText();


        Assert.assertEquals(T3,"Complete the second Activity Google Keep");

        String T2=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name"))
                .getText();


        Assert.assertEquals(T2,"Complete Activity with Google Keep");

        String T1=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/task_name")))
                        .getText();


        Assert.assertEquals(T1,"Complete Activity with Google Tasks");

    }
    //tear down method
    @AfterClass
    public void tear_down(){
        driver.quit();
    }
}
