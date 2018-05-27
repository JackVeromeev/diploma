package by.veromeev.diploma.dao;

import by.veromeev.diploma.entity.MaintenanceSchedule;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MaintenanceScheduleDAO extends PagingAndSortingRepository<MaintenanceSchedule, Long> {
}
