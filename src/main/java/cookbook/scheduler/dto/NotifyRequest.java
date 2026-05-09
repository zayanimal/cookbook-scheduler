package cookbook.scheduler.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NotifyRequest {

    private String type;

    private String message;

    private LocalDateTime executionDateTime;
}
