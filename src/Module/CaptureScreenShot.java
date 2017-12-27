package Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Library.Utility;

public class CaptureScreenShot {
	
	WebDriver driver;
	
	 	@Test
		public void screenshot() {
			try {
				System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				driver.get("http://opensource.demo.orangehrmlive.com/");
				
				driver.findElement(By.xpath("//INPUT[@id='txtUsername']")).sendKeys("Admin");
				driver.findElement(By.xpath("//INPUT[@id='txtPassword']")).sendKeys("admin");
				Utility.CaptureScreenShot(driver, "BrowserStarted");
				
				driver.findElement(By.xpath("//INPUT[@id='btnLogin']")).click();
				
				Utility.CaptureScreenShot(driver, "LoggedinScreenshot");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	 	
	 	@AfterMethod
		public void tearDown(ITestResult result) {

			if(ITestResult.FAILURE==result.getStatus()) {
				Utility.CaptureScreenShot(driver, "failureScreenshot");
			}
		}

}
