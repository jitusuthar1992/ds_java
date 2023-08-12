package main.lld.loggingframework;

public class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        super(level);
    }

    @Override
    protected void display(String msg, LogSubject logSubject) {
        String message =  "Error : "+msg ;
        logSubject.notifyAllObservers(2,message);
    }
}
