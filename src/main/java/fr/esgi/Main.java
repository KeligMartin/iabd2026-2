package fr.esgi;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {

    static void main() {

        ServerResponse response = new ServerResponse("OOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKKOOOOOOOOOKKKKKKKKK", 200);
        response.setTimestamp(LocalDateTime.now().plusHours(10));
        RabbitResponse responseRabbit = new RabbitResponse("OK");
        Log<Readable> log = new Log<>(response, "Clic", LEVEL.WARN);
        Log<Readable> logRabbit = new Log<>(responseRabbit, "Clic", LEVEL.INFO);

        List<Log<Readable>> logList = List.of(log, logRabbit);


        Consumer<Log<Readable>> printMessage = (l) -> System.out.println(l.getMessage());

        Predicate<Log<Readable>> isInfo = (l) -> l.getLevel() == LEVEL.INFO;

        logList
                .forEach(printMessage); // fini

        logList
                .stream()
                .filter(isInfo)
                .forEach(printMessage);
    }
}
