package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;
import testBase.BaseClass;
import utilities.CredentialsStore;

public class TC001_UserRegistrationWithValidData extends BaseClass {

	@Test(groups = { "master" })
	public void verify_UserRegistrationWithValidData() {
		Faker faker = new Faker();

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();

		LoginPage loginPage= new LoginPage(driver);
		loginPage.clickRegisterLink();

		RegisterPage regPage = new RegisterPage(driver);

		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		String phone = faker.phoneNumber().cellPhone();
		String password = faker.internet().password(8, 15, true, true, true);

		CredentialsStore.registeredEmail = email;
		CredentialsStore.registeredPassword = password;

		regPage.enterFirstName(firstName);
		regPage.enterLastName(lastName);
		regPage.enterEmail(email);
		regPage.enterTelephone(phone);
		regPage.enterPassword(password);
		regPage.enterConfirmPassword(password);
		regPage.agreeToTerms();
		regPage.clickContinueButton();

		logger.info("User Details - FirstName: " + firstName + ", LastName: " + lastName + ", Email: " + email
				+ ", Password: " + password);

		AccountSuccessPage accSuccPage = new AccountSuccessPage(driver);

		// Validate success message
		String expectedMessage = "Your Account Has Been Created!";
		String actualMessage = accSuccPage.getSuccessMessage();
		
		logger.info("Success message displayed: " + actualMessage);

		Assert.assertEquals(actualMessage, expectedMessage, 
				"Account registration failed!");

	}
}
