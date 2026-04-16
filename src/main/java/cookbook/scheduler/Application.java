package cookbook.scheduler;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        val dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach(entry -> {
            val key = entry.getKey();

            if (System.getenv(key) == null) {
                System.setProperty(key, dotenv.get(key));
            }
        });

        SpringApplication.run(Application.class, args);
    }
}
