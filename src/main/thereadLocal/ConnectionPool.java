/*
package main.thereadLocal;

import java.sql.Connection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

public class ConnectionPool implements IConnectionPool {
    // Connection pool configuration properties
    private DBbean dbBean;
    private boolean isActive = false; // Connection pool activity status
    private int contActive = 0;// Record the total number of connections created

    // idle connection
    private List<Connection> freeConnection = new Vector<Connection>();
    // Active connection
    private List<Connection> activeConnection = new Vector<Connection>();

    // Binding threads and connections to ensure uniform execution of transactions
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public ConnectionPool(DBbean dbBean) {
        super();
        this.dbBean = dbBean;
        init();
        cheackPool();
    }

    // Initialize
    public void init() {
        try {
            Class.forName(dbBean.getDriverName());
            for (int i = 0; i < dbBean.getInitConnections(); i++) {
                Connection conn;
                conn = newConnection();
                // Initialize the minimum number of connections
                if (conn != null) {
                    freeConnection.add(conn);
                    contActive++;
                }
            }
            isActive = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get the current connection
    public Connection getCurrentConnecton(){
        // Taken from the default thread
        Connection conn = threadLocal.get();
        if(!isValid(conn)){
            conn = getConnection();
        }
        return conn;
    }

    // get connection
    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            // Determine whether the maximum number of connections is exceeded
            if(contActive < this.dbBean.getMaxActiveConnections()){
                if (freeConnection.size() > 0) {
                    conn = freeConnection.get(0);
                    if (conn != null) {
                        threadLocal.set(conn);
                    }
                    freeConnection.remove(0);
                } else {
                    conn = newConnection();
                }

            }else{
                // Continue to get a connection until a new connection is obtained
                wait(this.dbBean.getConnTimeOut());
                conn = getConnection();
            }
            if (isValid(conn)) {
                activeConnection.add(conn);
                contActive ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Get a new connection
    private synchronized Connection newConnection()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        if (dbBean != null) {
            Class.forName(dbBean.getDriverName());
            conn = DriverManager.getConnection(dbBean.getUrl(),
                    dbBean.getUserName(), dbBean.getPassword());
        }
        return conn;
    }

    // release the connection
    public synchronized void releaseConn(Connection conn) throws SQLException {
        if (isValid(conn)&& !(freeConnection.size() > dbBean.getMaxConnections())) {
            freeConnection.add(conn);
            activeConnection.remove(conn);
            contActive --;
            threadLocal.remove();
            // Wake up all waiting threads to grab the connection
            notifyAll();
        }
    }

    // Determine whether the connection is available
    private boolean isValid(Connection conn) {
        try {
            if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // Destroy the connection pool
    public synchronized void destroy() {
        for (Connection conn : freeConnection) {
            try {
                if (isValid(conn)) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        for (Connection conn : activeConnection) {
            try {
                if (isValid(conn)) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        isActive = false;
        contActive = 0;
    }

    // Connection pool status
    @Override
    public boolean isActive() {
        return isActive;
    }

    // Regularly check the connection pool situation
    @Override
    public void cheackPool() {
        if(dbBean.isCheakPool()){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // 1. For the connection status in the thread
                    // 2. The minimum and maximum number of connections in the connection pool
                    // 3. Check other statuses, because there are still a few thread management classes that need to be written, so I won’t add them for now
                    System.out.println("Number of connections in the free line pool:"+freeConnection.size());
                    System.out.println("Number of active connections::"+activeConnection.size());
                    System.out.println("Total number of connections:"+contActive);
                }
            },dbBean.getLazyCheck(),dbBean.getPeriodCheck());
        }
    }
}
*/
