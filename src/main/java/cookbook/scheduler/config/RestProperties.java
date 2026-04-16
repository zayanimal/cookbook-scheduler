package cookbook.scheduler.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "telegram")
public class RestProperties {

    private String telegramUrl;

    private String telegramChatId;
}
