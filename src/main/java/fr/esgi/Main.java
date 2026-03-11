package fr.esgi;

import java.time.LocalDateTime;

public class Main {

    static void main() {

        ServerResponse response = new ServerResponse("OOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKK", 200);
        response.setTimestamp(LocalDateTime.now().plusHours(10));
        RabbitResponse responseRabbit = new RabbitResponse("OK");
        Log<Readable> log = new Log<>(response, "Clic", LEVEL.INFO);

        System.out.println(log.getTimestamp());
    }
}
