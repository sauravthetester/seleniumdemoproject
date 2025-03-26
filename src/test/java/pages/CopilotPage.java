package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CopilotPage {
	
	private WebDriver driver;

    public CopilotPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='lp-Hero-ctaButtons']//a[contains(@data-analytics-event,'start_free')]")
    @CacheLookup
    private WebElement getStartedForFree;
    
    @FindBy(xpath = "//div[@class='lp-Hero-ctaButtons']//a[contains(@data-analytics-event,'see_plans')]")
    @CacheLookup
    private WebElement seePlansAndPricing;
    
    @FindBy(xpath = "(//a[contains(@data-analytics-event,'Sign in')])[2]")
    @CacheLookup
    private WebElement signInOption;
    
  
    public void clickOnSignIn()
    {
    	new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(signInOption));
    	signInOption.click();
    }
    
    public void clickOnGetStartedForFree()
    {
    	getStartedForFree.click();
    }
    
    public void verifyGetStartedForFreeDisplayed()
    {
    	new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(getStartedForFree));
    	Assert.assertTrue(getStartedForFree.isDisplayed());
    }
    
    public void verifySeePlansAndPricingDisplayed()
    {
    	new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(seePlansAndPricing));
    	Assert.assertTrue(seePlansAndPricing.isDisplayed());
    }
    
    public void verifySignInOptionDisplayed()
    {
    	new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(signInOption));
    	Assert.assertTrue(signInOption.isDisplayed());
    }

}
