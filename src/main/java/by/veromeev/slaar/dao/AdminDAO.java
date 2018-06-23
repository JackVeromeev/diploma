package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.AdminDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends CrudRepository<AdminDetails, Long> {

    AdminDetails findAdminDetailsByUsername(String username);

}
