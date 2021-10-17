package pl.coderslab.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.planner.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
