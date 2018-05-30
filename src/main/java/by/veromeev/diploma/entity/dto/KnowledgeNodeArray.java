package by.veromeev.diploma.entity.dto;

import by.veromeev.diploma.entity.KnowledgeNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class KnowledgeNodeArray {
    KnowledgeNode[] nodes;
}
