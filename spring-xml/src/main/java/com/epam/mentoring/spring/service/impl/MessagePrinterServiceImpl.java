package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageFormatterService;
import com.epam.mentoring.spring.service.MessagePrinterService;
import com.epam.mentoring.spring.service.MessageService;
import org.apache.log4j.Logger;

/**
 * Created by alehatsman on 12/17/14.
 */
public class MessagePrinterServiceImpl implements MessagePrinterService {

    private static Logger LOGGER = Logger.getLogger(MessagePrinterServiceImpl.class);

    private MessageService messageService;

    private MessageFormatterService messageFormatterService;

    private int repeat = 0;

    public MessagePrinterServiceImpl(MessageFormatterService messageFormatterService, int repeat) {
        this.messageFormatterService = messageFormatterService;
        this.repeat = repeat;
    }

    @Override
    public void printMessage() {
        for(int i = 0; i <= repeat; i ++) {
            String message = messageService.getMessage();
            String formattedMessage = messageFormatterService.format(message);
            System.out.println(formattedMessage);
        }
    }

    public void setMessageService(MessageService messageService) {
        LOGGER.info("setMessageService");
        this.messageService = messageService;
    }

}
