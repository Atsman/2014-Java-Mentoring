package com.epam.jms.client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Aleh_Atsman on 2/9/2015.
 */
public class Producer {

    public static String[] topics = {"Topic1", "Topic2", "Topic3"};

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            thread(new HelloWorldProducer(), false);
            Thread.sleep(1000);
        }
    }

    public static void thread(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
    }

    public static class HelloWorldProducer implements Runnable {
        public void run() {
            try {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://EPBYGROW0183:61616");

                Connection connection = connectionFactory.createConnection();
                connection.start();

                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                String topic = topics[(int)Math.round(Math.random()*2)];
                Destination destination = session.createQueue(topic);

                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

                String text = "Hello jms! Topic: " + topic;
                TextMessage message = session.createTextMessage(text);

                System.out.println("Sent message: " + message + "Topic - " + topic );
                producer.send(message);

                session.close();
                connection.close();
            }
            catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
        }
    }

}
