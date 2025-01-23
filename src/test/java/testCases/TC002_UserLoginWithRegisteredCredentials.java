package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.CredentialsStore;

public class TC002_UserLoginWithRegisteredCredentials extends BaseClass {

	@Test(groups = { "master" }, dependsOnMethods = {
			"testCases.TC001_UserRegistrationWithValidData.verify_UserRegistrationWithValidData" })
	public void verify_UserLoginWithRegisteredCredentials() {

		String email = CredentialsStore.registeredEmail;
		String password = CredentialsStore.registeredPassword;
		
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();

		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(email, password);
		logger.info("Logging in with email: " + email + ", password: " + password);

		String expectedPageTitle = "My Account";
		String actualPageTitle = driver.getTitle();
		logger.info("Expected Page Title: " + expectedPageTitle + ", Actual Page Title: " + actualPageTitle);

		if (!actualPageTitle.equals(expectedPageTitle)) {
			logger.error("Login failed. Current URL: " + driver.getCurrentUrl());
			logger.error("Page Source: " + driver.getPageSource());
		}

		Assert.assertEquals(actualPageTitle, expectedPageTitle, 
				"Login failed - Incorrect page title.");

	}
}
