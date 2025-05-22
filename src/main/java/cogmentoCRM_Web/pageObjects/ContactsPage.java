package cogmentoCRM_Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cogmentoCRM_Web.baseUtils.Application_Utils;

public class ContactsPage extends Application_Utils {
	protected WebDriver driver;

	public ContactsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[@class='ui linkedin button' and contains(text(),'Create')]")
	private WebElement btn_createContact;

	public WebElement getBtn_createContact() {
		return btn_createContact;
	}

	public void clickBtnCreateContact() {
	}
}
