package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.BotChatMessagePair;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BotChatMessagePairDAO extends PagingAndSortingRepository<BotChatMessagePair, Long> {

    List<BotChatMessagePair> findBotChatMessagePairsBySessionBlockId(Long SessionBlockId);

}
