package testNGTutorial;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestNGDependencyExample {
	
	WebDriver driver;
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		System.out.println("==========Browser Started==========");
	}
	
	@Test
	public void startApp() {
		try {
			driver.get("http://opensource.demo.orangehrmlive.com/");
			System.out.println("Starting Application");
			Assert.assertTrue(driver.findElement(By.xpath("//SPAN[@class='form-hint'][text()='Username']")).isDisplayed());
			System.out.println("Application Loaded");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Test(dependsOnMethods="startApp")
	public void loginApp() {
		try {
			driver.findElement(By.xpath("//INPUT[@id='txtUsername']")).sendKeys("Admin");
			driver.findElement(By.xpath("//INPUT[@id='txtPassword']")).sendKeys("admin");
			driver.findElement(By.xpath("//INPUT[@id='btnLogin']")).click();
			
			Assert.assertTrue(driver.findElement(By.xpath("//A[@id='welcome']")).isDisplayed());
			
			System.out.println(driver.findElement(By.xpath("//A[@id='welcome']")).isDisplayed());
			System.out.println("Login Successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods="loginApp")
	public void logoutApp() {
		try {
			driver.findElement(By.xpath("//A[@id='welcome']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//A[@href='/index.php/auth/logout'][text()='Logout']")).click();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Assert.assertTrue(driver.findElement(By.xpath("//SPAN[@class='form-hint'][text()='Username']")).isDisplayed());
			System.out.println("Logout Successful");
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("==========Browser Closed==========");	
	}
	
	
}
