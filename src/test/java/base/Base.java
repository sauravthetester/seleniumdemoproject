package base;

import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

import util.Browser;
import util.ReadProperty;

@Listeners(ChainTestListener.class)
public class Base {
	
		private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
		
		@BeforeMethod
		public static void setDriver() throws IOException
		{
			WebDriver myDriver = BrowserFactory.getBrowser(Browser.CHROME);
			driver.set(myDriver);
			driver.get().get(ReadProperty.readPropertiesFile(ReadProperty.configFile).getProperty("url"));
			System.out.println("Browser setup by Thread : " + Thread.currentThread().getId() + " and Driver reference is : "
	               + getDriver());
		}
	
		@AfterMethod
		public static void tearDown(ITestResult result) {
	       System.out.println("Browser closed by Thread : " + Thread.currentThread().getId()
	               + " and Closing driver reference is :" + getDriver());
	       if(!result.isSuccess())
	       {
	    	   TakesScreenshot ts = (TakesScreenshot) Base.getDriver();
	    	   byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	    	   ChainTestListener.embed(src, "image/png");
	       }
	       closeBrowser();
		}
		
		public static WebDriver getDriver() {
			return driver.get();
		}
		
		public static void closeBrowser() {
			driver.get().close();
			driver.remove();	
		}

}