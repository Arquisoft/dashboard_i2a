package org.arquisoft.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.arquisoft.kafka.producers.KafkaProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

    private boolean latch = true;

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/")
    public String landing() throws JsonProcessingException, InterruptedException {
        if(latch) {
            produce();
            latch = false;
        }
        return "index";
    }

    private void produce() throws JsonProcessingException, InterruptedException {
//        Thread thread = new Thread(() -> {
//
//            ArrayList<Comment> comments = createComments();
//            ArrayList<Proposal> proposals = createProposals();
//
//            for (int i = 0; i < 20; i++) {
//                try {
//                    producer.send("comments",
//                            new ObjectMapper().writeValueAsString(comments.get(i%(comments.size()-1))));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    producer.send("proposals",
//                            new ObjectMapper().writeValueAsString(proposals.get(i%(comments.size()-1))));
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();

       // report = new Report((List<Category>) repository.findAll());

    }


//    private ArrayList<Proposal> createProposals() {
//        ArrayList<Proposal> proposals = new ArrayList<>();
//        //User user = Persistence.getUserDao().getUserById(6);
//        for (int i = 0; i < 5;i++) {
//            Proposal proposal = new Proposal("This is kafkaProposal number " + i
//                    , i+1, 2,2);
//            proposal.setUser(user);
//            List<Comment> comments = new ArrayList<>();
//            //comments.add(new Comment("This is Truk Batal tha boos " + i,1,new Date(),2,2));
//            comments.get(0).setUser(user);
//            proposals.add(proposal);
//        }
//        return proposals;
//    }

//
//    private ArrayList<Comment> createComments() {
//        ArrayList<Comment> comments = new ArrayList<>();
//        User user = Persistence.getUserDao().getUserById(6);
//        for (int i = 0; i < 5;i++) {
////            Comment comment = new Comment("This is kafkaComment number " + i
////                    , i+1, new Date(),2,2);
////            comment.setUser(user);
////            comments.add(comment);
//        }
//        return comments;
//    }


}