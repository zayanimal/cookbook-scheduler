package cookbook.scheduler.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotifyResponse {

    private String message;

    private boolean success;
}
