package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryTable {
    public static void createTable() {
        try{
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE inventory (id int PRIMARY KEY AUTO_INCREMENT,quantity int,created_at timestamp DEFAULT CURRENT_TIMESTAMP,updated_at timestamp DEFAULT CURRENT_TIMESTAMP)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("inventory table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE IF EXISTS inventory";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            ps.executeUpdate();
            System.out.println("dropped inventory table.");
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
