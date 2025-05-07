package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private final int maxRetryCount = 2;  // Set the max retry count
    private static final Logger logger = LogManager.getLogger(LogListener.class);

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
        	logger.info("Retrying: " + result.getMethod());
            retryCount++;
            return true;  // Retry this test
        }
        return false;
    }
}
