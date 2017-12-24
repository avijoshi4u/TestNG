/**
 * 
 */
package testNGTutorial;

import org.testng.annotations.Test;

/**
 * @author avi joshi
 *
 */
public class TestNGScript {
	
	@Test(priority=1, description="This test case will verify login functionality")
	public void loginApplication() {
		
		System.out.println("Login to the application");
		
	}
	
	@Test(priority=2, description="This test case will verify certain itmes in the checkout basket")
	public void selectItems() {
		
		System.out.println("Item selected");
		
	}
	
	@Test(priority=-3, description="This test case will verify all the checked out itmes")
	public void checkout() {
		
		System.out.println("Item checked out");
		
	}
}
