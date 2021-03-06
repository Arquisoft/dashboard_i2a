package dashboard.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import dashboard.Repository;
import dashboard.dto.Commentary;
import dashboard.dto.Proposal;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by herminio on 28/12/16.
 */
public class MessageListener {

    private static final Logger logger = Logger.getLogger(MessageListener.class);
    private boolean test = false;

    @Autowired
    private Repository repository;

    public void setTest(boolean test) {
        this.test = test;
    }

    @KafkaListener(topics = "test")
    public void processMessage(String content) throws InterruptedException {
        logger.info("New message received: \"" + content + "\"");
        System.out.println("New message received: \"" + content + "\"");
        test = true;
    }

    @KafkaListener(topics = "proposals")
    public void processJSONProposal(String jsonString) throws IOException {
        Proposal proposal = new ObjectMapper().readValue(jsonString, Proposal.class);
        String data = "Proposal:\tVotes: " + proposal.getVotes()
                + " Content: "  + proposal.getContent();
        Files.write(Paths.get("output.txt"),"".getBytes());
        repository.add(proposal);
    }

    @KafkaListener(topics = "comments")
    public void processJSONComments(String jsonString) throws IOException {
        Commentary comment = new ObjectMapper().readValue(jsonString,Commentary.class);
        String data = "Comment:\tVotes: " + comment.getVotes()
                + " Date: "  + comment.getFecha();
        Files.write(Paths.get("output.txt"),"".getBytes());
        repository.add(comment);
    }


    public boolean getTest() {
        return test;
    }
}
