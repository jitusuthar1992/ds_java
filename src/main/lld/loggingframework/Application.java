package main.lld.loggingframework;

public class Application {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.debug("test");
    }
}
