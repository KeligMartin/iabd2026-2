package fr.esgi;

import java.time.LocalDateTime;

public class Log implements ILog {

    private String message;
    private String action;
    private LocalDateTime timestamp;
    private Integer code;
    private LEVEL level;

    public Log(String message, String action, LocalDateTime timestamp, Integer code, LEVEL level) {
        this.message = message;
        this.action = action;
        this.timestamp = timestamp;
        this.code = code;
        this.level = level;
    }

    public Log() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
}
