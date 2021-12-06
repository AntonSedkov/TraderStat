package by.anthony.traiderstat.service;

import by.anthony.traiderstat.entity.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> getAllUsers();

    User saveUser(User user);

    Optional<User> findUserById(long id);
}