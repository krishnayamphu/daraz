package com.aptech.config.autotables;

import com.aptech.helpers.ConnectDB;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserTable {
    public static void createTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "CREATE TABLE users (id int PRIMARY KEY AUTO_INCREMENT,fname varchar(20),lname varchar(20),gender varchar(10) not null,username varchar(20) unique not null,email varchar(256) unique not null,contact varchar(15) unique not null,password varchar(256) not null,address varchar(50),active TINYINT not null, created_at timestamp DEFAULT CURRENT_TIMESTAMP,updated_at timestamp DEFAULT CURRENT_TIMESTAMP)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("users table created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void dropTable() {
        try {
            Connection con = ConnectDB.connect();
            String sql = "DROP TABLE users";
            PreparedStatement ps = con.prepareStatement(sql);
            if(ps.executeUpdate()==1){
                System.out.println("dropped users table.");
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
