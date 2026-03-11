package fr.esgi;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    static void main() {

        ServerResponse response = new ServerResponse("OK", 200);
        RabbitResponse responseRabbit = new RabbitResponse("OK");
        Log<Readable> log = new Log<>(response, "Clic", LocalDateTime.now(), LEVEL.INFO);

        Log<Readable> log2 = new Log<>(responseRabbit, "message", LocalDateTime.now(), LEVEL.INFO);

        List<Log<Readable>> logs = List.of(log, log2);

        String status = "Demarrage";
        System.out.println(status);
        try {

            status = "En cours d'apprentissage";
            System.out.println(status);
            log.learn(); // erreur apparue je m'arrête la
            status = "Fin";
        } catch (RuntimeException e) { // catch segfault()
            System.out.println("Index out of bounds");
            status = "Erreur";
        }
        finally {
            System.out.println("status final " + status);
        }
    }
}
