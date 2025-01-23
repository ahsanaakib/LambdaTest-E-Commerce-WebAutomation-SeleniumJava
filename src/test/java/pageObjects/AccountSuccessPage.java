package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountSuccessPage extends BasePage{

	public AccountSuccessPage(WebDriver driver) {
		super(driver); 
	}
	
	// ***** Locators *****

	private By accSuccessMessage= By.xpath("//h1[@class='page-title my-3']");
	
	// ***** Actions *****
	
	public String getSuccessMessage()
	{
		return driver.findElement(accSuccessMessage).getText();
	}
}
