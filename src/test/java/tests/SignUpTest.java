package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Test;
import base.Base;
import listener.RetryAnalyzer;
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

	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyGitHubPrivacyStatementLink()
	{
		homePage = new HomePage();
		homePage.clickOnSignUpForGithub();
		signUpPage = new SignUpPage();
		signUpPage.verifyGitHubPrivacyStatementLinkExists();
	}

}
