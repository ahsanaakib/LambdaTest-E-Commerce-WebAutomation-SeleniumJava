package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// ***** Locators *****
	
	private By myAccountLink = By.xpath("//a[@role='button']//span[@class='title'][normalize-space()='My account']");

	// ***** Actions *****
	
	public void clickMyAccount()
	{
		driver.findElement(myAccountLink).click();
	}
}
