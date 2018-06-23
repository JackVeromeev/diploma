package by.veromeev.slaar.admin.controller;

import by.veromeev.slaar.core.ApplicationStatusController;
import by.veromeev.slaar.dao.ChatWindowDAO;
import by.veromeev.slaar.entity.ChatWindow;
import by.veromeev.slaar.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminWindowsController extends ApplicationStatusController {

    private static final String EM_WINDOW_NOT_FOUND = "Oops! Looks like window you opened was deleted or id was changed";

    private ChatWindowDAO chatWindowDAO;

    @Autowired
    public AdminWindowsController(ChatWindowDAO chatWindowDAO) {
        this.chatWindowDAO = chatWindowDAO;
    }

    @GetMapping("/admin/windows")
    public String windows(Model model) {

        ArrayList<ChatWindow> chatWindows = new ArrayList<>();
        this.chatWindowDAO.findAll().forEach(chatWindows::add);
        model.addAttribute("chatWindows", chatWindows);
        return "admin.windows.list";
    }

    @PostMapping("/admin/windows")
    public String newWindow(ChatWindow chatWindow, Model model) {
        this.chatWindowDAO.save(chatWindow);
        return windows(model);
    }

    @GetMapping("/admin/windows/{id}/")
    public String editWindow(@PathVariable("id") Long windowId, Model model) {
        Optional<ChatWindow> optionalChatWindow = this.chatWindowDAO.findById(windowId);
        System.out.println("window edit, found=" + optionalChatWindow.isPresent());
        optionalChatWindow.ifPresent(chatWindow ->
                model.addAttribute("window", chatWindow)
        );
        if (!optionalChatWindow.isPresent()) {
            model.addAttribute("errorMessage", EM_WINDOW_NOT_FOUND);
        }
        String viewName = "admin.windows.edit";
        if (!optionalChatWindow.isPresent()) {
            viewName = windows(model);
        }
        return viewName;
    }

    @PutMapping(value = "/admin/windows/{id}/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editWindow(@PathVariable("id") Long windowId,
                             @RequestBody ChatWindow updatedChatWindow,
                             Model model) {
        Optional<ChatWindow> optionalChatWindow = this.chatWindowDAO.findById(windowId);
        System.out.println("window edit, found=" + optionalChatWindow.isPresent());
        optionalChatWindow.ifPresent(dbChatWindow -> {
            boolean recordChanged = false;
            if (StringUtils.changedToNotEmpty(dbChatWindow.getName(), updatedChatWindow.getName())) {
                dbChatWindow.setName(updatedChatWindow.getName());
                recordChanged = true;
            }

            if (StringUtils.changedToNotEmpty(dbChatWindow.getSFButtonsId(), updatedChatWindow.getSFButtonsId())) {
                dbChatWindow.setSFButtonsId(updatedChatWindow.getSFButtonsId());
                recordChanged = true;
            }

            if (StringUtils.changedToNotEmpty(dbChatWindow.getSFDeploymentId(), updatedChatWindow.getSFDeploymentId())) {
                dbChatWindow.setSFDeploymentId(updatedChatWindow.getSFDeploymentId());
                recordChanged = true;
            }

            if (StringUtils.changedToNotEmpty(dbChatWindow.getSFOrganizationId(), updatedChatWindow.getSFOrganizationId())) {
                dbChatWindow.setSFOrganizationId(updatedChatWindow.getSFOrganizationId());
                recordChanged = true;
            }
            if (recordChanged) {
                this.chatWindowDAO.save(dbChatWindow);
            }
            model.addAttribute("window", dbChatWindow);
        });
        optionalChatWindow.orElseGet(() -> {
            model.addAttribute("errorMessage", EM_WINDOW_NOT_FOUND);
            return null;
        });
        String viewName = "admin.windows.edit";
        if (!optionalChatWindow.isPresent()) {
            viewName = windows(model);
        }
        return viewName;
    }
}
