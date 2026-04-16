package cookbook.scheduler.repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import cookbook.scheduler.entity.ScheduledTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskJpaRepository extends JpaRepository<ScheduledTask, UUID> {

    List<ScheduledTask> findAllByExecutionDateOrderByExecutionTimeAsc(Date executionDate);
}
