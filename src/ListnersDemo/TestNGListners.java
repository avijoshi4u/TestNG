package ListnersDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("TestCase started and TestCase details are: "+ result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase passed and TestCase details are: "+ result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("TestCase failed and TestCase details are: "+ result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCase skipped and TestCase details are: "+ result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	@Override
	public void onStart(ITestContext context) {

		
	}

	@Override
	public void onFinish(ITestContext context) {

		
	}

}
