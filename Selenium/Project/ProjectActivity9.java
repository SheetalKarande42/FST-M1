package activities.liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ProjectActivity9 extends BaseClass{
    @BeforeTest
    public void setUp(){
        login();
    }
    @Test
    public void verifyEmergency() throws InterruptedException {
        Thread.sleep(200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/ul/li[6]")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[6]")).click();
        Thread.sleep(200);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")));
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" /html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[1]/td[2]/a")));
      //  String name1=driver.findElement(By.xpath(" /html/body/div[1]/div[3]/div/div[3]/div[2]/form/table/tbody/tr[1]/td[2]/a")).getText();

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tr"));

    // And iterate over them and get all the cells
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Print the contents of each cell
            for (WebElement cell : cells) {

                System.out.println(cell.getText());

            }
        }
    }
    @AfterTest
    public void tearDown(){
        closeBrowser();
    }
}
