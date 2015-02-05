package jms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;

/**
 * Created by Aleh_Atsman on 2/5/2015.
 */
@Configuration
@EnableAutoConfiguration
public class Application {

    public static final String topic1 = "mailbox-destination1";
    public static final String topic2 = "mailbox-destination2";
    public static final String topic3 = "mailbox-destination3";

    @Bean(name = "rec1")
    Receiver receiver() {
        return new Receiver("1");
    }

    @Bean(name = "rec2")
    Receiver receiver2() {
        return new Receiver("2");
    }

    @Bean(name = "rec3")
    Receiver receiver3() {
        return new Receiver("3");
    }

    @Bean(name = "ada1")
    MessageListenerAdapter adapter(@Qualifier(value = "rec1") Receiver receiver) {
        return createAdapter(receiver);
    }

    @Bean(name = "ada2")
    MessageListenerAdapter adapter2(@Qualifier(value = "rec2") Receiver receiver) {
        return createAdapter(receiver);
    }

    @Bean(name = "ada3")
    MessageListenerAdapter adapter3(@Qualifier(value = "rec3") Receiver receiver) {
        return createAdapter(receiver);
    }

    @Bean
    DefaultMessageListenerContainer listener1(@Qualifier(value = "ada1")MessageListenerAdapter messageListener, ConnectionFactory connectionFactory) {
        return createListener(messageListener, connectionFactory, topic1);
    }

    @Bean
    DefaultMessageListenerContainer listener2(@Qualifier(value = "ada2")MessageListenerAdapter messageListener, ConnectionFactory connectionFactory) {
        return createListener(messageListener, connectionFactory, topic2);
    }

    @Bean
    DefaultMessageListenerContainer listener3(@Qualifier(value = "ada3")MessageListenerAdapter messageListener, ConnectionFactory connectionFactory) {
        return createListener(messageListener, connectionFactory, topic3);
    }

    MessageListenerAdapter createAdapter(Receiver receiver) {
        MessageListenerAdapter messageListener = new MessageListenerAdapter(receiver);
        messageListener.setDefaultListenerMethod("receiveMessage");
        return messageListener;
    }

    DefaultMessageListenerContainer createListener(MessageListenerAdapter listener, ConnectionFactory connectionFactory, String destination) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setPubSubDomain(true);
        container.setDestinationName(destination);
        container.setMessageListener(listener);
        container.setConcurrentConsumers(10);
        return container;
    }

    @Bean
    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory);
        jmsTemplate.setPubSubDomain(true);

        return jmsTemplate;
    }



}
