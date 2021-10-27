package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Cart;
import com.aptech.models.CartItem;
import com.aptech.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public static int getTotalCartItem(int userId) {
        int count = 0;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT qty FROM cart WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count=count+rs.getInt("qty");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static List<CartItem> getAllCartItems(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT products.id,products.name,products.sales_price,products.image,cart.qty,cart.total FROM products LEFT JOIN cart ON products.id=cart.product_id WHERE cart.user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CartItem item=new CartItem(rs.getInt("id"),rs.getString("name"),rs.getString("image"),rs.getInt("qty"),rs.getDouble("sales_price"),rs.getDouble("total"));
                cartItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItems;
    }

    public static boolean addCartItem(Cart cart) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO cart VALUES(null,?,?,?,?,null,null)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cart.getProductId());
            ps.setInt(2, cart.getUserId());
            ps.setInt(3, cart.getQty());
            ps.setDouble(4, cart.getTotal());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean delCartItem(Cart cart) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM cart WHERE product_id=? AND user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cart.getProductId());
            ps.setInt(2,cart.getUserId());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}