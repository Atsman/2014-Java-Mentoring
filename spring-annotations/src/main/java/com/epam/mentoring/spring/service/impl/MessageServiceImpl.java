package com.epam.mentoring.spring.service.impl;

import com.epam.mentoring.spring.service.MessageService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by alehatsman on 12/17/14.
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
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
