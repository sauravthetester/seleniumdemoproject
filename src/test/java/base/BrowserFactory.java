package base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.events.EventFiringDecorator;

import listener.DriverListener;
import util.Browser;
import util.ReadProperty;

public class BrowserFactory {

	public static WebDriver getBrowser(Browser browser) {
		
		WebDriver driver = null;
		Properties prop = null;
		try {
			prop = ReadProperty.readPropertiesFile(ReadProperty.configFile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String env = prop.getProperty("env");

		switch (browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--incognito");
				chromeOptions.addArguments("--window-size=1440,850");
				if(env.equals("local"))
				{
					driver = new ChromeDriver(chromeOptions);
				}
				else if(env.equals("remote"))
				{
					try {
						driver = new RemoteWebDriver(new URL("http://172.203.230.74:4444/wd/hub"), chromeOptions);
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(300));
				break;
			default: 
				throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
		WebDriverListener listener = new DriverListener();
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listener);
		WebDriver decoratedDriver = decorator.decorate(driver);
		return decoratedDriver;
	}
	
}
