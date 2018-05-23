package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.AdminDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends CrudRepository<AdminDetails, Long> {

    AdminDetails findAdminDetailsByUsername(String username);

}
