package cookbook.scheduler.notifier.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotifyType {

    EMAIL("email"),

    TELEGRAM("telegram");

    private final String type;

    public static NotifyType of(String name) {
        return Arrays.stream(values())
            .filter(v -> v.getType().equals(name))
            .findFirst()
            .orElseThrow();
    }
}
