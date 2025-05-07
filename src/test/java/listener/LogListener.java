package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class LogListener extends TestListenerAdapter {
    private static final Logger logger = LogManager.getLogger(LogListener.class);

    @Override
    public void onTestStart(ITestResult result) {
    	if(!result.getName().equals("runScenario")) logger.info("STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	if(!result.getName().equals("runScenario")) logger.info("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	if(!result.getName().equals("runScenario")) logger.error("FAILED: " + result.getName(), result.getThrowable());
    }
}
