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

    public static boolean updateOrderItem(Order order) {
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "UPDATE orders SET name=?,email=?,mobile=?,address=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, order.getName());
            ps.setString(2, order.getEmail());
            ps.setString(3,order.getMobile());
            ps.setString(4,order.getAddress());
            ps.setInt(5,order.getId());
            if (ps.executeUpdate() == 1) {
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean updateOrderStatusId(Order order) {
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "UPDATE orders SET order_status_id=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, order.getOrderStatusId());
            ps.setInt(2,order.getId());
            if (ps.executeUpdate() == 1) {
                status=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Order> getPaidOrders() {
        List<Order> orders=new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT orders.id, orders.user_id, orders.name,orders.email,orders.mobile,orders.address,orders.order_status_id,orders.total_amount, orders.created_at FROM orders LEFT JOIN invoice ON orders.id=invoice.order_id WHERE invoice.status=1";

            PreparedStatement ps = con.prepareStatement(sql);
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

    public static List<Order> getCancelRequestOrders() {
        List<Order> orders=new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM orders WHERE order_status_id=5";
            PreparedStatement ps = con.prepareStatement(sql);
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
}