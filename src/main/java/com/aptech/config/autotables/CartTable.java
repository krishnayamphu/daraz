package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartTable {
    public static void createTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE IF NOT EXISTS cart (id int PRIMARY KEY AUTO_INCREMENT,product_id int not null,user_id int not null,qty int not null,total decimal not null, created_at timestamp DEFAULT CURRENT_TIMESTAMP,updated_at timestamp DEFAULT CURRENT_TIMESTAMP,FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE ON UPDATE CASCADE,FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("cart table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE cart";
            PreparedStatement ps = con.prepareStatement(sql);
            if(ps.executeUpdate()==1){
                System.out.println("dropped cart table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
