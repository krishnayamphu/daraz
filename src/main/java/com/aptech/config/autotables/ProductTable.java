package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductTable {
    public static void createTable() {
        try{
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE products (id int PRIMARY KEY AUTO_INCREMENT,name varchar(56), description text, sku varchar(56), regular_price decimal, sales_price decimal, image varchar(256),category_id int,inventory_id int,discount_id int,created_at timestamp DEFAULT CURRENT_TIMESTAMP,updated_at timestamp DEFAULT CURRENT_TIMESTAMP,FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE,FOREIGN KEY (inventory_id) REFERENCES inventory(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("products table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE IF EXISTS products";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            ps.executeUpdate();
            System.out.println("dropped products table.");
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
