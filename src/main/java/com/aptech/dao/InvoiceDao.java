package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvoiceDao {
    public static boolean addInvoice(Invoice invoice) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO invoice VALUES(null,?,?,null)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, invoice.getOrderId());
            ps.setInt(2, invoice.getStatus());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}