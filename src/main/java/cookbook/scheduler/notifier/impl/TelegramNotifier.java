package cookbook.scheduler.notifier.impl;

import static java.util.Optional.of;

import cookbook.scheduler.dto.TelegramResponse;
import cookbook.scheduler.exception.TelegramMessageException;
import cookbook.scheduler.notifier.Notifier;
import cookbook.scheduler.service.RestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TelegramNotifier implements Notifier {

    private static final String ERROR_MESSAGE = "Ошибка отправки сообщения Telegram";

    private final RestService restService;

    @Override
    public void send(String message) {
        try {
            val response = restService.sendTelegramMessage(message);

            of(response)
                .map(ResponseEntity::getBody)
                .map(TelegramResponse::isOk)
                .filter(Boolean.TRUE::equals)
                .orElseThrow(() -> new TelegramMessageException(ERROR_MESSAGE));

            log.info("Сообщение: '{}' отправлено в телеграм", message);
        } catch (Exception e) {
            throw new TelegramMessageException(ERROR_MESSAGE, e);
        }
    }
}
