package runner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@Listeners(ChainTestListener.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"},
        dryRun = false,
        monochrome = true,
        //tags = "@regression",
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json","rerun:target/failed_scenarios.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
		@Override
		@DataProvider(parallel = true)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	
}