package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

public class CopilotPage {
	
    public CopilotPage() {
    	WebDriver driver = Base.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(xpath = "//div[@class='lp-Hero-ctaButtons']//a[contains(@data-analytics-event,'start_free')]")
    @CacheLookup
    private WebElement getStartedForFree;
    
    @FindBy(xpath = "//div[@class='lp-Hero-ctaButtons']//a[contains(@data-analytics-event,'see_plans')]")
    @CacheLookup
    private WebElement seePlansAndPricing;
    
    @FindBy(xpath = "//span[text()='Try GitHub Copilot Pro']/../parent::button")
    @CacheLookup
    private WebElement tryGitHubCopilotPro;
    
    @FindBy(xpath = "//a[contains(@data-analytics-event,'click to go to homepage') and normalize-space()='Sign in']/..")
    @CacheLookup
    private WebElement signInOption;
    
  
    public void clickOnSignIn()
    {
    	signInOption.click();
    }
    
    public void clickOnTryGitHubCopilotPro()
    {
    	tryGitHubCopilotPro.click();
    }
    
    public void clickOnGetStartedForFree()
    {
    	getStartedForFree.click();
    }
    
    public void verifyGetStartedForFreeDisplayed()
    {
    	Assert.assertTrue(getStartedForFree.isDisplayed());
    }
    
    public void verifySeePlansAndPricingDisplayed()
    {
    	Assert.assertTrue(seePlansAndPricing.isDisplayed());
    }
    
    public void verifySignInOptionDisplayed()
    {
    	Assert.assertTrue(signInOption.isDisplayed());
    }

}
