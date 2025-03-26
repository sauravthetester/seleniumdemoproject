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

import util.Browser;
import util.ReadProperty;

public class BrowserFactory {

	private static Map<Browser, WebDriver> drivers = new HashMap<Browser, WebDriver>();

	public static WebDriver getBrowser(Browser browser) {
		WebDriver driver = null;
		Properties prop = null;
		try {
			prop = ReadProperty.readPropertiesFile("src/test/resources/config/config.properties");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String env = prop.getProperty("env");

		switch (browser) {
			case FIREFOX:
				driver = drivers.get(Browser.FIREFOX);
				if (driver == null) {
					driver = new FirefoxDriver();
					drivers.put(Browser.FIREFOX, driver);
				}
				break;
			case IE:
				driver = drivers.get(Browser.IE);
				if (driver == null) {
					driver = new InternetExplorerDriver();
					drivers.put(Browser.IE, driver);
				}
				break;
			case CHROME:
				driver = drivers.get(Browser.CHROME);
				if (driver == null) {
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--incognito");
					if(env.equals("local"))
						driver = new ChromeDriver(chromeOptions);
					else if(env.equals("remote"))
					{
						try {
							driver = new RemoteWebDriver(new URL("http://172.203.230.74:4444/wd/hub"), chromeOptions);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
					}
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
					driver.get("https://github.com/");	
					drivers.put(Browser.CHROME, driver);
				}
				break;
		}
		return driver;
	}
	
	public static void closeAllDriver() {
		for (Browser key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
			drivers.put(key, null);
		}
	}
}
