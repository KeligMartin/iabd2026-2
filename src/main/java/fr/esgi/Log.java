package fr.esgi;

import java.time.LocalDateTime;

public class Log<T extends Readable> implements ILog {

    private T source;
    private String action;
    private LocalDateTime timestamp;
    private LEVEL level;

    public Log(T source, String action, LocalDateTime timestamp, LEVEL level) {
        this.source = source;
        this.action = action;
        this.timestamp = timestamp;
        this.level = level;
    }

    public Log() {}

    public String getMessage() {
        return this.source.getBody();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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


    public boolean learn() {
        Double rand = Math.random();
        System.out.println("hmmm j'adore apprendre");
        if(rand > 0.5) {
            throw new RuntimeException("erreur");
        }
        if (rand > 1) {
            throw new ArithmeticException("tricheur");
        }
        return true;
    }
}
