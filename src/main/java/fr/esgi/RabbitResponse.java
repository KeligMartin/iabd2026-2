package fr.esgi;

public class RabbitResponse extends Readable {

    public RabbitResponse(String body) {
        super(body);
    }

    @Override
    public String getBody() {
        return "reponse de rabbit";
    }
}
