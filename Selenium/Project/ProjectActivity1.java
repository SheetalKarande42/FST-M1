package activities.liveProject;

import org.testng.Assert;
import org.testng.annotations.*;

public class ProjectActivity1 extends BaseClass{

    @BeforeTest
    public void setUp(){
       driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void verifyTitle() throws InterruptedException {
        Thread.sleep(20);
        String pageTitle=driver.getTitle();
        Assert.assertEquals(pageTitle,"OrangeHRM");
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }

}
