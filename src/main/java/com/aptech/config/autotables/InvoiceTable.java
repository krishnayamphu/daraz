package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvoiceTable {
    public static void createTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE invoice (id int PRIMARY KEY AUTO_INCREMENT,order_id int,status int DEFAULT 0, created_at timestamp DEFAULT CURRENT_TIMESTAMP,FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE ON UPDATE CASCADE)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            System.out.println("invoice table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE IF EXISTS invoice";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute("SET FOREIGN_KEY_CHECKS=0");
            if(ps.executeUpdate()==1){
                System.out.println("dropped invoice table.");
            }
            ps.execute("SET FOREIGN_KEY_CHECKS=1");
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
