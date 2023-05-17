package main.thereadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DBConnectionPool implements IConnectionPool {

    private DBbean dBbean;
    private boolean isActive = false;
    private int contActive = 0;
    private List<Connection> freeConnections = new ArrayList<>();
    private List<Connection> activeConnections = new ArrayList<>();

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public DBConnectionPool(DBbean dBbean) {
        super();
        this.dBbean = dBbean;
        init();
        checkPool();
    }

    private void init() {
        try {
            Class.forName(this.dBbean.getDriverName());
            for (int i = 0; i < this.dBbean.getInitConnections() ; i++) {
                Connection conn = newConnection();
                if(null != conn){
                    freeConnections.add(conn);
                    contActive++;
                }
            }
            this.isActive = true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private synchronized Connection newConnection()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;
        if (this.dBbean != null) {
            Class.forName(this.dBbean.getDriverName());
            conn = DriverManager.getConnection(this.dBbean.getUrl(),
                    this.dBbean.getUserName(), this.dBbean.getPassword());
        }
        return conn;
    }

    public Connection getCurrentConnection(){
        Connection connection = threadLocal.get();
        if(!validConn(connection)){
            connection = getConnection();
        }
        return connection;
    }

    private synchronized Connection getConnection()  {
        Connection connection = null;
        try{
            if(contActive < this.dBbean.getMaxActiveConnections()){
                if(this.freeConnections.size() > 0){
                    connection = this.freeConnections.get(0);
                    if(connection != null){
                        threadLocal.set(connection);
                    }
                }else {
                    connection = newConnection();
                }

            }else {
                wait(this.dBbean.getConnTimeOut());
                connection = getConnection();
            }
            if(validConn(connection)){
                this.activeConnections.add(connection);
                this.contActive ++;
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public synchronized void releaseConnection(Connection connection){
        if(validConn(connection) && (this.freeConnections.size() < this.dBbean.getMaxConnections())){
            freeConnections.add(connection);
            activeConnections.remove(connection);
            contActive++;
            threadLocal.remove();
            notifyAll();
        }
    }

    private boolean validConn(Connection connection) {
        try {
            if(null == connection || connection.isClosed()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void checkPool() {
        if(dBbean.isCheckPool()){
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // 1. For the connection status in the thread
                    // 2. The minimum and maximum number of connections in the connection pool
                    // 3. Check other statuses, because there are still a few thread management classes that need to be written, so I won’t add them for now
                    System.out.println("Number of connections in the free line pool:"+freeConnections.size());
                    System.out.println("Number of active connections::"+activeConnections.size());
                    System.out.println("Total number of connections:"+contActive);
                }
            },dBbean.getLazyCheck(),dBbean.getPeriodCheck());
        }
    }
}
