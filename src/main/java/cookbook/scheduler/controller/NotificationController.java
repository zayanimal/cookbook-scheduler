package cookbook.scheduler.controller;

import cookbook.scheduler.dto.NotifyRequest;
import cookbook.scheduler.dto.NotifyResponse;
import cookbook.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final SchedulerService schedulerService;

    @PostMapping("/schedule")
    public ResponseEntity<NotifyResponse> scheduleTask(@RequestBody NotifyRequest request) {
        schedulerService.schedule(request);

        return ResponseEntity.ok(NotifyResponse.builder()
            .success(true)
            .message("Задача успешно запланирована")
            .build());
    }
}
