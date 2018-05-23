package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.KnowledgeNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KnowledgeNodeDAO extends CrudRepository<KnowledgeNode, Long> {

    List<KnowledgeNode> findKnowledgeNodesByParentNodeId(Long parentNodeId);

}
