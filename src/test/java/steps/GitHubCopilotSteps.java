package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CopilotPage;
import pages.HomePage;
import pages.LoginPage;
import util.Browser;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.Base;
import base.BrowserFactory;

public class GitHubCopilotSteps{

	public WebDriver driver = null;
	public static HomePage homePage = null;
	public static CopilotPage copilotPage = null;
	public static LoginPage loginPage = null;
	
	@Before
	public void before() {
		driver = BrowserFactory.getBrowser(Browser.CHROME);
	}
	
	@After
	public static void after_all() {
		BrowserFactory.closeAllDriver();
	}
	
	@Given("Go to Github")
	public void go_to_github() {
		homePage = new HomePage(driver);
	}
	
	@Given("Click on Try Github Copilot")
	public void click_on_try_github_copilot() {
	    homePage.clickOnTryGithubCopilot();
	    copilotPage = new CopilotPage(driver);
	}
	
	@Then("Verify Get started for free option available")
	public void verify_get_started_for_free_option_available() {
		copilotPage.verifyGetStartedForFreeDisplayed();
	}

	@Then("Verify See plans and pricing option available")
	public void verify_see_plans_and_pricing_option_available() {
		copilotPage.verifySeePlansAndPricingDisplayed();
	}

	@Then("Click on Get started")
	public void click_on_get_started() {
		copilotPage.clickOnGetStartedForFree();
		loginPage = new LoginPage(driver);	
	}

	@Then("Click on Sign In")
	public void click_on_sign_in() {
		copilotPage.clickOnSignIn();
		loginPage = new LoginPage(driver);	
	}
	
	@Then("Verify Sign In button available")
	public void verify_sign_in_button_available() {
		loginPage.verifySignInButtonDisplayed();
	}

}
