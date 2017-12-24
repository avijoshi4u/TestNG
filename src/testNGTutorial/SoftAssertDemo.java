package testNGTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
	
	@Test
	public void softAssertion() {
		
		SoftAssert assertion = new SoftAssert();
		System.out.println("Test 'softAssertion' started");
		assertion.assertEquals(12, 13);
		System.out.println("Test 'softAssertion' completed");
		assertion.assertAll();	
	}
	
	@Test
	public void hardAssertion() {
		
		System.out.println("Test 'hardAssertion' started");
		Assert.assertEquals(12, 13);
		System.out.println("Test 'hardAssertion' completed");
	}

}
