package by.veromeev.diploma.parser;

import by.veromeev.diploma.dao.KnowledgeNodeDAO;
import by.veromeev.diploma.entity.KnowledgeNode;
import by.veromeev.diploma.entity.dto.KnowledgeNodeArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class JsonKnowledgeNodeParser implements KnowledgeNodeParser {

    private KnowledgeNodeDAO knowledgeNodeDAO;

    @Autowired
    public JsonKnowledgeNodeParser(KnowledgeNodeDAO knowledgeNodeDAO) {
        this.knowledgeNodeDAO = knowledgeNodeDAO;
    }

    @Override
    public KnowledgeNodeArray parse(String data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        KnowledgeNodeArray parsedKnowledgeNodes =
                gson.fromJson(data, KnowledgeNodeArray.class);
        for (KnowledgeNode node : parsedKnowledgeNodes.getNodes()) {
            restoreParentRelations(node);
        }
        return parsedKnowledgeNodes;
    }

    private void restoreParentRelations(KnowledgeNode node) {
        if (!node.getKnowledgeNodes().isEmpty()) {
            node.getKnowledgeNodes().forEach(child -> {
                child.setParentNode(node);
                restoreParentRelations(child);
            });
        }
    }
}
