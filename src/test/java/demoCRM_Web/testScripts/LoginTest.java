package demoCRM_Web.testScripts;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cogmentoCRM_Web.baseUtils.GlobalVariables;
import cogmentoCRM_Web.baseUtils.Log;
import cogmentoCRM_Web.dataUtils.ConfigReader;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginTest extends GlobalVariables {

	@BeforeMethod
	@Description("Login")
	@Severity(SeverityLevel.BLOCKER)
	public void login() {
		String username = ConfigReader.get("username");
		String password = ConfigReader.get("password");
		Log.info("Logging into the Application...");
		loginPage.enterEmail(username);
		Log.info("Entered EmailId");
		loginPage.enterPassword(password);
		Log.info("Entered Password");
		loginPage.clickLogin();
		Log.info("Clicked on Login button");

	}

	@Test
	@Description("Validating Login")
	@Severity(SeverityLevel.MINOR)
	public void validateLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(homePage.getLogo_Username()));
		Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "❌ Login failed - UserName Logo is not Displayed");

	}
}
