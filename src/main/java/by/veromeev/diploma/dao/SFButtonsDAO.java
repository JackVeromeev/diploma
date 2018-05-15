package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.SFButtons;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SFButtonsDAO extends CrudRepository<SFButtons, Long> {

}
