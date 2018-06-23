package by.veromeev.slaar.parser;

import by.veromeev.slaar.entity.dto.KnowledgeNodeArray;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeNodeParsingService {

    @AllArgsConstructor
    public enum DocumentType {
        XML(new XmlKnowledgeNodeParser()),
        JSON(new JsonKnowledgeNodeParser());

        private KnowledgeNodeParser parser;

        KnowledgeNodeArray parse(String data) {
            return this.parser.parse(data);
        }
    }

    public KnowledgeNodeArray parse(DocumentType documentType, String data) {
        return documentType.parse(data);
    }

}
