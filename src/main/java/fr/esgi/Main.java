package fr.esgi;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {

        Log log = new Log();
        log.setLevel(LEVEL.INFO);
        Log log2 = new Log();
        log2.setLevel(LEVEL.INFO);

        System.out.println(log2);
        System.out.println(log);
        log.setLevel(LEVEL.INFO);


        Log[] logs = new Log[2];
        logs[0] = log;
        logs[1] = log2;

        List<Log> logList = new ArrayList<>();
        logList.add(log);
        logList.add(log2);

        for (Log current : logList) {
            System.out.println(current);
        }
    }

}
