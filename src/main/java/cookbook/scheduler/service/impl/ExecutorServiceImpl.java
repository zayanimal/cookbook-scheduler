package cookbook.scheduler.service.impl;

import cookbook.scheduler.entity.ScheduledTask;
import cookbook.scheduler.notifier.NotifierRouter;
import cookbook.scheduler.repository.TaskJpaRepository;
import cookbook.scheduler.service.ExecutorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import static cookbook.scheduler.notifier.enums.NotifyType.of;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExecutorServiceImpl implements ExecutorService {

    private final NotifierRouter notifierRouter;

    private final TaskJpaRepository taskRepository;

    private final ThreadPoolTaskExecutor scheduledTaskExecutor;

    @Override
    public void execute(ScheduledTask task) {
        scheduledTaskExecutor.execute(() -> {
            try {
                notifierRouter.sendNotification(of(task.getType()), task.getMessage());
                log.info("Выполнена задача {}", task);
                taskRepository.deleteById(task.getId());
            } catch (Exception e) {
                log.error("Во время выполнения задания произошла ошибка {}", e.getMessage(), e);
            }
        });
    }
}
