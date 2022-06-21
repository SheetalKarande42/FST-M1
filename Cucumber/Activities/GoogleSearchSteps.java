package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleSearchSteps extends BaseClass {
    @Given("^User is on Google Home Page$")
    public void givenFunctionName() {
        driver.get("https://www.google.com/");
    }

    @When("^User types in Cheese and hits ENTER$")
    public void whenFunctionName() {
        driver.findElement(By.name("q")).sendKeys("cheese");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("^Show how many search results were shown$")
    public void thenFunctionName() {

        WebElement noOfelements=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"result-stats\"]")));
        System.out.println("noOfelements-"+noOfelements.getText());
    }

    @And("^Close the browser$")
    public void closeBrowser(){
        driver.quit();
    }
}
