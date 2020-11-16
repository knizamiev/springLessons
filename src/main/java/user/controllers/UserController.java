package user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import user.dao.UserService;
import user.model.User;

import java.util.List;

@RestController
@RequestMapping("/people")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> getAllPeople(){
        return userService.readAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        System.out.println(user.toString());
        userService.saveUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user){
        userService.delete(user);
    }

    //patch more
}
