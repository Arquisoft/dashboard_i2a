package hello;

import hello.listeners.KafkaListenerFactory;
import hello.producers.KafkaProducer;
import org.apache.kafka.clients.consumer.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Dax on 01-Apr-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class KafkaTest {

    private KafkaProducer producer = new KafkaProducer("Test");
    private KafkaListenerFactory containerFactory = new KafkaListenerFactory();


    @Test
    public void test(){
        producer.send("test","something");
        Consumer<Integer, String> consumer = containerFactory.consumerFactory().createConsumer();
    }

}
