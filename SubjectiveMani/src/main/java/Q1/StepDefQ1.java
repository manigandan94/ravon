package Q1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefQ1 
{
	static WebDriver driver;
	static String path = System.getProperty("user.dir");
	public static void screenshot(String s)
	{
		try {
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		TakesScreenshot screen =((TakesScreenshot)driver);
		File SrcFile=screen.getScreenshotAs(OutputType.FILE);
		File despath = new File(path+"/Screenshots/"+s+timestamp+".jpg");
		FileUtils.copyFile(SrcFile, despath);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	@Given("^I have url$")
	public void i_have_the_url()  
	{
		   driver = new ChromeDriver();
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	       driver.get("http://demo.guru99.com/test/newtours/register.php");
	       screenshot("Register Page");
	       String s1 = "Register: Mercury Tours";
	   	   String s2 = driver.getTitle();
	   	   Assert.assertEquals(s2, s1);
	   	   System.out.println("Title Validation Successfull");
	    
	}

	@When("^I enter the register (.*?)details(.*?)$")
	public void i_enter_register_details(String s1, String s2)  
	{
		try {
			WebElement w1= 	driver.findElement(By.xpath("//input[@name='firstName']")); 
			w1.sendKeys("Mani");
			String str1 = w1.getAttribute("value");
			System.out.println("Firstname: "+str1);
			WebElement w2= 	driver.findElement(By.xpath("//input[@name='lastName']"));
			w2.sendKeys("Ravon");
			String str2 = w2.getAttribute("value");
			System.out.println("Lastname: "+str2);
			WebElement w3= 	driver.findElement(By.xpath("//input[@name='phone']")); 
			w3.sendKeys("134567890");
			String str3 = w3.getAttribute("value");
			System.out.println("Phone: "+str3);
			WebElement w4= 	driver.findElement(By.xpath("//input[@name='userName']"));
			w4.sendKeys("mani@gmail.com");
			String str4 = w4.getAttribute("value");
			System.out.println("MailID: "+str4);
			WebElement w5= 	driver.findElement(By.xpath("//input[@name='address1']"));   
			w5.sendKeys("123Address");
			String str5 = w5.getAttribute("value");
			System.out.println("Address: "+str5);
			WebElement w6= 	driver.findElement(By.xpath("//input[@name='city']"));
			w6.sendKeys("chennai");
			String str6 = w6.getAttribute("value");
			System.out.println("City: "+str6);
			WebElement w7= 	driver.findElement(By.xpath("//input[@name='state']"));	
			w7.sendKeys("Tamilnadu");
			String str7 = w7.getAttribute("value");
			System.out.println("State: "+str7);
			WebElement w8= 	driver.findElement(By.xpath("//input[@name='postalCode']"));
			w8.sendKeys("600623");
			String str8 = w8.getAttribute("value");
			System.out.println("Postcode: "+str8);
			Select country = new Select(driver.findElement(By.name("country")));
			country.selectByValue("AUSTRALIA");	
			
			WebElement w9= 	driver.findElement(By.xpath("//input[@name='email']"));
			w9.sendKeys("maniravon");
			String str9 = w9.getAttribute("value");
			System.out.println("username: "+str9);
			WebElement w10= 	driver.findElement(By.xpath("//input[@name='password']"));
			w10.sendKeys(s1);
			String str10 = w10.getAttribute("value");
			System.out.println("Password: "+str10); 
			WebElement w11= 	driver.findElement(By.xpath("//input[@name='confirmPassword']"));
			w11.sendKeys(s2);
			String str11 = w11.getAttribute("value");
			System.out.println("ConfirmPassword: "+str11);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	}

	@When("^I click the submit button$")
	public void i_click_submit_button() throws Exception  
	{
		try {
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	    
	}

	@Then("^I able to see the successpage(.*?)$")
	public void i_able_to_see_successpage(String s1)  
	{
		try {
			if(s1.equals("success"))
			{
			screenshot("Success Page");
			String success1 = driver.findElement(By.xpath("(//font/b)[2]")).getText();
			System.out.println(success1);
			String str = "maniravon";
			Assert.assertTrue(success1.contains(str));
	
			System.out.println("Registeration Successfull");
			}
			if(s1.equals("failed"))
			{
				screenshot("Error Page");
				String message = driver.findElement(By.xpath("//span")).getText();
				System.out.println(message);
				String str = "not match";
				Assert.assertTrue(message.contains(str));
				System.out.println("Registeration Failed");
				
			}
				
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}	
		driver.quit();
	}
}
