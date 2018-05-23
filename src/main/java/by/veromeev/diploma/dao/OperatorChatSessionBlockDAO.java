package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.OperatorChatSessionBlock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorChatSessionBlockDAO extends PagingAndSortingRepository<OperatorChatSessionBlock, Long> {
}
