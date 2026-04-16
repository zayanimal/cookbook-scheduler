package cookbook.scheduler.config;

import cookbook.scheduler.service.RestService;
import cookbook.scheduler.service.impl.RestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(RestProperties.class)
public class RestConfiguration {

    private final RestProperties properties;

    @Bean
    public RestService restService() {
        return new RestServiceImpl(properties, restTemplate());
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
