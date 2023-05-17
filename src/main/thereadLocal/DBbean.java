package main.thereadLocal;

public class DBbean {
    String driverName;
    int initConnections;

    boolean checkPool;

    long lazyCheck;

    long periodCheck;

    String url;

    String userName;

    String password;

    int maxConnections;

    long connTimeOut;

    int maxActiveConnections;

    public String getDriverName() {
        return this.driverName;
    }

    public int getInitConnections() {
        return this.initConnections;
    }

    public boolean isCheckPool() {
        return this.checkPool;
    }

    public long getLazyCheck() {
        return this.lazyCheck;
    }

    public long getPeriodCheck() {
        return this.periodCheck;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public long getConnTimeOut() {
        return this.connTimeOut;
    }

    public int getMaxActiveConnections() {
        return this.maxActiveConnections;
    }
}
