package fr.esgi;

import java.util.*;

public class Main {

    static void main() {

        Log log = new Log();
        log.setLevel(LEVEL.INFO);
        log.setMessage("Log numero 1");
        Log log2 = new Log();
        log2.setLevel(LEVEL.INFO);
        log2.setMessage("Log numero 2");

        log.setLevel(LEVEL.INFO);
        List<Log> logList = new ArrayList<>();
        logList.add(log);
        logList.add(log2);
        logList.add(log);

        Set<Log> logSet = new HashSet<>();
        logSet.add(log);
        logSet.add(log2);

        Map<LEVEL, Integer> logByLevel = new HashMap<>();

        // parcourir notre liste de logs
        // alimenter la map pour avoir des statistiques sur les logs
        // en fonction de leur LEVEL

        for (Log current : logList) {
            var tmp = logByLevel.get(current.getLevel());
            if(tmp == null) {
                tmp = 0;
            }
            logByLevel.put(current.getLevel(), tmp + 1);
            System.out.println("ok tg");
        }

        System.out.println(logByLevel);
    }
}
