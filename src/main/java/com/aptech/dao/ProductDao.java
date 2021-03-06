package com.aptech.dao;

import com.aptech.helpers.ConnectDB;
import com.aptech.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static Product getProductById(int id) {
        Product product = null;
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM products WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setSku(rs.getString("sku"));
                product.setRegularPrice(rs.getDouble("regular_price"));
                product.setSalesPrice(rs.getDouble("sales_price"));
                product.setImage(rs.getString("image"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setInventoryId(rs.getInt("inventory_id"));
                product.setDiscountId(rs.getInt("discount_id"));
                product.setCreatedAt(rs.getString("created_at"));
                product.setUpdatedAt(rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM products";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setSku(rs.getString("sku"));
                product.setRegularPrice(rs.getDouble("regular_price"));
                product.setSalesPrice(rs.getDouble("sales_price"));
                product.setImage(rs.getString("image"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setInventoryId(rs.getInt("inventory_id"));
                product.setDiscountId(rs.getInt("discount_id"));
                product.setCreatedAt(rs.getString("created_at"));
                product.setUpdatedAt(rs.getString("updated_at"));

                products.add(product);
            }
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<Product> getSearchProducts(String name) {
        List<Product> products = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT * FROM products WHERE name LIKE CONCAT( '%',?,'%')";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setSku(rs.getString("sku"));
                product.setRegularPrice(rs.getDouble("regular_price"));
                product.setSalesPrice(rs.getDouble("sales_price"));
                product.setImage(rs.getString("image"));
                product.setCategoryId(rs.getInt("category_id"));
                product.setInventoryId(rs.getInt("inventory_id"));
                product.setDiscountId(rs.getInt("discount_id"));
                product.setCreatedAt(rs.getString("created_at"));
                product.setUpdatedAt(rs.getString("updated_at"));

                products.add(product);
            }
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static List<String> getCategoryByProductId(int id) {
        List<String> categories = new ArrayList<>();
        try {
            Connection con = ConnectDB.connect();
            String sql = "SELECT category.name FROM category LEFT JOIN products ON category.id=products.category_id WHERE products.id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categories.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }


    public static boolean addProduct(Product product) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO products(name,description,sku,regular_price,sales_price,image,category_id) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3,product.getSku());
            ps.setDouble(4,product.getRegularPrice());
            ps.setDouble(5,product.getSalesPrice());
            ps.setString(6,product.getImage());
            ps.setInt(7,product.getCategoryId());

            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean updateProduct(Product product) {
        boolean status = false;
        try {
            Connection con = ConnectDB.connect();
            //name,description,sku,regular_price,sales_price,image,category_id
            String sql = "UPDATE products SET name=?, description=?,sku=?,regular_price=?,sales_price=?,image=?,category_id=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setString(3,product.getSku());
            ps.setDouble(4,product.getRegularPrice());
            ps.setDouble(5,product.getSalesPrice());
            ps.setString(6,product.getImage());
            ps.setInt(7,product.getCategoryId());
            ps.setInt(8,product.getId());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public static boolean delProduct(int id){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM products WHERE id=?";
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
