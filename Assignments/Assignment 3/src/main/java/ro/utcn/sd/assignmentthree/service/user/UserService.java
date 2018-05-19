package ro.utcn.sd.assignmentthree.service.user;

import ro.utcn.sd.assignmentthree.dto.UserDto;
import ro.utcn.sd.assignmentthree.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User create(UserDto userDto);

    void delete(UserDto userDto);

    void update(User user);

    User findByUsername(String username);

    User findById(Long id);

    User findByUsernameAndPassword(String username, String password);

    void deleteByUsername(String username);

    void deleteById(Long id);
}
