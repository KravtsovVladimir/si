package com.si.handler;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Arrays;

public class ErrorHandlerImpl implements ErrorHandler {

    private MessageChannel defaultErrorChannel;

    public void handleError(Throwable t, MessageHeaders headers, String payload) {
        String payloadWithTrace = payload + Arrays.toString(t.getStackTrace());
        Message message = MessageBuilder
                .withPayload(payloadWithTrace)
                .copyHeadersIfAbsent(headers)
                .build();

        defaultErrorChannel.send(message);
    }

    public MessageChannel getDefaultErrorChannel() {
        return defaultErrorChannel;
    }

    public void setDefaultErrorChannel(MessageChannel defaultErrorChannel) {
        this.defaultErrorChannel = defaultErrorChannel;
    }
}
