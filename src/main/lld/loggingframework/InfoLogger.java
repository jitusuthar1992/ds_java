package main.lld.loggingframework;

public class InfoLogger extends AbstractLogger{
    public InfoLogger(int level) {
        super(level);
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
       String message =  "Info : "+msg ;
       logSubject.notifyAllObservers(1,message);
    }
}
