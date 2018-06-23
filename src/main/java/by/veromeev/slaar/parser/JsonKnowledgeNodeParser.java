package by.veromeev.slaar.parser;

import by.veromeev.slaar.entity.KnowledgeNode;
import by.veromeev.slaar.entity.dto.KnowledgeNodeArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class JsonKnowledgeNodeParser implements KnowledgeNodeParser {

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
