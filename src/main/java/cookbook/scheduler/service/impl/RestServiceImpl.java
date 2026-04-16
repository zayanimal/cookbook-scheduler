package cookbook.scheduler.service.impl;

import static cookbook.scheduler.constant.Endpoint.SEND_MESSAGE;

import cookbook.scheduler.config.RestProperties;
import cookbook.scheduler.dto.TelegramRequest;
import cookbook.scheduler.dto.TelegramResponse;
import cookbook.scheduler.service.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
public class RestServiceImpl implements RestService {

    private final RestProperties properties;

    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<TelegramResponse> sendTelegramMessage(String message) {
        return restTemplate.postForEntity(getTelegramUrl(), TelegramRequest.builder()
            .text(message)
            .chatId(properties.getTelegramChatId())
            .build(), TelegramResponse.class);
    }

    private String getTelegramUrl() {
        return properties.getTelegramUrl().concat(SEND_MESSAGE);
    }
}
