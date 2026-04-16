package cookbook.scheduler.notifier.impl;

import cookbook.scheduler.exception.NotifierTypeNotFoundException;
import cookbook.scheduler.notifier.Notifier;
import cookbook.scheduler.notifier.NotifierRouter;
import cookbook.scheduler.notifier.enums.NotifyType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifierRouterImpl implements NotifierRouter {

    private final Notifier emailNotifier;

    private final Notifier telegramNotifier;

    @Override
    public void sendNotification(NotifyType type, String message) {
        switch (type) {
            case EMAIL -> emailNotifier.send(message);
            case TELEGRAM -> telegramNotifier.send(message);
            default -> throw new NotifierTypeNotFoundException("Не найден типа уведомления");
        }
    }
}
