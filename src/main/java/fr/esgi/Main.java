package fr.esgi;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static void main() {

        ServerResponse response = new ServerResponse("OK", 200);
        RabbitResponse responseRabbit = new RabbitResponse("OK");
        Log<Readable> log = new Log<>(response, "Clic", LocalDateTime.now(), LEVEL.INFO);

        Log<Readable> log2 = new Log<>(responseRabbit, "message", LocalDateTime.now(), LEVEL.INFO);
        System.out.println(log.getMessage());
    }
}
