package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.model.User;

/**
 * Created by webel3 on 08.12.2015.
 */
public interface UserService {

    public User create(User user);

    public User read(long id);

    public User update(User user);

    public void delete(User user);
}
