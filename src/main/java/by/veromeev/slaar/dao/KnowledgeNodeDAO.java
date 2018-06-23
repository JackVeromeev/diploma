package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.KnowledgeNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeNodeDAO extends CrudRepository<KnowledgeNode, Long> {

    List<KnowledgeNode> findKnowledgeNodesByParentNodeId(Long parentNodeId);

    default List<KnowledgeNode> findRootNodes() {
        return findKnowledgeNodesByParentNodeId(null);
    }

    List<KnowledgeNode> findKnowledgeNodesByIsSpecial(Boolean special);

    default List<KnowledgeNode> findSpecial() {
        return findKnowledgeNodesByIsSpecial(true);
    }

}
