package jms;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.util.Random;

/**
 * Created by Aleh_Atsman on 2/5/2015.
 */
public class Producer {

    public static void main(String[] args) {
        // Clean out any ActiveMQ data from a previous run
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");

        Random random = new Random();
        for(int i = 0; i < 5; i++) {
            int t = random.nextInt(2);
            if(t == 0) {
                jmsTemplate.convertAndSend(Application.topic1, "Message for topic 1");
            } else if(t == 1) {
                jmsTemplate.convertAndSend(Application.topic2, "Message for topic 2");
            } else {
                jmsTemplate.convertAndSend(Application.topic3, "Message for topic 3");
            }
        }



        context.close();
    }

}
