package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public static Order getOrderItemById(int orderId) {
        Order order=null;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM orders WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setName(rs.getString("name"));
                order.setEmail(rs.getString("email"));
                order.setMobile(rs.getString("mobile"));
                order.setAddress(rs.getString("address"));
                order.setOrderStatusId(rs.getInt("order_status_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setCreatedAt(rs.getString("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public static List<Order> getAllOrderItems(int userId) {
        List<Order> orders=new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM orders WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setUserId(rs.getInt("user_id"));
                order.setName(rs.getString("name"));
                order.setEmail(rs.getString("email"));
                order.setMobile(rs.getString("mobile"));
                order.setAddress(rs.getString("address"));
                order.setOrderStatusId(rs.getInt("order_status_id"));
                order.setTotalAmount(rs.getDouble("total_amount"));
                order.setCreatedAt(rs.getString("created_at"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static int addOrderItem(Order order) {
        int generatedKey = -1;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO orders VALUES(null,?,?,?,?,?,?,?,null)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUserId());
            ps.setString(2, order.getName());
            ps.setString(3, order.getEmail());
            ps.setString(4,order.getMobile());
            ps.setString(5,order.getAddress());
            ps.setInt(6,order.getOrderStatusId());
            ps.setDouble(7,order.getTotalAmount());
            if (ps.executeUpdate() == 1) {
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    generatedKey=rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return generatedKey;
        }
    }

}