package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CopilotPage;
import pages.HomePage;
import pages.LoginPage;
import util.Browser;
import util.ReadProperty;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.Base;
import base.BrowserFactory;
import org.openqa.selenium.OutputType;

public class GitHubCopilotSteps{
	public HomePage homePage = null;
	public CopilotPage copilotPage = null;
	public LoginPage loginPage = null;
	
	@Before
	public void before() throws IOException {
		Base.setDriver();
		Base.getDriver().get(ReadProperty.readPropertiesFile(ReadProperty.configFile).getProperty("url"));
		System.out.println("Browser setup by Thread : " + Thread.currentThread().getId() + " and Driver reference is : "
	               + Base.getDriver());
	}
	
	@After
	public void after_all(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) Base.getDriver();
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
			ChainTestListener.embed(src, "image/png");
		}
		System.out.println("Browser closed by Thread : " + Thread.currentThread().getId()
	               + " and Closing driver reference is :" + Base.getDriver());
		Base.closeBrowser();	
	}
	
	@Given("Go to Github")
	public void go_to_github() {
		homePage = new HomePage();
	}
	
	@Given("Click on Try Github Copilot")
	public void click_on_try_github_copilot() {
	    homePage.clickOnTryGithubCopilot();
	    copilotPage = new CopilotPage();
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
		loginPage = new LoginPage();	
	}

	@Then("Click on Sign In")
	public void click_on_sign_in() {
		copilotPage.clickOnSignIn();
		loginPage = new LoginPage();	
	}
	
	@Then("Verify Sign In button available")
	public void verify_sign_in_button_available() {
		loginPage.verifySignInButtonDisplayed();
	}

}
