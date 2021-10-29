package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Order;
import com.aptech.models.OrderItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDao {
    public static Order getOrderItemById(int orderId) {
        Order order = null;
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

    public static List<OrderItem> getAllOrderItemsByOrderId(int orderId) {
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM orders_item_details WHERE order_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderItem order = new OrderItem();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getInt("order_id"));
                order.setProductId(rs.getInt("product_id"));
                order.setPrice(rs.getDouble("price"));
                order.setQty(rs.getInt("qty"));
                orderItems.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItems;
    }

    public static boolean addOrderItem(OrderItem item) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO orders_item_details VALUES(null,?,?,null,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, item.getOrderId());
            ps.setInt(2, item.getProductId());
            ps.setDouble(3, item.getPrice());
            ps.setInt(4, item.getQty());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}