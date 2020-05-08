package Q3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDefQ3     
{
	static WebDriver driver;
	
	@Given("^I have Url$")
	public void i_have_url() 
	{
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://demo.guru99.com/test/newtours/login.php");
	}

	@When("^I enter the credentail$")
	public void i_enter_the_credentails() 
    {
	    driver.findElement(By.name("userName")).sendKeys("maniravon");
	    driver.findElement(By.name("password")).sendKeys("12345");
	}

	@When("^I click loginbutton$")
	public void i_click_login_button() 
    {
	    driver.findElement(By.name("submit")).click();
	}

	@Then("^I able see the homepage$")
	public void i_able_the_homepage() throws Exception 
    {
		Thread.sleep(2000);
	    String s1 = driver.findElement(By.xpath("//h3")).getText();
	    System.out.println(s1);
	    String s2 = "Login Successfully";
	    Assert.assertEquals(s2,s1);
	    System.out.println("Homepage loaded successfully");
	    driver.quit();
	    
	}
}
