package basics.collections.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("This message will be written to the log file.");
        logger.error("This error will also be written to the log file.");
    }
}

