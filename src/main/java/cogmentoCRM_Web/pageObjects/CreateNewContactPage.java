package cogmentoCRM_Web.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cogmentoCRM_Web.baseUtils.Application_Utils;

public class CreateNewContactPage extends Application_Utils {
	protected WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='first_name']")
	private WebElement txt_FirstName;

	@FindBy(xpath = "//input[@name='last_name']")
	private WebElement txt_LastName;

	@FindBy(xpath = "//div[@role='listbox' and @name='category']")
	private WebElement list_Category;

	@FindBy(xpath = "//input[@placeholder='Number']")
	private WebElement txt_Number;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	private WebElement btn_Save;

	public void enterTxt_FirstName(String firstname) {
		txt_FirstName.sendKeys(firstname);
	}

	public void enterTxt_LastName(String lastname) {
		txt_LastName.sendKeys(lastname);
	}

	public void selectList_Category(String option) {
		list_Category.click();
		List<WebElement> options = list_Category
				.findElements(By.xpath(".//div[@role='option' and @name='category']/span"));
		for (WebElement ele : options) {
			String opt = ele.getText().trim();
			if (opt.equals(option)) {
				ele.click();
			}
		}

	}

	public void enterTxt_Number(String number) {
		txt_Number.sendKeys(number);
	}

	public void clickBtn_Save() {
		btn_Save.click();
	}

	public WebElement getFirstName() {
		return txt_FirstName;

	}

}
