package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * activeMQ:默认地址,localhost:8161,默认登录账号和密码都是admin
 */
public class MyProducer {
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
        // createQueue:队列模式,消费者启动后会获取到所有未消费的消息,消息只会被消费一次.
        // createTopic:发布订阅模式,消费者启动后只能获取之后发布的消息,同一个消息可被多个消费者接收
        Queue myQueue = session.createQueue("myQueue");
        Topic myTopic = session.createTopic("myTopic");
        // 创建一个生产者
        MessageProducer producerQueue = session.createProducer(myQueue);
        MessageProducer producerTopic = session.createProducer(myTopic);
        for (int i = 0; i <= 10; i++) {
            TextMessage message = session.createTextMessage("第" + i);
            producerQueue.send(message);
            producerTopic.send(message);
            System.out.println(message.getText());
        }
        connection.close();
    }
}
