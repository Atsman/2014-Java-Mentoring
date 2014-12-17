package com.epam.mentoring.spring;

import com.epam.mentoring.spring.factory.SomeBean;
import com.epam.mentoring.spring.service.MessagePrinterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alehatsman on 12/17/14.
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        MessagePrinterService messageService = (MessagePrinterService) context.getBean("messagePrinterService");
        messageService.printMessage();

        SomeBean someBean = (SomeBean) context.getBean("someBean");
        someBean.doSmth();
    }
}
