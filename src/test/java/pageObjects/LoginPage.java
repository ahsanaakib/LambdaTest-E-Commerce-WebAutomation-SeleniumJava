package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// ***** Locators *****

	private By regLink = By.linkText("Register");

	private By emailInput = By.id("input-email");
	private By passwordInput = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");

	// ***** Actions *****

	public void clickRegisterLink() {
		driver.findElement(regLink).click();
	}

	public void inputEmail(String email) {
		driver.findElement(emailInput).sendKeys(email);
	}

	public void inputPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void login(String email, String password) {
		inputEmail(email);
		inputPassword(password);
		clickLoginButton();
	}
}
