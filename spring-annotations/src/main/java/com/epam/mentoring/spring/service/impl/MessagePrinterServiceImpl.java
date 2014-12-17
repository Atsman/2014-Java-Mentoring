package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageFormatterService;
import com.epam.mentoring.spring.service.MessagePrinterService;
import com.epam.mentoring.spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by alehatsman on 12/17/14.
 */
@Service
public class MessagePrinterServiceImpl implements MessagePrinterService {

    @Autowired
    private MessageService messageService;

    private MessageFormatterService messageFormatterService;

    @Autowired

    public MessagePrinterServiceImpl(@Qualifier("main") MessageFormatterService messageFormatterService) {
        this.messageFormatterService = messageFormatterService;
    }

    @Override
    public void printMessage() {
        String message = messageService.getMessage();
        String formattedMessage = messageFormatterService.format(message);
        System.out.println(formattedMessage);
    }

}
