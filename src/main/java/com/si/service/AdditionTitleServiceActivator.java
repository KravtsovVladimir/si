package com.si.service;

import com.si.exception.FileProcessingException;
import com.si.handler.ErrorHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

public class AdditionTitleServiceActivator {

    @Autowired
    private ErrorHandler errorHandler;

    public String processing(Message<String> message) throws FileProcessingException {

        String title = message.getHeaders().get("file_name").toString();
        String payload = message.getPayload().replaceAll("\r\n", "");
        String[] values = payload.split(",");
        StringBuilder result = new StringBuilder();

        try {
            addTitle(title, values, result);
        } catch (FileProcessingException exception) {
            errorHandler.handleError(exception, message.getHeaders(), result.toString());
            throw exception;
        }

        return result.toString();
    }

    public void addTitle(String title, String[] values, StringBuilder result) throws FileProcessingException {

        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isNumeric(values[i])) {
                result.append(values[i])
                        .append(" + ")
                        .append(title)
                        .append(",");
            } else {
                String errorMessage = String.format("Error occurred while processing file: " +
                        "%s, in line: %d. File has been moved in 'error' folder.", title, i);

                throw new FileProcessingException(errorMessage);
            }
        }

    }

}
