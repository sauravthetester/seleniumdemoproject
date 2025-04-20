package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import base.Base;
import pages.CopilotPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;


public class SignUpTest extends Base{
	
	public WebDriver driver = null;
	public HomePage homePage = null;
	public CopilotPage copilotPage = null;
	public LoginPage loginPage = null;
	public SignUpPage signUpPage = null;
	
	@Test
	public void verifyGitHubPrivacyStatementLink()
	{
		homePage = new HomePage();
		homePage.clickOnSignUpForGithub();
		signUpPage = new SignUpPage();
		signUpPage.verifyGitHubPrivacyStatementLinkExists();
	}

}
