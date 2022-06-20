package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;

public class ProjectActivity2 extends BaseClass{

    @BeforeTest
    public void setUp(){
      driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void verifyHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("divLogo")));
        String header= driver.findElement(By.id("divLogo")).getText();
        System.out.println(header);
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }

}
