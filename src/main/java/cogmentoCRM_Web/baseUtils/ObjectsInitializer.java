package cogmentoCRM_Web.baseUtils;

import org.testng.annotations.BeforeTest;

import cogmentoCRM_Web.pageObjects.ContactsPage;
import cogmentoCRM_Web.pageObjects.CreateNewContactPage;
import cogmentoCRM_Web.pageObjects.HomePage;
import cogmentoCRM_Web.pageObjects.LoginPage;

public class ObjectsInitializer extends TestBase {

	@BeforeTest
	public static void intialize() {

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		createNewContactpage = new CreateNewContactPage(driver);
		contactsPage = new ContactsPage(driver);

	}

}
