package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateCartTable {
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
            String sql = "DROP TABLE IF EXISTS cart";
            PreparedStatement ps = con.prepareStatement(sql);
            if(ps.executeUpdate()==1){
                System.out.println("dropped cart table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void defaultData() {
        try {
            String hexPass= DigestUtils.sha256Hex("user123");
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO users VALUES(null,'User','User','m','user','user@gmail.com','1234567',?,'Kumaripati, Lalitpur',1,null,null)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,hexPass);
            ps.executeUpdate();
            System.out.println("default user data generated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
