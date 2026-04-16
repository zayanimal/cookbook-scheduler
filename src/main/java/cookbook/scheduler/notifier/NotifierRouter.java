package cookbook.scheduler.notifier;

import cookbook.scheduler.notifier.enums.NotifyType;

public interface NotifierRouter {

    void sendNotification(NotifyType type, String message);
}
