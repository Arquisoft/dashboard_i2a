package dashboard.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import dashboard.dto.Commentary;
import dashboard.dto.Proposal;
import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import javax.annotation.ManagedBean;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    @KafkaListener(topics = "proposals")
    public void processJSONProposal(String jsonString) throws IOException {
        Proposal proposal = new ObjectMapper().readValue(jsonString, Proposal.class);
    }

    @KafkaListener(topics = "comments")
    public void processJSONComments(String jsonString) throws IOException {
        Commentary comment = new ObjectMapper().readValue(jsonString,Commentary.class);
        String data = "Proposal:\tVotes: " + comment.getVotes()
                + " Date: "  + comment.getFecha();
        Files.write(Paths.get("output.txt"),"".getBytes());
    }


    public CountDownLatch getLatch() {
        return latch;
    }
}
