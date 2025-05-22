package cogmentoCRM_Web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cogmentoCRM_Web.baseUtils.Application_Utils;
import cogmentoCRM_Web.baseUtils.TestBase;

public class LoginPage extends Application_Utils {

	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='email']")
	private WebElement txt_EmailId;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement txt_Password;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement btn_Login;

	public void enterEmail(String userName) {
		txt_EmailId.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		txt_Password.sendKeys(passWord);
	}

	public void clickLogin() {
		btn_Login.click();
	}

}
