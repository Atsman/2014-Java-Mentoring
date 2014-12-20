package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageFormatterService;
import org.apache.log4j.Logger;

/**
 * Created by alehatsman on 12/20/14.
 */
public class MessageFormatterServiceLocator {

    private static final Logger LOGGER = Logger.getLogger(MessageFormatterServiceLocator.class);

    public MessageFormatterService createMessageFormatterService(String start, String end) {
        LOGGER.info("create MessageFormatterService");
        return new MessageFormatterServiceImpl(start, end);
    }

}
