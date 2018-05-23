package by.veromeev.diploma.chatWindow.controller;

import by.veromeev.diploma.entity.dto.Greeting;
import by.veromeev.diploma.entity.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello/{Name}")
    @SendTo("/topic/greetings/{Name}")
    public Greeting greeting(HelloMessage message, @DestinationVariable("Name") String name) {
        System.out.println("got:  "+message.getName() );
//        Thread.sleep(1000); // simulated delay
        Greeting g = new Greeting(name + ": Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
        System.out.println("resp: "+g.getContent());
        return g;
    }

}
