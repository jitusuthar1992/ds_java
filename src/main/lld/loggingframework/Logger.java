package main.lld.loggingframework;

import java.io.Serializable;

public class Logger implements Cloneable, Serializable {
    private static volatile Logger logger;
    private volatile static AbstractLogger chainOfLogger;

    private volatile static LogSubject logSubject ;

    private Logger() {
        if(logger != null){
            throw new IllegalStateException("Object Already Created Exception");
        }
    }
    public static Logger getInstance(){
        if(null == logger){
            synchronized (Logger.class){
                if(null == logger){
                    logger = new Logger();
                    chainOfLogger = LoggerManager.buildChainOfLoggers();
                    logSubject = LoggerManager.buildSubject();
                }
            }
        }
        return logger;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return logger;
    }

    public void info(String message) {
        createLog(1, message);
    }

    public void error(String message) {
        createLog(2, message);
    }

    public void debug(String message) {
        createLog(3, message);
    }

    private void createLog(int level, String message){
        chainOfLogger.logMessage(level, message,logSubject);
    }
}
