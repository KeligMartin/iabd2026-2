package fr.esgi;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static void main() {






        ServerResponse response = new ServerResponse("Reponse 1", 200);
        ServerResponse response2 = new ServerResponse("Reponse 2", 200);
        ServerResponse response3 = new ServerResponse("Reponse 3", 200);
        ServerResponse response4 = new ServerResponse("Reponse 4", 500);
        ServerResponse response5 = new ServerResponse("Reponse 5", 500);

        response.setTimestamp(LocalDateTime.now().plusHours(10));
        RabbitResponse responseRabbit = new RabbitResponse("OK");
        RabbitResponse responseRabbit2 = new RabbitResponse("null");
        RabbitResponse responseRabbit3 = new RabbitResponse("test");

        Log<Readable> log = new Log<>(response, "Clic 1", LEVEL.WARN);
        Log<Readable> logRabbit = new Log<>(responseRabbit, "Clic 2", LEVEL.INFO);
        Log<Readable> logError = new Log<>(response3, "Clic 3", LEVEL.ERROR);
        Log<Readable> logError2 = new Log<>(response2, "Clic 4", LEVEL.ERROR);
        Log<Readable> logError3 = new Log<>(response4, "Clic 5", LEVEL.ERROR);
        Log<Readable> warnRabbit = new Log<>(response5, "Clic 6", LEVEL.WARN);
        Log<Readable> infoRabbit = new Log<>(responseRabbit2, "Clic 7", LEVEL.INFO);
        Log<Readable> errorRabbit = new Log<>(responseRabbit3, "Clic 8", LEVEL.ERROR);

        List<Log<Readable>> logList = List.of(log, logRabbit, logError, logError2, logError3, warnRabbit, infoRabbit, errorRabbit);

        Predicate<Log<Readable>> isNew = l -> l.getTimestamp().isAfter(LocalDateTime.now().minusMonths(1));

        Comparator<Log<?>> statusSort = Comparator.comparingInt(
                (Log<?> l) -> l.getSource().getHttpStatus()
        ).thenComparing(Log::getTimestamp);

        // Sortie de base
        System.out.println("====== SORTIE DE BASE ======");

        logList.forEach(l -> System.out.println(l.getMessage()));

        System.out.println("====== SORTIE DU STREAM ======");

        Stream<Log<Readable>> logStream = logList
                .stream()
                .filter(isNew)
                .sorted(statusSort);
    }
}
