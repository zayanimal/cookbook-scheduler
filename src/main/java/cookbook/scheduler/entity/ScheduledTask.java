package cookbook.scheduler.entity;

import cookbook.scheduler.constant.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(schema = "SCHEDULER", name = "TASKS")
public class ScheduledTask {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "task_type")
    private String type;

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    private TaskStatus status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "execution_date")
    private Date executionDate;

    @Column(name = "execution_time")
    private Time executionTime;
}
