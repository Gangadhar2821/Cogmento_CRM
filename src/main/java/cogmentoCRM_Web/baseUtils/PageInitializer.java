package cogmentoCRM_Web.baseUtils;

import org.testng.annotations.BeforeTest;

import cogmentoCRM_Web.pageObjects.HomePage;
import cogmentoCRM_Web.pageObjects.LoginPage;

public class PageInitializer extends GlobalVariables {

	@BeforeTest
	public static void intializePages() {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);

	} 

}
