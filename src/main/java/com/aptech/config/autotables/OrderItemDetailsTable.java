package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDetailsTable {
    public static void createTable() {
        try{
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE orders_item_details (id int PRIMARY KEY AUTO_INCREMENT,order_id int,product_id int,inventory_id int, price decimal, qty int,FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE,FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("orders_item_details table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE orders_item_details";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("dropped orders_item_details table.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
