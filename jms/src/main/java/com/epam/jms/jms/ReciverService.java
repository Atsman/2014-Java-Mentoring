package com.epam.jms.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Aleh_Atsman on 2/9/2015.
 */
@Component
public class ReciverService {

    private static final Logger logger = Logger.getLogger(ReciverService.class);

    @JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "Topic1")
    public void l1(TextMessage message) throws JMSException {
        log(message.getText(), "Topic1");
    }

    @JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "Topic2")
    public void l2(TextMessage message) throws JMSException{
        log(message.getText(), "Topic2");
    }

    @JmsListener(containerFactory = "myJmsListenerContainerFactory", destination = "Topic3")
    public void l3(TextMessage message) throws JMSException{
        log(message.getText(), "Topic3");
    }

    private void log(String message, String topic) {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(topic, true)))) {
            out.println(message);
        }catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("Message: " + message + " from topic: " + topic);
    }

}
