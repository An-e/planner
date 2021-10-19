package pl.coderslab.planner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import pl.coderslab.planner.model.Task;
import pl.coderslab.planner.repository.TaskRepository;
import pl.coderslab.planner.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class JpaTaskService implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public JpaTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

//    @Override
//    public List<String> getDatesForUser(String id) {
//        Query query = entityManager.createQuery("SELECT t FROM Task t WHERE user_id = id");
//        return query.getResultList();
//    }

    @Override
    public List<String> getDatesForUser(String id) {
        return taskRepository.findDatesForUser(Long.valueOf(id))
                .stream()
                .map(day -> DateTimeFormatter.ISO_LOCAL_DATE.format(day.toLocalDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getTasksForUser(String id) {
        return taskRepository.findTasksForUser(Long.valueOf(id));
    }

//    @Override
//    public List<Task> getTasksForDay() {
//        return taskRepository.findAll()
//                .stream().filter(
//                task -> task.getTitle().equals("work")
//        ).collect(Collectors.toList());
//    }
//
    @Override
    public List<Task> getTasksForDay() {
        return taskRepository.findAll()
                .stream()
                .filter(task -> task.getStartDate().toLocalDate().isEqual(LocalDate.of(2021, 10, 19)))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(String id) {
        taskRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void addTask(Task task) {
        taskRepository.save(task);
    }
}
