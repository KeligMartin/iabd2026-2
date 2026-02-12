package fr.esgi;

import java.time.LocalDateTime;

public class SuccessLog extends Log {

    public SuccessLog(String message, String action, LocalDateTime timestamp, Integer code, LEVEL level) {
        super(message, action, timestamp, code, level);
    }
}
