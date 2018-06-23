package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.BotChatSessionBlock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BotChatSessionBlockDAO extends PagingAndSortingRepository<BotChatSessionBlock, Long> {

    List<BotChatSessionBlock> findBotChatSessionBlocksByChatSessionId(Long chatSessionId);

}
