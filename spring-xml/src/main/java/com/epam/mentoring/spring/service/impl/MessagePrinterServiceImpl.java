package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageFormatterService;
import com.epam.mentoring.spring.service.MessagePrinterService;
import com.epam.mentoring.spring.service.MessageService;

/**
 * Created by alehatsman on 12/17/14.
 */
public class MessagePrinterServiceImpl implements MessagePrinterService {

    private MessageService messageService;

    private MessageFormatterService messageFormatterService;

    public MessagePrinterServiceImpl(MessageFormatterService messageFormatterService) {
        this.messageFormatterService = messageFormatterService;
    }

    @Override
    public void printMessage() {
        String message = messageService.getMessage();
        String formattedMessage = messageFormatterService.format(message);
        System.out.println(formattedMessage);
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
