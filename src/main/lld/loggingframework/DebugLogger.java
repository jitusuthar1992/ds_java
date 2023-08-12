package main.lld.loggingframework;

public class DebugLogger extends AbstractLogger{
    public DebugLogger(int level) {
        super(level);
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
        String message =  "Debug : "+msg ;
        logSubject.notifyAllObservers(1,message);
    }
}
