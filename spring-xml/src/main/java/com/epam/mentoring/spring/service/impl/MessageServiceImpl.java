package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageService;
import org.apache.log4j.Logger;

/**
 * Created by alehatsman on 12/17/14.
 */
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = Logger.getLogger(MessageServiceImpl.class);

    private String message = "Default";

    public MessageServiceImpl(String defaultMessage) {
        this.message = defaultMessage;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static MessageService createInstance(String message) {
        LOGGER.info("create with factory method");
        return new MessageServiceImpl(message);
    }

    public void init() {
        LOGGER.info("Init phase");
    }

    public void destroy() {
        LOGGER.info("Destroy phase");
    }

}
