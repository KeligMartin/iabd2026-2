package fr.esgi;

import java.util.*;

public class Main {

    static void main() {

        Log log = new Log();
        log.setLevel(LEVEL.INFO);
        Log log2 = new Log();
        log2.setLevel(LEVEL.INFO);

        log.setLevel(LEVEL.INFO);
        List<Log> logList = new ArrayList<>();
        logList.add(log);
        logList.add(log2);
        logList.add(log);

        System.out.println(logList);

        Set<Log> logSet = new HashSet<>();
        logSet.add(log);
        logSet.add(log2);
        System.out.println(logSet.add(log));
        System.out.println(logSet);


        Map<LEVEL, Integer> logByLevel = new HashMap<>();
        logByLevel.put(LEVEL.INFO, 10);
        logByLevel.put(LEVEL.WARN, 6);
        logByLevel.put(LEVEL.ERROR, 4012);

        System.out.println(logByLevel);
    }
}
