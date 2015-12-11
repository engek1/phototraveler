package ch.bfh.bti7051.phototraveler.service.services;

import ch.bfh.bti7051.phototraveler.service.dto.UserDTO;

import java.util.Collection;

/**
 * Created by Lukas on 08.12.2015.
 */
public interface UserService {

    public UserDTO create(UserDTO dto);

    public UserDTO read(long id);

    public UserDTO update(UserDTO dto);

    public void delete(UserDTO dto);
}
