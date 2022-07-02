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

public class ProjectActivity2 {
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
        options.setAppPackage("com.oneplus.note");
        options.setAppActivity(".ui.MainActivity");
        options.noReset();
        //server url
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        //drive initialization
        driver=new AndroidDriver(serverUrl,options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    //test method
    @Test
    public void GoogleNotes(){
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.oneplus.note:id/add_note_btn"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.oneplus.note:id/title_edit"))).sendKeys("Test");
        driver.findElement(AppiumBy.id("com.oneplus.note:id/note_content")).sendKeys("TestActivity2");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.oneplus.note:id/menu_save"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Navigate up"))).click();

        String savedNote=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.oneplus.note:id/tv_title"))).getText();
        Assert.assertEquals("Test",savedNote);


    }

    //tear down method
    @AfterClass
    public void tear_down(){
        driver.quit();
    }
    }
