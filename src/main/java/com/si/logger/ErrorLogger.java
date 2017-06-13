package com.si.logger;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

public class ErrorLogger {
    private static final Logger logger = Logger.getLogger(ErrorLogger.class);

    public void logError(Message<Exception> message) {
        logger.error(message.getPayload());
    }
}
