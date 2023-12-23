package com.devsu.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ResourceBundle;

@Slf4j
@Component
public class MessageHelper {
    private static final String MESSAGE_PROPERTIES = "messages/messages";

    public String getMessage(String code) {
        var message = "";
        try {
            var bundle = ResourceBundle.getBundle(MESSAGE_PROPERTIES);
            message = bundle.getString(code);
        } catch (Exception e) {
            log.error("Error loading message property: {}", code);
        }
        return message;
    }

    public String getFormatedMessage(String code, Object[] params) {
        var message = "";
        try {
            var bundle = ResourceBundle.getBundle(MESSAGE_PROPERTIES);
            message = MessageFormat.format(bundle.getString(code), params);
        } catch (Exception e) {
            log.error("Error loading message property: {}", code);
        }
        return message;
    }
}
