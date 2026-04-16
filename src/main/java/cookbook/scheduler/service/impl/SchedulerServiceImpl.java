package cookbook.scheduler.service.impl;

import static java.lang.StrictMath.abs;
import static java.util.Comparator.comparingLong;

import java.sql.Date;
import java.util.stream.Collectors;

import cookbook.scheduler.entity.ScheduledTask;
import cookbook.scheduler.repository.TaskJpaRepository;
import cookbook.scheduler.service.ExecutorService;
import cookbook.scheduler.service.SchedulerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    private final ExecutorService executorService;

    private final TaskJpaRepository taskRepository;

    @Override
    @Scheduled(fixedDelay = 5000)
    public void fetchTasksFromDb() {
        val currentTime = System.currentTimeMillis();
        val tasks = taskRepository.findAllByExecutionDateOrderByExecutionTimeAsc(new Date(currentTime))
            .stream()
            .sorted(comparingLong(task -> abs(task.getExecutionTime().getTime() - currentTime)))
            .limit(10)
            .peek(executorService::execute)
            .map(ScheduledTask::getMessage)
            .collect(Collectors.joining(", "));

        if (!tasks.isBlank()) {
            log.info("Установлены задачи на исполнение: {}", tasks);
        }

        log.info("Нет задач на исполнение");
    }
}
