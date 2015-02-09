package com.epam.jms.jms;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.annotation.JmsListener;
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
@Scope("singleton")
public class QueueConterService {

    private static final Logger logger = Logger.getLogger(QueueConterService.class);

    private final static String COUNTER = "counter";

    private int totalBytes = 0;

    @JmsListener(containerFactory = "jmsQueueListener", destination = "myQueue")
    public void counter(TextMessage message) throws JMSException {
        totalBytes += message.getText().getBytes().length;
        log(totalBytes, "myQueue");
    }

    private void log(int length, String topic) {
        final String filename = COUNTER + topic;
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
            out.println(length);
        }catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("Message length: " + length + " from queue: " + topic);
    }

}
