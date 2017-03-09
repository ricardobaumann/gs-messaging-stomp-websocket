package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "external")
public class ExternalController {

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping(method = RequestMethod.POST)
    @SendTo("/topic/greetings")
    public Greeting post(@RequestBody Greeting greeting) {
        template.convertAndSend("/topic/greetings",greeting);
        return greeting;
    }

}
