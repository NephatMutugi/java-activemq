package com.teohkenya.main.queues;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ Author NMuchiri
 **/
@Slf4j
public class Publisher {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616");

        try {

            // create new connection using connection factory
            Connection connection = connectionFactory.createConnection();

            // create new session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // set the destination
            Destination destinationQueue = session.createQueue("test");

            // set the message
            TextMessage message = session.createTextMessage("First Message");

            // producer
            MessageProducer producer = session.createProducer(destinationQueue);

            // producer sends the message
            producer.send(message);
            System.out.println("Message Published");
//            log.info("Message Published");

            // close the session and connection
            connection.close();
            session.close();
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }
}
