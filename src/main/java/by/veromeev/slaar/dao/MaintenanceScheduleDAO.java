package by.veromeev.slaar.dao;

import by.veromeev.slaar.entity.MaintenanceSchedule;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MaintenanceScheduleDAO extends PagingAndSortingRepository<MaintenanceSchedule, Long> {
}
