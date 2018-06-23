package by.veromeev.slaar.parser;

import by.veromeev.slaar.entity.dto.KnowledgeNodeArray;

interface KnowledgeNodeParser {
    KnowledgeNodeArray parse(String data);
}
