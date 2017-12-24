package ListnersDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListnersDemo.TestNGListners.class)
public class TestCase {
	WebDriver driver;
	
	@Test
	public void GoogleTitleVerified() {
		System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.quit();
	}
	
	@Test
	public void TitleMatch() {
		System.out.println("Test Case2");
		Assert.assertTrue(false);
	}

}
