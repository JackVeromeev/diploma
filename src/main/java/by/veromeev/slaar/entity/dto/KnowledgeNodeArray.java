package by.veromeev.slaar.entity.dto;

import by.veromeev.slaar.entity.KnowledgeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KnowledgeNodeArray {
    KnowledgeNode[] nodes;
}
