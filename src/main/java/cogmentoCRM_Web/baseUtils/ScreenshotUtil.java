package cogmentoCRM_Web.baseUtils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

public class ScreenshotUtil {

	public static void pageScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshots/img.png"));

	}

	public static void captureScreenshot(WebDriver driver, String testName) {
		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment(testName + " - Screenshot", new ByteArrayInputStream(screenshot));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
