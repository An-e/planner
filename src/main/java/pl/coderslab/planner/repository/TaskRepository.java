package pl.coderslab.planner.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.planner.model.Task;
import pl.coderslab.planner.model.User;

import javax.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t.startDate from Task t where t.user.id = :id")
    Task[] findTasksForUser(@Param("id") Long id);
}
