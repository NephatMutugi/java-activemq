package com.teohkenya.main.queues;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @ Author NMuchiri
 **/
public class Consumer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {
            // create new connection using connection factory
            Connection connection = connectionFactory.createConnection();
            connection.start();
            // create new session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        } catch (JMSException e){
e.printStackTrace();
        }
    }
}
