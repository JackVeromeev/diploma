package by.veromeev.diploma.parser;

import by.veromeev.diploma.entity.dto.KnowledgeNodeArray;

public interface KnowledgeNodeParser {
    KnowledgeNodeArray parse(String data);
}
