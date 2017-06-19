package ro.upb.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by radug on 6/19/2017.
 */
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
