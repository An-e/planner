package pl.coderslab.planner.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.planner.model.Category;
import pl.coderslab.planner.model.Priority;
import pl.coderslab.planner.model.Task;
import pl.coderslab.planner.model.User;
import pl.coderslab.planner.repository.UserRepository;
import pl.coderslab.planner.services.TaskService;
import pl.coderslab.planner.services.UserService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/sharedplanner")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    List<User> all() {
        return userService.getUsers();
    }

    @PostMapping(value = "/users/add")
    public void saveTask(@RequestBody User user) {
        System.out.println(user.getFirstName());

        userService.addUser(user);
    }
}
