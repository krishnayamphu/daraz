package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateDiscountTable {
    public static void createTable() {
        try{
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE discount (id int PRIMARY KEY AUTO_INCREMENT,name varchar(56), description text, dis_percentage decimal, active int,created_at timestamp DEFAULT CURRENT_TIMESTAMP,updated_at timestamp DEFAULT CURRENT_TIMESTAMP)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("discount table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE discount";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("dropped discount table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
