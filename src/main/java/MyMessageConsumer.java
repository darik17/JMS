import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by admin on 12.05.2017. 123
 */
public class MyMessageConsumer {
    public Connection createConnection() throws JMSException {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(""
                +"vm://localhost");
        return activeMQConnectionFactory.createConnection();
    }
    public void receivedMessage(){

        try {
            Connection connection = createConnection();
            connection.start();

            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("MyQueue");

            MessageConsumer producer = session.createConsumer(destination);

            Message message = producer.receive(10000);
            System.out.println(((TextMessage) message).getText());

            producer.close();
            session.close();



        } catch (JMSException e){
            e.printStackTrace();
        }

    }
}
