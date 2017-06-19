package ro.upb.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by radug on 6/19/2017.
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //Functii rep
    public void addUser(User user){
        userRepository.save(user);
    }

    //Functii cautare

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
