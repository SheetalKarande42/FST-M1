package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FirstTest extends BaseClass {
    @Given("^user is on the TS homepage$")
    public void openHomePage(){
        driver.get("https://training-support.net");
        Assert.assertEquals("Training Support",driver.getTitle());
    }

    @When("^user clicks on about us link$")
    public void clickAboutUslink(){
        driver.findElement(By.id("about-link")).click();
    }

    @Then("^they are redirected to About us page$")
    public void redirectedtoAboutus(){
       // String aboutustext=driver.findElement(By.className("ui")).getText();
        Assert.assertTrue(driver.findElement(By.className("ui")).isDisplayed());
    }

    @And("^we verify if they are on the page$")
    public void verifyPage(){
        String aboutustext=driver.findElement(By.className("ui")).getText();
        Assert.assertEquals("About Us",aboutustext);
    }



}
