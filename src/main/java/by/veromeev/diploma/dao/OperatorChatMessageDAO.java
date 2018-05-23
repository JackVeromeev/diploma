package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.OperatorChatMessage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorChatMessageDAO extends PagingAndSortingRepository<OperatorChatMessage, Long> {
}
