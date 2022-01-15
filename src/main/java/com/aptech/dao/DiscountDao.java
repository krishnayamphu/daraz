package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Discount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountDao {
    public static Discount getDiscountById(int id) {
        Discount discount = null;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM discount WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                discount = new Discount();
                discount.setId(rs.getInt("id"));
                discount.setCode(rs.getString("code"));
                discount.setCouponType(rs.getString("coupon_type"));
                discount.setDescription(rs.getString("description"));
                discount.setDiscountPercentage(rs.getDouble("dis_percentage"));
                discount.setMinSpendAmount(rs.getDouble("min_spend_amount"));
                discount.setActive(rs.getInt("active"));
                discount.setExpiredAt(rs.getString("expired_at"));
                discount.setCreatedAt(rs.getString("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discount;
    }

    public static List<Discount> getAllDiscounts() {
        List<Discount> discounts = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM discount";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Discount discount = new Discount();
                discount.setId(rs.getInt("id"));
                discount.setCode(rs.getString("code"));
                discount.setCouponType(rs.getString("coupon_type"));
                discount.setDescription(rs.getString("description"));
                discount.setDiscountPercentage(rs.getDouble("dis_percentage"));
                discount.setMinSpendAmount(rs.getDouble("min_spend_amount"));
                discount.setActive(rs.getInt("active"));
                discount.setExpiredAt(rs.getString("expired_at"));
                discount.setCreatedAt(rs.getString("created_at"));

                discounts.add(discount);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discounts;
    }

    public static boolean addDiscount(Discount discount) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO discount(code,coupon_type,description,dis_percentage,min_spend_amount,active,expired_at) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, discount.getCode());
            ps.setString(2, discount.getCouponType());
            ps.setString(3,discount.getDescription());
            ps.setDouble(4,discount.getDiscountPercentage());
            ps.setDouble(5,discount.getMinSpendAmount());
            ps.setInt(6,discount.getActive());
            ps.setString(7,discount.getExpiredAt());

            if (ps.executeUpdate() == 1) {
                status = true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean updateDiscount(Discount discount) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            //code,coupon_type,description,dis_percentage,min_spend_amount,active,expired_at
            String sql = "UPDATE discount SET code=?,coupon_type=?,description=?,dis_percentage=?,min_spend_amount=?,active=?,expired_at=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, discount.getCode());
            ps.setString(2, discount.getCouponType());
            ps.setString(3,discount.getDescription());
            ps.setDouble(4,discount.getDiscountPercentage());
            ps.setDouble(5,discount.getMinSpendAmount());
            ps.setInt(6,discount.getActive());
            ps.setString(7,discount.getExpiredAt());
            ps.setInt(8,discount.getId());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean delDiscount(int id){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM discount WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            if(ps.executeUpdate()==1){
                status=true;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        return status;
    }
}
