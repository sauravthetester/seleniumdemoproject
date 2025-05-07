package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(ChainTestListener.class)
@CucumberOptions(
		features = "@target/failed_scenarios.txt",
	    plugin = {"pretty","html:target/rerun-report"},
	    glue = {"steps"},
	    dryRun = false,
        monochrome = true
)
public class FailedScenariosRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
