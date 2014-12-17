package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageService;

/**
 * Created by alehatsman on 12/17/14.
 */
public class MessageServiceImpl implements MessageService {

    private String message = "Default";

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
