package com.dao;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Logger logger = Logger.getLogger(ConnectionDB.class.getName());
    private static String host = JdbcPropManager.getProperty("server.host");
    //private static String port = JdbcPropManager.getProperty("server.port");
    private static String user = JdbcPropManager.getProperty("server.user_name");
    private static String password = JdbcPropManager.getProperty("server.password");
    private static String db = JdbcPropManager.getProperty("server.db_name");
    private static String url = "jdbc:sqlserver://"+host+";databaseName="+db+"";
    private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(url, user, password);
                logger.info("Thread name: "+Thread.currentThread().getName()+" connection to "+db+" database was created");
                return connection;
            } catch (SQLException e) {
                logger.error("Thread name: "+Thread.currentThread().getName()+" Failed to create the database connection "+e);
            }
        } catch (ClassNotFoundException e) {
            logger.error("Thread name: "+Thread.currentThread().getName()+" Driver not found. "+e);
        }
        return connection;
    }
}
