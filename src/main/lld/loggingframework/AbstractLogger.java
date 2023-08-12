package main.lld.loggingframework;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;

    public AbstractLogger(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public AbstractLogger getNextLoggingLevel() {
        return nextLoggingLevel;
    }

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    void logMessage(int level, String msg,LogSubject logSubject){
        if(this.level <= level){
            display(msg,logSubject);
        }
        if(nextLoggingLevel != null){
            this.nextLoggingLevel.logMessage(level,msg,logSubject);
        }

    }
    protected abstract void display(String msg,LogSubject logSubject);
}
