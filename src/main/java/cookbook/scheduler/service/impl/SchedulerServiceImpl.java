package cookbook.scheduler.service.impl;

import cookbook.scheduler.dto.NotifyRequest;
import cookbook.scheduler.notifier.NotifierRouter;
import cookbook.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.stereotype.Service;

import static cookbook.scheduler.notifier.enums.NotifyType.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    private final JobScheduler jobScheduler;

    private final NotifierRouter notifierRouter;

    @Override
    public void schedule(NotifyRequest request) {
        jobScheduler.schedule(request.getExecutionDateTime(), () ->
            notifierRouter.sendNotification(of(request.getType()), request.getMessage()));
    }
}
