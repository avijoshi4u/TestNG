package Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaptureErrorUsingGetAttribute {
	
WebDriver driver;
	
    @Test
	public void CaptureError() {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			driver.findElement(By.xpath("//SPAN[@class='RveJvd snByac'][text()='Next']")).click();
			Thread.sleep(2000);
			String actualError = driver.findElement(By.xpath("//DIV[@jsname='B34EJ'][text()='Enter an email or phone number']")).getAttribute("innerHTML");
			String ExpectedError = "Enter an email or phone number";
			
			//Type1
			Assert.assertEquals(actualError, ExpectedError, "Error Message is not as expected");
			
			//Type2
			Assert.assertTrue(actualError.contains("Enter an email"));
			
			System.out.println("Test Completed");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
