package main.thereadLocal;

public interface IConnectionPool {
    // Connection pool status
    boolean isActive();

    // Regularly check the connection pool situation
    void checkPool();
}
