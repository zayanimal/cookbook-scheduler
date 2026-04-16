package cookbook.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TelegramRequest {

    private String text;

    @JsonProperty("chat_id")
    private String chatId;
}
