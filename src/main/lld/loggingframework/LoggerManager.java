package main.lld.loggingframework;

public class LoggerManager {
    public static AbstractLogger buildChainOfLoggers(){
        AbstractLogger infoLogger = new InfoLogger(1);
        AbstractLogger errorLogger = new ErrorLogger(2);
        AbstractLogger debugLogger = new DebugLogger(3);
        infoLogger.setNextLoggingLevel(errorLogger);
        errorLogger.setNextLoggingLevel(debugLogger);
        return infoLogger;
    }

    public static LogSubject buildSubject() {
        LogSubject loggerSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        loggerSubject.addObserver(1,consoleLogger);
        loggerSubject.addObserver(2,consoleLogger);
        loggerSubject.addObserver(3,consoleLogger);
        FileLogger fileLogger = new FileLogger();
        loggerSubject.addObserver(2,fileLogger);
        return loggerSubject;
    }
}
