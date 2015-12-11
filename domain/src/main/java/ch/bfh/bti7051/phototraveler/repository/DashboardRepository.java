package ch.bfh.bti7051.phototraveler.repository;

import ch.bfh.bti7051.phototraveler.model.Dashboard;
import ch.bfh.bti7051.phototraveler.model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lukas on 11.12.2015.
 */
public interface DashboardRepository extends CrudRepository<Dashboard, Long> {
}
