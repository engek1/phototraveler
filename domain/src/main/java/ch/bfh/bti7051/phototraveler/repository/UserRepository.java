package ch.bfh.bti7051.phototraveler.repository;

import ch.bfh.bti7051.phototraveler.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Lukas on 11.12.2015.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
