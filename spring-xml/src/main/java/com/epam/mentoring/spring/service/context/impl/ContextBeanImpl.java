package com.epam.mentoring.spring.service.context.impl;

import com.epam.mentoring.spring.service.MessageService;
import com.epam.mentoring.spring.service.context.ContextBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by alehatsman on 12/20/14.
 */
public class ContextBeanImpl implements ContextBean, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void doSmth() {
        MessageService messageService = (MessageService)applicationContext.getBean("messageService");
        messageService.setMessage("Message changed from contextBean");
    }

}
