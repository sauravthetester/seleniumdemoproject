package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Sign in' and @type='submit']")
    @CacheLookup
    private WebElement signInButton;
    
    
    
  
    public void verifySignInButtonDisplayed()
    {
    	Assert.assertTrue(signInButton.isDisplayed());
    }
    
    

}
