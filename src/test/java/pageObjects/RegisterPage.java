package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// ***** Locators *****

	private By firstNameInput = By.id("input-firstname");
	private By lastNameInput = By.id("input-lastname");
	private By emailInput = By.id("input-email");
	private By telephoneInput = By.id("input-telephone");
	private By passwordInput = By.id("input-password");
	private By confirmPasswordInput = By.id("input-confirm");
	private By agreeCheckbox = By.xpath("//label[@for='input-agree']");
	private By continueButton = By.xpath("//input[@value='Continue']");

	// ***** Actions *****

	public void enterFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}

	public void enterEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
	}

	public void enterTelephone(String phone) {
		driver.findElement(telephoneInput).sendKeys(phone);
	}

	public void enterPassword(String pwd) {
		driver.findElement(passwordInput).sendKeys(pwd);
	}

	public void enterConfirmPassword(String pwd) {
		driver.findElement(confirmPasswordInput).sendKeys(pwd);
	}

	public void agreeToTerms() {
		driver.findElement(agreeCheckbox).click();
	}

	public void clickContinueButton() {
		driver.findElement(continueButton).click();
	}
}
