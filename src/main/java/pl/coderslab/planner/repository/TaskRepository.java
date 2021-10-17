package pl.coderslab.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.planner.model.Task;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.user.id = :id")
    List<Task> findTasksForUser(@Param("id") Long id);
}
