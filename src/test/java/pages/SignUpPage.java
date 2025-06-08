package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

public class SignUpPage {
	
	//private WebDriver driver;

    public SignUpPage() {
    	WebDriver driver = Base.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this); // Initialize elements
    }

    @FindBy(xpath = "//a[normalize-space()='GitHub Privacy Statement']")
    private WebElement gitHubPrivacyStatementLink;
    
    public void verifyGitHubPrivacyStatementLinkExists()
    {
    	Assert.assertTrue(gitHubPrivacyStatementLink.isDisplayed());
    }
    
    public void clickGitHubPrivacyStatementLink()
    {
    	gitHubPrivacyStatementLink.click();
    }

}
