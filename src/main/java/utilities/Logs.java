package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    private final Logger log;
    private final String tag = "AUTOMATION";
    private final String bigSeparator =
            "------------------------------------------------------------------------------------------";
    private final String smallSeparator = "**********************************************************";

    public Logs() {
        log = LogManager.getLogger(tag);
    }

    private void printTestSeparator() {
        log.info(bigSeparator);
    }

    private void printSeparator() {
        log.info(smallSeparator);
    }

    private void printSeparatorDebug() {
        log.debug(smallSeparator);
    }

    private void printNewLine() {
        log.info("");
    }

    public void startTest(String testName) {
        printTestSeparator();
        log.info("Test: " + testName);
        printTestSeparator();
    }

    public void endTest(String status) {
        printTestSeparator();
        log.info(status);
        printTestSeparator();
        printNewLine();
        printNewLine();
    }

    public void startSuite(String suiteName) {
        printNewLine();
        printTestSeparator();
        printTestSeparator();
        log.info("Suite: " + suiteName);
        printTestSeparator();
        printTestSeparator();
        printNewLine();
    }

    public void preconditionStart() {
        printSeparator();
        log.info("Preconditions");
        printSeparator();
    }

    public void postConditionStart() {
        printSeparatorDebug();
        log.debug("Post conditions");
        printSeparatorDebug();
    }

    public void postConditionFinish() {
        printSeparatorDebug();
    }

    public void testSteps() {
        printSeparator();
        log.info("Test steps:");
        printSeparator();
    }

    public void info(String message) {
        log.info(message);
    }

    public void warn(String message) {
        log.warn(message);
    }

    public void error(String message) {
        log.error(message);
    }

    public void debug(String message) {
        log.debug(message);
    }

    public void printRequest(String url, String method, String contentType, String token, String payload,
                             int statusCode, long time, String responseBody) {
        var newLine = System.lineSeparator();
        var stringBuilder = new StringBuilder();
        stringBuilder
                .append(newLine).append(newLine)
                .append("Request:").append(newLine)
                .append("-------").append(newLine)
                .append("URL:\t\t\t").append(url).append(newLine)
                .append("Method:\t\t\t").append(method).append(newLine)
                .append("Content-Type:   ").append(contentType).append(newLine)
                .append("Authorization:\t").append(token).append(newLine)
                .append("Payload: ").append(newLine).append(payload).append(newLine).append(newLine)
                .append("Response:").append(newLine)
                .append("--------").append(newLine)
                .append("Status Code:\t").append(statusCode).append(newLine)
                .append("Response Time:\t").append(time).append(" ms").append(newLine)
                .append("Response Body:").append(newLine).append(responseBody).append(newLine);
        
        log.debug(stringBuilder);
    }
}
