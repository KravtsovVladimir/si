package com.si.handler;

import org.springframework.messaging.MessageHeaders;

public interface ErrorHandler {
    void handleError(Throwable t, MessageHeaders headers, String payload);
}
