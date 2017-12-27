package Library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void CaptureScreenShot(WebDriver driver, String ScreenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/"+ScreenshotName+".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception observed while taking a screenshot "+e.getMessage());
		}
	}
	
	

}
