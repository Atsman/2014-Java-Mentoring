package com.epam.mentoring.spring;

import com.epam.mentoring.spring.service.MessagePrinterService;
import com.epam.mentoring.spring.service.MessageService;
import com.epam.mentoring.spring.service.thread.ThreadService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by alehatsman on 12/17/14.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {
        try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml")) {
            MessagePrinterService messagePrinterService = getMessagePrinterService(context);
            messagePrinterService.printMessage();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadService threadService = getThreadService(context);
                    threadService.setMessage("Thread1 context");
                    threadService.doSmth();
                }
            }).run();

            Thread.sleep(200);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    ThreadService threadService = getThreadService(context);
                    //threadService.setMessage("Thread1 context");
                    threadService.doSmth();
                }
            }).run();
        }
    }

    private static ThreadService getThreadService(ApplicationContext applicationContext) {
        return (ThreadService) applicationContext.getBean("threadService");
    }

    private static MessageService getMessageService(ApplicationContext context) {
        return (MessageService) context.getBean("messageService");
    }

    private static MessagePrinterService getMessagePrinterService(ApplicationContext context) {
        return (MessagePrinterService) context.getBean("messagePrinterService");
    }
}
