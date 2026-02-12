package fr.esgi;

public class ServerResponse extends Readable {

    private Integer httpStatus;

    public ServerResponse(String body, Integer httpStatus) {
        super(body);
        this.httpStatus = httpStatus;
    }

    @Override
    public String getBody() {
        return String.format("%s - %s", this.body, this.httpStatus);
    }
}
