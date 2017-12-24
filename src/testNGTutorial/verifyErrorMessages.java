package testNGTutorial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifyErrorMessages {
	
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://opensource.demo.orangehrmlive.com/");
	}
	
	@Test
	public void verifyTitle() {
		try {
			String myTitle = driver.getTitle();
			System.out.println("Title is: "+ myTitle);
			
			String expectedTitle= "OrangeHRM";
			
			Assert.assertEquals(myTitle, expectedTitle);	
			
			System.out.println("Test Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void verifyError() {
		try {
			driver.findElement(By.xpath("//INPUT[@id='btnLogin']")).click();
			//String actualError = driver.findElement(By.xpath("//SPAN[@id='spanMessage']")).getText();
			String actualError = driver.findElement(By.xpath("//SPAN[@id='spanMessage']")).getAttribute("innerHTML");
			String expectedError = "Username cannot be empty";
			
			//Type1
			Assert.assertEquals(actualError, expectedError);
			
			//Type2
			//Assert.assertTrue(actualError.contains("cannot be empty"));
			
			System.out.println("Actual Error Message is "+ actualError);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
