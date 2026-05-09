package cookbook.scheduler.service;

import cookbook.scheduler.dto.NotifyRequest;

public interface SchedulerService {

    void schedule(NotifyRequest request);
}
