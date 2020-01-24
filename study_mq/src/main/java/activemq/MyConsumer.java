package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MyConsumer {
    //默认连接用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //默认连接密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //默认连接地址
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    //发送的消息数量
    private static final int SENDNUM = 10;
    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        // 打开连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列目标,并标识队列名称,消费者根据队列名称接受数据
        Queue myQueue = session.createQueue("myQueue");
        Topic myTopic = session.createTopic("myTopic");
        // 创建一个消费者
        MessageConsumer consumerQueue = session.createConsumer(myQueue);
        MessageConsumer consumerTopic = session.createConsumer(myTopic);
        while (true) {
            Message queueMessage = consumerQueue.receive();
            Message topicMessage = consumerTopic.receive();
            System.out.println("Queue:"+queueMessage);
            System.out.println("Topic:"+topicMessage);
        }
    }
}
