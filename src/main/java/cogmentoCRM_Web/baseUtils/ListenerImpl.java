package cogmentoCRM_Web.baseUtils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpl implements ITestListener {
	@Override
	public void onTestFailure(ITestResult result) {
		Log.info("Started Listner...");
		Object testClass = result.getInstance();
		WebDriver driver = ((TestBase) testClass).getDriver();
		if (driver instanceof WebDriver) {
			CogmentoCRM_AppUtils.failureScreenshot(driver, result.getName());

		}
	}
}
