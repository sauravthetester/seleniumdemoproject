package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

public class LoginPage {

    public LoginPage() {
    	WebDriver driver = Base.getDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(xpath = "//input[@value='Sign in' and @type='submit']")
    private WebElement signInButton;

  
    public void verifySignInButtonDisplayed()
    {
    	Assert.assertTrue(signInButton.isDisplayed());
    }
    
    

}
