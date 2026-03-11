package fr.esgi;

import java.time.LocalDateTime;

public abstract class Readable {

    protected String body;
    private LocalDateTime timestamp;

    public Readable(String body) {
        this.body = body;
        this.timestamp = LocalDateTime.now();
    }

    public abstract String getBody();

    public Integer getHttpStatus() {
        return 0;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
