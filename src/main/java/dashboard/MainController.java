package dashboard;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dashboard.dto.Commentary;
import dashboard.dto.Proposal;
import dashboard.dto.User;
import dashboard.persistence.Persistence;
import dashboard.producers.KafkaProducer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

    private boolean latch = true;

    @Autowired
    private Repository repository;

    @Autowired
    private KafkaProducer producer;

    @RequestMapping("/")
    public String landing(Model model) throws JsonProcessingException, InterruptedException {
        model.addAttribute("repository",repository);
        if(latch) {
            produce();
            latch = false;
        }
        return "index";
    }

    private void produce() throws JsonProcessingException, InterruptedException {
        Thread thread = new Thread()
        {
            public void run() {

                ArrayList<Commentary> comments = createComments();
                ArrayList<Proposal> proposals = createProposals();

                for (int i = 0; i < 20; i++) {
                    try {
                        producer.send("comments",
                                new ObjectMapper().writeValueAsString(comments.get(i)));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    try {
                        producer.send("proposals",
                                new ObjectMapper().writeValueAsString(proposals.get(i)));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();


    }


    private ArrayList<Proposal> createProposals() {
        ArrayList<Proposal> proposals = new ArrayList<>();
        User user = Persistence.getUserDao().getUserById(6);
        for (int i = 0; i < 1;i++) {
            Proposal proposal = new Proposal("This is kafkaProposal number " + i
                    , i+1, 2,2);
            proposal.setUser(user);
            List<Commentary> comments = new ArrayList<>();
            comments.add(new Commentary("This is Truk Batal tha boos " + i,1,new Date(),2,2));
            comments.get(0).setUser(user);
            proposals.add(proposal);
        }
        return proposals;
    }

    private ArrayList<Commentary> createComments() {
        ArrayList<Commentary> comments = new ArrayList<>();
        User user = Persistence.getUserDao().getUserById(6);
        for (int i = 0; i < 1;i++) {
            Commentary comment = new Commentary("This is kafkaComment number " + i
                    , i+1, new Date(),2,2);
            comment.setUser(user);
            comments.add(comment);
        }
        return comments;
    }


}