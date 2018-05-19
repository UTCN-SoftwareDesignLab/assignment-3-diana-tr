package ro.utcn.sd.assignmentthree.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.assignmentthree.dto.UserDto;
import ro.utcn.sd.assignmentthree.entity.User;
import ro.utcn.sd.assignmentthree.repository.RoleRepository;
import ro.utcn.sd.assignmentthree.repository.UserRepository;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDto userDto) {
        User user = new User(userDto.getUsername(), bCryptPasswordEncoder.encode(userDto.getPassword()), true, userDto.getRoles());
        return userRepository.save(user);
    }

    @Override
    public void delete(UserDto userDto) {
        User user = new User(userDto.getUsername(), userDto.getPassword(), userDto.isEnabled(), userDto.getRoles());
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {

        User newUser = userRepository.getOne(user.getId());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEnabled(user.isEnabled());

        userRepository.save(newUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
