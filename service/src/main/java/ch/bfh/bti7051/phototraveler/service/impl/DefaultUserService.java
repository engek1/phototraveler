package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.User;
import ch.bfh.bti7051.phototraveler.repository.UserRepository;
import ch.bfh.bti7051.phototraveler.service.services.UserService;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by webel3 on 08.12.2015.
 */
@Named
public class DefaultUserService implements UserService {
    
    @Inject
    private UserRepository userRepository;

    public DefaultUserService() {
        // default empty constructor, required by spring framework.
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User read(long id) {
        return userRepository.findOne(id);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
