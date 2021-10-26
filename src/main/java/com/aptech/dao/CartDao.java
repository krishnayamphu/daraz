package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Cart;
import com.aptech.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
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

    public static List<User> getAllCartProducts(){
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

    public static List<String> getAllCartItems(int userId) {
        List<String> cartItems = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT products.name,products.sales_price,products.image,cart.qty,cart.total FROM products LEFT JOIN cart ON products.id=cart.product_id WHERE cart.user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cartItems.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public static boolean addCartItem(Cart cartItem){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO cart VALUES(null,?,?,?,?,null,null)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,cartItem.getProductId());
            ps.setInt(2,cartItem.getUserId());
            ps.setInt(3,cartItem.getQty());
            ps.setDouble(4,cartItem.getTotal());
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