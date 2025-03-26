package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }

    @FindBy(xpath = "//div[@class='CtaForm']//a")
    @CacheLookup
    private WebElement tryGithubCopilot;
    
    public void clickOnTryGithubCopilot()
    {
    	tryGithubCopilot.click();
    }

}
