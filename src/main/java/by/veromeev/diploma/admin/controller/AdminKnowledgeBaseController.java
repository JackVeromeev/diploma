package by.veromeev.diploma.admin.controller;

import by.veromeev.diploma.core.ApplicationStatus;
import by.veromeev.diploma.core.ApplicationStatusController;
import by.veromeev.diploma.dao.KnowledgeNodeDAO;
import by.veromeev.diploma.entity.KnowledgeNode;
import by.veromeev.diploma.util.StringUtils;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AdminKnowledgeBaseController extends ApplicationStatusController {

    private KnowledgeNodeDAO dao;

    private ApplicationStatus applicationStatus;

    @Autowired
    public AdminKnowledgeBaseController(KnowledgeNodeDAO dao, ApplicationStatus applicationStatus) {
        this.dao = dao;
        this.applicationStatus = applicationStatus;
    }

    private void attachError(Model m) {
        m.addAttribute("errorMessage", "Oops, knowledge node is not found :(");
    }

    @GetMapping("/admin/kb/")
    public String root(Model model) {
        model.addAttribute("children", dao.findRootNodes());
        return "admin.kn";
    }

    @GetMapping("/admin/kb/{id}")
    public String node(Model model, @PathVariable Long id) {
        val optionalNode = dao.findById(id);
        optionalNode.ifPresent(knowledgeNode -> {
            model.addAttribute("node", knowledgeNode);
            model.addAttribute("children", knowledgeNode.getKnowledgeNodes());
            model.addAttribute("parents", getParents(knowledgeNode));
        });
        if (!optionalNode.isPresent()) {
            attachError(model);
            root(model);
        }
        return "admin.kn";
    }

    @PostMapping(value = "/admin/kb/", consumes = {"application/x-www-form-urlencoded"})
    public String createRootNode(Model model, KnowledgeNode newNode) {
        newNode.setParentNode(null);
        dao.save(newNode);
        return root(model);
    }

    @PostMapping(value = "/admin/kb/{id}", consumes = {"application/x-www-form-urlencoded"})
    public String createNode(Model model, KnowledgeNode newNode, @PathVariable Long id) {
        dao.findById(id).ifPresent(knowledgeNode -> {
            newNode.setParentNode(knowledgeNode);
            newNode.setId(null);
            dao.save(newNode);
        });
        return node(model, id);
    }

    @PutMapping(value = "/admin/kb/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateNode(@PathVariable("id") Long nodeId,
                             @RequestBody KnowledgeNode updatedNode,
                             Model model) {
        dao.findById(nodeId).ifPresent(dbNode -> {
            boolean recordChanged = false;
            if (StringUtils.changedToNotEmpty(dbNode.getAnswer(), updatedNode.getAnswer())) {
                dbNode.setAnswer(updatedNode.getAnswer());
                recordChanged = true;
            }
            if (StringUtils.changedToNotEmpty(dbNode.getNewQuestion(), updatedNode.getNewQuestion())) {
                dbNode.setNewQuestion(updatedNode.getNewQuestion());
                recordChanged = true;
            }
            if (StringUtils.changedToNotEmpty(dbNode.getName(), updatedNode.getName())) {
                dbNode.setName(updatedNode.getName());
                recordChanged = true;
            }
            if (recordChanged) {
                dao.save(dbNode);
            }
        });
        return node(model, nodeId);
    }

    @DeleteMapping(value = "/admin/kb/{id}/{strategy}")
    public String deleteNode(@PathVariable("id") Long nodeId,
                             @PathVariable("strategy") String strategy,
                             Model model) {
        System.out.println(strategy);
        if (applicationStatus.isDown()) {
            val optionalNode = dao.findById(nodeId);
            if (strategy != null
                    && strategy.contains("all")
                    && optionalNode.isPresent()) {
                deleteNodeCascade(optionalNode.get());
            } else if (strategy != null
                    && strategy.contains("nodeonly")
                    && optionalNode.isPresent()) {
                deleteNodeOnly(optionalNode.get());
            } else {
                throw new HTTPException(500);
            }
        } else {
            throw new HTTPException(500);
        }
        return node(model, nodeId);
    }

    private void deleteNodeCascade(KnowledgeNode knowledgeNode) {
        dao.delete(knowledgeNode);
    }

    private void deleteNodeOnly(KnowledgeNode knowledgeNode) {
        val children = dao
                .findKnowledgeNodesByParentNodeId(knowledgeNode.getId());
        if (children != null) {
            children.forEach(child -> child.setParentNode(knowledgeNode.getParentNode()));
        }
        dao.saveAll(children);
        dao.delete(knowledgeNode);
    }

    private List<KnowledgeNode> getParents(KnowledgeNode knowledgeNode) {
        val result = new LinkedList<KnowledgeNode>();
        for (KnowledgeNode node = knowledgeNode.getParentNode();
             node != null;
             node = node.getParentNode()) {
            result.addFirst(node);
        }
        return result;
    }
}
