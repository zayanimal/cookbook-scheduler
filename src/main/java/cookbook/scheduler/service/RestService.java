package cookbook.scheduler.service;

import cookbook.scheduler.dto.TelegramResponse;
import org.springframework.http.ResponseEntity;

public interface RestService {

    ResponseEntity<TelegramResponse> sendTelegramMessage(String message);
}
