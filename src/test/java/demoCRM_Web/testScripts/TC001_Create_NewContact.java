package demoCRM_Web.testScripts;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import cogmentoCRM_Web.baseUtils.Log;
import cogmentoCRM_Web.baseUtils.TestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TC001_Create_NewContact extends TestBase {

	@Test(dataProvider = "ExcelTestData", dataProviderClass = cogmentoCRM_Web.dataUtils.ExcelUtility.class)
	@Description("Creates a New Contact")
	@Severity(SeverityLevel.CRITICAL)
	public void createNewContact(Map<String, String> data) {
		Log.info("**********Begining of TC001_Create_NewCustomer**********");
		homePage.getIcon_Contacts().click();
		homePage.getIcon_AddContacts().click();
		contactsPage.clickBtnCreateContact();
		createNewContactpage.enterTxt_FirstName(data.get("FirstName"));
		createNewContactpage.enterTxt_LastName(data.get("LastName"));
		createNewContactpage.selectList_Category(data.get("Option"));
		createNewContactpage.enterTxt_Number(data.get("Number"));
		createNewContactpage.clickBtn_Save();
		Log.info("**********End of TC001_Create_NewCustomer**********");

	}
}
