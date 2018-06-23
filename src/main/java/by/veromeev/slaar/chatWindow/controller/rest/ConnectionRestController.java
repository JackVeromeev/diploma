package by.veromeev.slaar.chatWindow.controller.rest;

import by.veromeev.slaar.core.ApplicationStatus;
import by.veromeev.slaar.dao.ChatSessionDAO;
import by.veromeev.slaar.dao.ChatWindowDAO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ConnectionRestController {

    @Data
    @AllArgsConstructor
    public static class ConnectionResponse {
        private Long id;
        private String msg;
    }

    private ChatSessionDAO sessionDAO;
    private ApplicationStatus status;
    private ChatWindowDAO windowDAO;

    @Autowired
    public ConnectionRestController(ChatSessionDAO sessionDAO, ApplicationStatus status, ChatWindowDAO windowDAO) {
        this.sessionDAO = sessionDAO;
        this.status = status;
        this.windowDAO = windowDAO;
    }

    @GetMapping("/chat/connection")
    public ConnectionResponse getConnectionId(HttpSession session, @RequestParam("window") Long windowId) {
        if (!status.isUp()) {
            return new ConnectionResponse(-1L, "application is down");
        }
        return new ConnectionResponse(10L, "OK");
    }

}
