package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.OperatorChatMessage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorChatMessageDAO extends PagingAndSortingRepository<OperatorChatMessage, Long> {
}
