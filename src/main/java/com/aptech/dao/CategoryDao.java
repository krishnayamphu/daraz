package com.aptech.dao;


import com.aptech.helpers.ConnectDB;
import com.aptech.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public static Category getCategoryById(int id){
        Category category=null;
        try {
            Connection con= ConnectDB.connect();
            String sql="SELECT * FROM category WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                category=new Category(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("created_at"),rs.getString("updated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    public static List<Category> getAllCategories(){
        List<Category> categories=new ArrayList<>();
        try {
            Connection con= ConnectDB.connect();
            String sql="SELECT * FROM category";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Category category=new Category(rs.getInt("id"),rs.getString("name"),rs.getString("description"),rs.getString("created_at"),rs.getString("updated_at"));
                categories.add(category);
            }
//            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static boolean addCategory(Category category){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "INSERT INTO category VALUES(null,?,?,null,null)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setString(2,category.getDescription());
            if(ps.executeUpdate()==1){
                status=true;
            }
        }catch (SQLException e){
            System.err.println(e);
        }
        return status;
    }

    public static boolean updateCategory(Category category){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "UPDATE category SET name=?, description=? WHERE id=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,category.getName());
            ps.setString(2,category.getDescription());
            ps.setInt(3,category.getId());
            if(ps.executeUpdate()==1){
                status=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    public static boolean delCategory(int id){
        boolean status=false;
        try {
            Connection con = ConnectDB.connect();
            String sql = "DELETE FROM category WHERE id=?";
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
