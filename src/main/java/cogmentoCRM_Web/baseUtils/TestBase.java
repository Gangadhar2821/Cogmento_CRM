package cogmentoCRM_Web.baseUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cogmentoCRM_Web.dataUtils.ConfigReader;

public class TestBase {

	protected static WebDriver driver;

	private enum BrowserType {
		CHROME, FIREFOX, EDGE
	}

	@BeforeClass
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
		PageInitializer.intializePages();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}
