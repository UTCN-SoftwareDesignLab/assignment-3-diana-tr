package ro.utcn.sd.assignmentthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.assignmentthree.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    void deleteByUsername(String username);

    void deleteById(Long id);

    User findByUsernameAndPassword(String username, String password);
}
