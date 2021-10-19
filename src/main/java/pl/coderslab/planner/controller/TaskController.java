package pl.coderslab.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.planner.model.*;
import pl.coderslab.planner.repository.UserRepository;
import pl.coderslab.planner.services.TaskService;
import pl.coderslab.planner.services.UserService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/sharedplanner")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/calendar")
    List<String> allDays(@RequestParam String id) {
        return taskService.getDatesForUser(id);
    }

    @RequestMapping("/usertasks")
    List<Task> tasksForUser (@RequestParam String id) {
        return taskService.getTasksForUser(id);
    }

    @GetMapping("/usertasks/date")
    List<Task> tasksForDate () {
        return taskService.getTasksForDay();
    }

    @GetMapping("/usertasks/task/delete")
    void deleteTask (@RequestParam String id) {
        taskService.deleteTask(id);
    }

    @PostMapping(value = "/usertasks/add")
    public void saveTask(@RequestBody Task task) {

        taskService.addTask(task);
    }

    @PostMapping(value = "/tasks/add")
    public TaskDao saveTask(@RequestBody TaskDao task) {

        return task;
    }


}
