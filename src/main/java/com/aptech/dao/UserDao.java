package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static boolean auth(User user){
        boolean status=false;
        try {
            Connection con= ConnectDB.connect();
            String sql="SELECT username,password FROM users WHERE username=? AND password=? AND active=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static User getUserById(int id){
        User user=null;
        try {
            Connection con=ConnectDB.connect();
            String sql="SELECT * FROM users WHERE id=? AND active=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("fname"));
                user.setLastname(rs.getString("lname"));
                user.setGender(rs.getString("gender"));
                user.setUsername(rs.getString("username"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setContact(rs.getString("contact"));
                user.setCreatedAt(rs.getString("created_at"));
                user.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static User getUserByUsername(String username){
        User user=null;
        try {
            Connection con=ConnectDB.connect();
            String sql="SELECT * FROM users WHERE username=? AND active=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("fname"));
                user.setLastname(rs.getString("lname"));
                user.setGender(rs.getString("gender"));
                user.setUsername(rs.getString("username"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setContact(rs.getString("contact"));
                user.setCreatedAt(rs.getString("created_at"));
                user.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<User> getAllUsers(){
        List<User> users=new ArrayList<>();
        try {
            Connection con=ConnectDB.connect();
            String sql="SELECT * FROM users WHERE active=1";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("fname"));
                user.setLastname(rs.getString("lname"));
                user.setAddress(rs.getString("address"));
                user.setEmail(rs.getString("email"));
                user.setContact(rs.getString("contact"));
                user.setCreatedAt(rs.getString("created_at"));

                users.add(user);
            }
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static boolean addUser(User user){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO users VALUES(null,?,?,?,?,?,?,?,?,?,null,null)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,user.getFirstname());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getGender());
            ps.setString(4,user.getUsername());
            ps.setString(5,user.getEmail());
            ps.setString(6,user.getContact());
            ps.setString(7,user.getPassword());
            ps.setString(8,user.getAddress());
            ps.setInt(9,user.getActive());
            if(ps.executeUpdate()==1){
                status=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    public static boolean delUser(int id){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.executeUpdate()==1){
                status=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}