package dashboard;


import dashboard.listeners.MessageListener;
import dashboard.producers.KafkaProducer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel Ortea on 01-Apr-17.
 * Testing class dedicated to test Kafka Consumer and Producer API
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaTest {

    protected static final String TOPIC = "test";

    @Autowired
    private MessageListener messageListener;

    @Autowired
    private KafkaProducer producer;

    @Test
    public void testSpringConsumerAndProducer() throws InterruptedException, IOException {
        producer.send("test","foo");
        assertTrue(messageListener.getLatch().await(10, TimeUnit.SECONDS));
    }
}
