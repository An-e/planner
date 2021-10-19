package pl.coderslab.planner.services;

import pl.coderslab.planner.model.Task;
import pl.coderslab.planner.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> get(Long id);

    List<User> getUsers();

    void addUser(User user);
}
