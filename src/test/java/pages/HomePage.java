package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

public class HomePage {

    public HomePage() {
    	WebDriver driver = Base.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this); // Initialize elements
    }

    @FindBy(xpath = "//div[@class='CtaForm']//a")
    @CacheLookup
    private WebElement tryGithubCopilot;
    
    @FindBy(xpath = "//button//*[contains(text(),'Sign up for GitHub')]")
    @CacheLookup
    private WebElement signUpForGithub;
    
  
    
    public void clickOnTryGithubCopilot()
    {
    	tryGithubCopilot.click();
    }
    
    public void clickOnSignUpForGithub()
    {
    	signUpForGithub.click();
    }

}
