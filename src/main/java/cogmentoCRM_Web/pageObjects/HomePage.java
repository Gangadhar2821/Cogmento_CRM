package cogmentoCRM_Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import cogmentoCRM_Web.baseUtils.Application_Utils;

public class HomePage extends Application_Utils {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='user-display']")
	private WebElement logo_Username;

	@FindBy(xpath = "//i[@class='home icon']")
	private WebElement icon_Home;

	@FindBy(xpath = "//i[@class='users icon']")
	private WebElement icon_Contacts;

	@FindBy(xpath = "//i[@class='users icon']/parent::a/following-sibling::button")
	private WebElement icon_AddContacts;

	@FindBy(xpath = "//i[@class='settings icon' ]/parent::div")
	private WebElement icon_Settings;

	@FindBy(xpath = "//a[@role='option']/span[contains(text(),'Out')]")
	private WebElement btn_Logout;

	public WebElement getLogo_Username() {
		return logo_Username;
	}

	public WebElement getIcon_Home() {
		return icon_Home;
	}

	public WebElement getIcon_Contacts() {
		return icon_Contacts;
	}

	public WebElement getIcon_AddContacts() {
		return icon_AddContacts;
	}

	public WebElement getIcon_Settings() {
		return icon_Settings;
	}

	public WebElement getBtn_Logout() {
		return btn_Logout;
	}

	public void click_btnIconsetting() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_Logout)).click();
	}

}
