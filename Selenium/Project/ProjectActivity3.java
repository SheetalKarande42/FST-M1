package activities.liveProject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity3 extends BaseClass {
    @BeforeTest
    public void setUp(){
        login();
    }
    @Test
    public void verifyLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
        String home=driver.findElement(By.id("welcome")).getText();
        Assert.assertTrue(home.contains("Welcome"));
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
