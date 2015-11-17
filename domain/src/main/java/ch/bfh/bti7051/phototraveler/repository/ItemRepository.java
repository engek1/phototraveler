package ch.bfh.bti7051.phototraveler.repository;

import ch.bfh.bti7051.phototraveler.model.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Kaspar on 17.11.2015.
 */
public interface ItemRepository extends CrudRepository<Item, Long> {
}
