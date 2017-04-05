package dashboard;


import dashboard.dto.Proposal;
import dashboard.persistence.Persistence;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

    @RequestMapping("/")
    public String landing(ArrayList<Proposal> proposals, Model model) {
        proposals = (ArrayList<Proposal>) Persistence.getProposalDao().getProposals();
        model.addAttribute("proposals",proposals);
        return "index";
    }



}