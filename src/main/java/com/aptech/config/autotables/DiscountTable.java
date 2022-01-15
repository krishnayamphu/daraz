package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiscountTable {
    public static void createTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE discount (id int PRIMARY KEY AUTO_INCREMENT, code varchar(56) unique not null, coupon_type varchar(56), description text, dis_percentage decimal not null, min_spend_amount decimal not null, active int, expired_at date, created_at timestamp DEFAULT CURRENT_TIMESTAMP)";
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
            String sql = "DROP TABLE IF EXISTS discount";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            ps.executeUpdate();
            System.out.println("dropped discount table.");
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
