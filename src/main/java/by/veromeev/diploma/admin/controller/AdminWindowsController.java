package by.veromeev.diploma.admin.controller;

import by.veromeev.diploma.dao.ChatSessionDAO;
import by.veromeev.diploma.dao.ChatWindowDAO;
import by.veromeev.diploma.entity.ChatSession;
import by.veromeev.diploma.entity.ChatWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class AdminWindowsController {

    private ChatWindowDAO chatWindowDAO;

    private ChatSessionDAO chatSessionDAO;

    @Autowired
    public AdminWindowsController(ChatWindowDAO chatWindowDAO, ChatSessionDAO chatSessionDAO) {
        this.chatSessionDAO = chatSessionDAO;
        this.chatWindowDAO = chatWindowDAO;
    }

    @GetMapping("/admin/windows")
    public String windows(Model model) {

        Map<Long, ChatWindow> chatWindowMap = new HashMap<>();
        for (ChatWindow chatWindow : this.chatWindowDAO.findAll()) {
            if (chatWindow.getChatSessionsCount() == null) chatWindow.setChatSessionsCount(0L);
            if (chatWindow.getActiveChatSessionsCount() == null) chatWindow.setActiveChatSessionsCount(0L);
            chatWindowMap.put(chatWindow.getId(), chatWindow);
        }
        Iterable<ChatSession> all = chatSessionDAO.findAll();
        if (all != null) {
            for (ChatSession chatSession : chatSessionDAO.findAll()) {
                ChatWindow chatWindow = chatWindowMap.get(chatSession.getChatWindow().getId());
                chatWindow.setChatSessionsCount(chatWindow.getChatSessionsCount() + 1);
                if (chatSession.getIsActive()) {
                    chatWindow.setActiveChatSessionsCount(chatWindow.getActiveChatSessionsCount() + 1);
                }
            }
        }
        model.addAttribute("chatWindows", chatWindowMap.values());

        return "admin.windows.list";
    }

    @PostMapping("/admin/windows")
    public String newWindow(ChatWindow chatWindow, Model model) {
        this.chatWindowDAO.save(chatWindow);
        return windows(model);
    }

    @GetMapping("/admin/windows/{id}/")
    public String editWindow(@PathVariable("id") Long windowId, Model model) {
        Optional<ChatWindow> window = this.chatWindowDAO.findById(windowId);
        System.out.println("window edit,  found=" + window.isPresent());
        window.ifPresent(chatWindow -> model.addAttribute("window", chatWindow));
        return "admin.windows.edit";
    }

    @PutMapping(value = "/admin/windows/{id}/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editWindow(@PathVariable("id") Long windowId,
                             @RequestBody ChatWindow updatedChatWindow,
                             Model model) {
        Optional<ChatWindow> optionalChatWindow = this.chatWindowDAO.findById(windowId);
        System.out.println("window edit, found=" + optionalChatWindow.isPresent());
        optionalChatWindow.ifPresent(dbChatWindow -> {
            if (updatedChatWindow.getName() != null && !"".equals(updatedChatWindow.getName())) {
                dbChatWindow.setName(updatedChatWindow.getName());
            }

            if (updatedChatWindow.getSFButtonsId() != null && !"".equals(updatedChatWindow.getSFButtonsId())) {
                dbChatWindow.setSFButtonsId(updatedChatWindow.getSFButtonsId());
            }

            if (updatedChatWindow.getSFDeploymentId() != null && !"".equals(updatedChatWindow.getSFDeploymentId())) {
                dbChatWindow.setSFDeploymentId(updatedChatWindow.getSFDeploymentId());
            }

            if (updatedChatWindow.getSFOrganizationId() != null && !"".equals(updatedChatWindow.getSFOrganizationId())) {
                dbChatWindow.setSFOrganizationId(updatedChatWindow.getSFOrganizationId());
            }
            this.chatWindowDAO.save(dbChatWindow);
            model.addAttribute("window", dbChatWindow);
        });
        return "admin.windows.edit";
    }
}
