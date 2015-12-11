package ch.bfh.bti7051.phototraveler.service.impl;

import ch.bfh.bti7051.phototraveler.model.User;
import ch.bfh.bti7051.phototraveler.repository.UserRepository;
import ch.bfh.bti7051.phototraveler.service.UserService;
import ch.bfh.bti7051.phototraveler.service.dto.UserDTO;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Lukas on 08.12.2015.
 */
@Named
public class DefaultUserService implements UserService {

    private final ModelMapper mapper = new ModelMapper();

    @Inject
    private UserRepository userRepository;

    public UserDTO create(UserDTO dto) {
        User user = mapper.map(dto, User.class);
        User created = userRepository.save(user);
        return mapper.map(created, UserDTO.class);
    }

    public UserDTO read(long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            return null;
        }
        return mapper.map(user, UserDTO.class);
    }

    public UserDTO update(UserDTO user) {
        User entity = userRepository.findOne(user.getId());
        mapper.map(user, entity);
        User updated = userRepository.save(entity);
        return mapper.map(updated, UserDTO.class);
    }

    public void delete(UserDTO dto) {
        userRepository.delete(dto.getId());
    }
}
