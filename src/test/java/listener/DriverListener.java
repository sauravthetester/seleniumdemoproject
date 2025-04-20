package listener;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import base.BrowserFactory;
import util.Browser;

public class DriverListener implements WebDriverListener {
	
	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		
	}
	
	@Override
	public void beforeClick(WebElement element) {
		
		new WebDriverWait(Base.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	@Override
	public void beforeIsDisplayed(WebElement element) {

		new WebDriverWait(Base.getDriver(), Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(element));
		WebDriverListener.super.beforeIsDisplayed(element);
	}

}
