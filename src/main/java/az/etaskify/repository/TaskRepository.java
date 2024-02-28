package az.etaskify.repository;

import az.etaskify.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

//    @Query("SELECT t FROM Task t " +
//            "JOIN User u " +
//            "JOIN u.organization o " +
//            "WHERE o.id = :organizationId")
//    List<Task> findTasksByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
    List<Task> findTasksByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Task t " +
            "JOIN User u " +
            "JOIN u.organization o " +
            "WHERE o.id = :organizationId")
    List<Task> findTasksByOrganizationId(@Param("organizationId") Long organizationId);


}
