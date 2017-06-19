package ro.upb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ro.upb.role.Role;
import ro.upb.role.RoleService;
import ro.upb.user.User;
import ro.upb.user.UserService;

/**
 * Created by Radu on 4/21/2017.
 */
@Component
public class IncarcareDB implements ApplicationRunner {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public IncarcareDB(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        User user = userService.findByEmail("radu.gheorghescu@eestec.ro");
        if (user == null){
            roleService.addRole(new Role("ROLE_ADMIN"));
            //Ai gasit!
            user = new User("radu.gheorghescu@eestec.ro","radueadmin",
                    "Radu","Gheorghescu", roleService.findByRoleName("ROLE_ADMIN"));
            userService.addUser(user);
        }
    }
}
