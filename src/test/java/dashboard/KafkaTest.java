package dashboard;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dashboard.dto.Commentary;
import dashboard.listeners.MessageListener;
import dashboard.producers.KafkaProducer;
import kafka.message.Message;
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
import java.util.*;
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
        UserInfo user = new UserInfo("Pepe",10);
        String jsonString = new ObjectMapper().writeValueAsString(user);
        Message message = new Message(jsonString.getBytes());
        producer.send("test","foo");
        assertTrue(messageListener.getLatch().await(10, TimeUnit.SECONDS));
    }

    @Test
    public void testSerialization() throws JsonProcessingException {
        Commentary comment = new Commentary();
        comment.setVotes(43);
        comment.setFecha(new Date());

        producer.send("test2",new ObjectMapper().writeValueAsString(comment));

    }
}
