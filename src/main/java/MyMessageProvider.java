import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by admin on 12.05.2017. 123
 */
public class MyMessageProvider {



    public void sendMessage(String message) {
        try {
            Connection connection = createConnection();
            connection.start();
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            
            Destination destination = session.createQueue("MyQueue");
            MessageProducer produced = session.createProducer(destination);
            produced.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage textMessage = session.createTextMessage(message);

            produced.send(textMessage);

            session.close();
            connection.close();


        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
    public Connection createConnection() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(""
                +"vm://localhost");
        return activeMQConnectionFactory.createConnection();
    }
}
