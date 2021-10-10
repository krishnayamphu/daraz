package com.aptech.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    private static Connection connection;
    private static String user = "root";
    private static String password = "";
    private static String dbname = "darazz";
    private static String host_url = "jdbc:mysql://localhost:3306";

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(host_url + "/" + dbname, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
