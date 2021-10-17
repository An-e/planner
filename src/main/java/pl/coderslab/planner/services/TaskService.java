package pl.coderslab.planner.services;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import pl.coderslab.planner.model.Task;
import pl.coderslab.planner.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TaskService {
    Optional<Task> get(Long id);

    List<Task> getTasks();

    void addTask(Task task);

    List<String> getDatesForUser(String id);

    List<Task> getTasksForUser(String id);

    List<Task> getTasksForDay();

    void deleteTask(String id);
}
