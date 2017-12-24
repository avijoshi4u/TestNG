package testNGTutorial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class isDisplayed {
	
WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://opensource.demo.orangehrmlive.com/");
		System.out.println("==========Browser Started==========");
	}
	
	@Test
	public void displayed() {
		
		try {
			//Assert.assertTrue(driver.findElement(By.id("btnLogin")).isDisplayed());
			boolean status=driver.findElement(By.id("btn")).isDisplayed();
			System.out.println(status);
			Assert.assertTrue(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
