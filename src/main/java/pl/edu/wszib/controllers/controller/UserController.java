package pl.edu.wszib.controllers.controller;

import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.controllers.models.User;
import pl.edu.wszib.controllers.models.UserRole;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> getAllUsers(){


        User user1 = new User();
        user1.setId(1);
        user1.setLogin("mateusz");
        user1.setPass("tajne");
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(UserRole.ADMIN);
        userRoleList.add(UserRole.CASHIER);
        user1.setRoles(userRoleList);

        User user2 = new User();
        user2.setId(2);
        user2.setLogin("janusz");
        user2.setPass("tajne098");
        List<UserRole> userRoleList2 = new ArrayList<>();
        userRoleList2.add(UserRole.STOREKEEPER);
        userRoleList2.add(UserRole.REPORTER);
        user2.setRoles(userRoleList);

        List<User> result = new ArrayList<>();
        result.add(user1);
        result.add(user2);

        return result;
    }
    //w klamerkach parametry z metody, endpoint
    @RequestMapping(value = "/user/{userRole}", method = RequestMethod.GET)
    public List<User> getUsersByRoleWithFilter(@PathVariable UserRole userRole,@RequestParam String loginFilter){
        System.out.println(userRole);
        System.out.println(loginFilter);

        User user1 = new User();
        user1.setId(1);
        user1.setLogin("mateusz");
        user1.setPass("tajne");
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList.add(UserRole.ADMIN);
        userRoleList.add(UserRole.CASHIER);
        user1.setRoles(userRoleList);


        List<User> result = new ArrayList<>();
        result.add(user1);



        return result;
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT)
    public User putUser(@RequestBody User user){ //przyjmuje body jako parametr

        System.out.println(user.getLogin());

        return user;
    }
}
