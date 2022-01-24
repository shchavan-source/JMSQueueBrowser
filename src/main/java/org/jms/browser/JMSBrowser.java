package org.jms.browser;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Enumeration;

public class JMSBrowser {
    public static void main(String[] args) throws JMSException {
        String url = args[0];
        String username = args[1];
        String passwd = args[2];
        String queueName = args[3];
        Connection connection = null;
        try {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url, username, passwd);
            connection = connectionFactory.createConnection();
            Session session = connection.createSession();
            Queue queue = session.createQueue(queueName);
            connection.start();
            QueueBrowser queueBrowser = session.createBrowser(queue);
            Enumeration e = queueBrowser.getEnumeration();
            while (e.hasMoreElements()) {
                Message msg = (Message) e.nextElement();
                System.out.println("Message Timestamp: " + msg.getJMSTimestamp());
            }
            queueBrowser.close();
            session.close();
        }
        finally {
            connection.close();
        }

    }
}
