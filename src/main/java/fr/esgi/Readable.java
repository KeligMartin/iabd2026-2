package fr.esgi;

public abstract class Readable {

    protected String body;

    public Readable(String body) {
        this.body = body;
    }

    public abstract String getBody();

    public String getHttpStatus() {
        return "";
    }
}
