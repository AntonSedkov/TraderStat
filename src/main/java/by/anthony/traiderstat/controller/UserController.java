package by.anthony.traiderstat.controller;

import by.anthony.traiderstat.entity.User;
import by.anthony.traiderstat.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable long id) {
        return userService.findUserById(id).orElse(null);
    }

    @PatchMapping("/{id}:approved")
    public User approvedTrader(@PathVariable long id) {
        User user = userService.findUserById(id).orElse(null);
        if (user != null) {
            user.setApproved(true);
            userService.saveUser(user);
        }
        return user;
    }

}
