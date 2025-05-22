package cogmentoCRM_Web.baseUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import cogmentoCRM_Web.dataUtils.ConfigReader;
import cogmentoCRM_Web.pageObjects.ContactsPage;
import cogmentoCRM_Web.pageObjects.CreateNewContactPage;
import cogmentoCRM_Web.pageObjects.HomePage;
import cogmentoCRM_Web.pageObjects.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TestBase {

	// variables
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static CreateNewContactPage createNewContactpage;
	protected static ContactsPage contactsPage;

	protected static WebDriver driver;

	private enum BrowserType {
		CHROME, FIREFOX, EDGE
	}

	@BeforeSuite
	public void setup() {
		ConfigReader.loadConfig();
		String url = ConfigReader.get("baseUrl");
		String browser = ConfigReader.get("browser").toUpperCase();
		Log.info("Starting the WebDriver....");

		switch (BrowserType.valueOf(browser)) {
		case CHROME:
			driver = new ChromeDriver();
			Log.info("Launching the Chrome Browser!");
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			Log.info("Launching the Firefox Browser!");
			break;
		case EDGE:
			driver = new EdgeDriver();
			Log.info("Launching the Edge Browser!");
			break;
		default:
			Log.info("Invalid browser: " + browser);
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get(url);
		ObjectsInitializer.intialize();
	}

	@BeforeClass
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
		validateLogin();
	}

	public void validateLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(homePage.getLogo_Username()));
		Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "❌ Login failed - UserName Logo is not Displayed");

	}

	@AfterClass
	@Description("Logout")
	public void logout() {
		Log.info("Logging Out..");
		homePage.getIcon_Settings().click();
		homePage.getBtn_Logout().click();
		Log.info("Successfully LoggedOut");
	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
