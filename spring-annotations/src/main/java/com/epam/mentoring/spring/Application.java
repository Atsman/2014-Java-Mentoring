package com.epam.mentoring.spring;

import com.epam.mentoring.spring.configuration.AppConfig;
import com.epam.mentoring.spring.factory.SomeBean;
import com.epam.mentoring.spring.service.MessagePrinterService;
import com.epam.mentoring.spring.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by alehatsman on 12/17/14.
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = applicationContext.getBean(MessageService.class);
        messageService.setMessage("My message!!!");
        MessagePrinterService messagePrinterServiceService = applicationContext.getBean(MessagePrinterService.class);
        messagePrinterServiceService.printMessage();

        SomeBean sb = applicationContext.getBean(SomeBean.class);
        sb.doSmth();
    }

}
