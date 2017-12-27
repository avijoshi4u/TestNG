package Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollPage {
	
	WebDriver driver;
	
	@Test
	public void scrollDown() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://birlainstitute.co.in/");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("scroll(0,2000)");
			
			driver.findElement(By.xpath("//A[@href='http://birlainstitute.co.in/admission/'][text()='Admissions']")).click();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
