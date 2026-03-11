package fr.esgi;

import java.time.LocalDateTime;

public class Log<T extends Readable> implements ILog {

    private final Integer MAX_BODY_LENGTH = 50;

    private T source;
    private String action;
    private LocalDateTime timestamp;
    private LEVEL level;
    private String message;

    public Log(T source, String action, LEVEL level) {
        this.source = source;
        this.action = action;
        this.level = level;
        try {
            this.setMessage();
        } catch (TooLongBodyException e) {
            this.message = source.getBody().substring(0, MAX_BODY_LENGTH);
        }
        try {
            this.setTimestamp();
        } catch (FutureTimeStampException e) {
            System.out.println(String.format("Le timestamp de %s est dans le futur", source.getTimestamp()));
            this.timestamp = LocalDateTime.now();
            System.out.println("Timestamp réparé");
        }
    }

    public Log() {}

    public String getMessage() {
        return this.message;
    }

    public void setMessage() {
        if (this.source.getBody().length() > MAX_BODY_LENGTH) {
            throw new TooLongBodyException("Le message est trop long");
        }
        this.message = source.getBody();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() throws RuntimeException {
        return timestamp;
    }

    public void setTimestamp() {
        if(source.getTimestamp().isAfter(LocalDateTime.now())) {
            throw new FutureTimeStampException("Le timestamp ne peut pas être dans le futur");
        }
        this.timestamp = source.getTimestamp();
    }

    public LEVEL getLevel() {
        return level;
    }

    public void setLevel(LEVEL level) {
        this.level = level;
    }

    public boolean isSuccess() {
        return this.getLevel() != LEVEL.ERROR;
    }

    @Override
    public boolean isError() {
        return !this.isSuccess();
    }

    public void greet() {
        System.out.println("Hello World !");
    }
}
