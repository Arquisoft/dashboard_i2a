package dashboard;

import dashboard.listeners.KafkaListenerFactory;
import dashboard.producers.KafkaProducer;
import org.apache.kafka.clients.consumer.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * Created by Dax on 01-Apr-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaTest {

    private KafkaProducer producer = new KafkaProducer("Test");
    private KafkaListenerFactory containerFactory = new KafkaListenerFactory();


    @Test
    public void test(){
        Consumer<Integer, String> consumer = containerFactory.consumerFactory().createConsumer();
        ArrayList<String> topicList = new ArrayList<>();
        topicList.add("test");
        consumer.subscribe(topicList);
        producer.send("test","something");
        consumer.toString();
    }

}
