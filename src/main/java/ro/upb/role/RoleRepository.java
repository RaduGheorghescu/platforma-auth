package ro.upb.role;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by radug on 6/19/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
