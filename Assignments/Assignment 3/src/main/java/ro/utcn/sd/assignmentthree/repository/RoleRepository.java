package ro.utcn.sd.assignmentthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.assignmentthree.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}