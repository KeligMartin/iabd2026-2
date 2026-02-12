package fr.esgi;

import java.util.ArrayList;
import java.util.List;

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
        List<Log> successLogs = new ArrayList<>();
        var successCount = 0;

        for (Log current : logList) {
           if (current.isSuccess()) {
               successLogs.add(current);
               successCount++;
           }
        }
        System.out.println(successLogs);
    }
}
