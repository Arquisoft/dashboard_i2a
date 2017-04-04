package dashboard.listeners;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.ManagedBean;
import java.util.concurrent.CountDownLatch;

/**
 * Created by herminio on 28/12/16.
 */
public class MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListener.class);
    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "test")
    public void processMessage(String content) {
        logger.info("New message received: \"" + content + "\"");
        System.out.println("New message received: \"" + content + "\"");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
