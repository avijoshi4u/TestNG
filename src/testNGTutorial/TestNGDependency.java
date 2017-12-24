package testNGTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDependency {

	@Test
	public void startApp() {
		System.out.println("Starting Application");
	}
	
	@Test(dependsOnMethods="startApp")
	public void loginApp() {
		System.out.println("Login to Application");
		Assert.assertEquals(12, 13);
	}
	
	@Test(dependsOnMethods= {"loginApp","startApp"})
	public void logoutApp() {
		System.out.println("Logging out of the Application");
	}
	
	
}
