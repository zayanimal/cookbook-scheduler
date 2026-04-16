package cookbook.scheduler.service;

import cookbook.scheduler.entity.ScheduledTask;

public interface ExecutorService {

    void execute(ScheduledTask task);
}
