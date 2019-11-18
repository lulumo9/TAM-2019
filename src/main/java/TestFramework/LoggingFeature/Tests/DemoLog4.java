package TestFramework.LoggingFeature.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoLog4 {

    static Logger logger = LogManager.getLogger(DemoLog4.class);

    public static void main(String [] args)
    {
        System.out.println("Hi there!");

        logger.trace("This is trace message");
        logger.info("This is information message");
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.fatal("This is a fatal message");
        System.out.println("Completed");
    }
}
