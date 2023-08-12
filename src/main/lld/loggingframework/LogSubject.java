package main.lld.loggingframework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {

    Map<Integer,List<LogObserver>> logObservers = new HashMap<>();


    public void addObserver(int level, LogObserver logObserver){
      List<LogObserver> logObserverList = logObservers.getOrDefault(level,new ArrayList<>());
      logObserverList.add(logObserver);
      logObservers.put(level,logObserverList);
    }

    public void removeObserver(int level, LogObserver logObserver){
        List<LogObserver> logObserverList = logObservers.getOrDefault(level,new ArrayList<>());
        logObserverList.remove(logObserver);
    }

    void notifyAllObservers(int level , String msg){
        logObservers.forEach((lvl,logObserversList)->{
            if(level == lvl){
                logObserversList.forEach(logObserver -> logObserver.log(msg));
            }
        });
    }
}
