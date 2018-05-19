package ro.utcn.sd.assignmentthree.dto;

import ro.utcn.sd.assignmentthree.entity.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDto {

    private Long id;

    @NotNull(message = "Please enter the username")
    @Size(min = 3, max = 45, message = "Username must be at least 3 characters")
    private String username;

    @NotNull(message = "Please enter the password")
    @Size(min = 3, max = 60, message = "Password must be at least 3 characters")
    private String password;

    private boolean enabled;

    private Set<Role> roles;

    //private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
