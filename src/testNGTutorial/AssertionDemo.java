package testNGTutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionDemo {
	
	@Test
	public void AssertTest1() {
		Assert.assertEquals(12, 13);
		
	}
	
	@Test
	public void AssertTest2() {
		Assert.assertEquals(12, 12, "Count doesnot match, please raise a defect");
		
	}
	
	@Test
	public void AssertTest3() {
		Assert.assertEquals(12, 13, "Count doesnot match, please raise a defect");
		
	}

	@Test
	public void AssertTest4() {
		Assert.assertTrue(true, "Test4 failed");
		
	}
	
	@Test
	public void AssertTest5() {
		Assert.assertTrue(false, "Test5 failed");
		
	}

}
