package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Cart;
import com.aptech.models.CartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    public static Cart getCartById(int userId,int productId) {
        Cart cart = null;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM cart WHERE user_id=? AND product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cart = new Cart();
                cart.setId(rs.getInt("id"));
                cart.setUserId(rs.getInt("user_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQty(rs.getInt("qty"));
                cart.setTotal(rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cart;
    }

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

    public static double getSubTotal(int userId) {
        double subTotal = 0;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT total FROM cart WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                subTotal=subTotal+rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subTotal;
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

    public static boolean cartItemCheck(int userId,int productId) {
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT cart.product_id FROM cart WHERE  user_id=? AND product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setInt(2,productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
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

    public static boolean delCartItemByUserId(int userId) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM cart WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean updateCartItem(Cart cart) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "UPDATE cart SET qty=?, total=? WHERE user_id=? AND product_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cart.getQty());
            ps.setDouble(2, cart.getTotal());
            ps.setInt(3, cart.getUserId());
            ps.setInt(4, cart.getProductId());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}