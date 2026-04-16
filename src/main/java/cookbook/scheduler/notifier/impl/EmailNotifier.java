package cookbook.scheduler.notifier.impl;

import cookbook.scheduler.notifier.Notifier;
import org.springframework.stereotype.Component;

@Component
public class EmailNotifier implements Notifier {

    @Override
    public void send(String message) {
        // добавить реализацию
    }
}
