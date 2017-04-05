package dashboard;


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
import java.util.List;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());

    @Autowired
    private Repository repository;

    @RequestMapping("/")
    public String landing(Model model) {
        model.addAttribute("repository",repository);
        return "index";
    }

    @RequestMapping (path = "/register", method = RequestMethod.GET)
    public SseEmitter register() throws IOException {
        logger.info("Registering a stream.");

        SseEmitter emitter = new SseEmitter();

        synchronized (sseEmitters) {
            sseEmitters.add(emitter);
        }
        emitter.onCompletion(() -> sseEmitters.remove(emitter));

        return emitter;
    }

//    synchronized (sseEmitters) {
//        sseEmitters.forEach((SseEmitter emitter) -> {
//            try {
//                emitter.send(, MediaType.APPLICATION_JSON);
//            } catch (IOException e) {
//                emitter.complete();
//                sseEmitters.remove(emitter);
//            }
//        });
//    }



}