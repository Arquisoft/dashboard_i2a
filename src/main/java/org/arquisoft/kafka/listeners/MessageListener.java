package org.arquisoft.kafka.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.arquisoft.kafka.dashboard.model.Report;
import org.arquisoft.kafka.dashboard.model.Comment;
import org.arquisoft.kafka.dashboard.model.Proposal;
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
    private Report repository;

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
//        repository.add(proposal);
    }

    @KafkaListener(topics = "comments")
    public void processJSONComments(String jsonString) throws IOException {
        Comment comment = new ObjectMapper().readValue(jsonString,Comment.class);
        String data = "Comment:\tVotes: " + comment.getVotes()
                + " Date: "  + comment.getDate();
        Files.write(Paths.get("output.txt"),"".getBytes());
//        repository.add(comment);
    }


    public boolean getTest() {
        return test;
    }
}
