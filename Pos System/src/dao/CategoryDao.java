/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Category;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author XU3N
 */
public class CategoryDao {

    public static void saveCategory(Category category) throws SQLException {
        PreparedStatement stmt1 = DatabaseConnect.dbconn().prepareStatement("INSERT INTO category(category_name)"
                + "VALUES (?)");
        stmt1.setString(1, category.getName());
        DbOperations.setDataOrDelete(stmt1, "Category Added Successfully!");
    }

    public static ArrayList<Category> getAllRecords() {
        ArrayList<Category> arrayList = new ArrayList<>();
        try {
            PreparedStatement stmt2 = DatabaseConnect.dbconn().prepareStatement("SELECT * FROM category");
            ResultSet rs = DbOperations.getData(stmt2);
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getString("category_id"));
                category.setName(rs.getString("category_name"));
                arrayList.add(category);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }

    public static Category searchRecord(String id) {
        Category category = new Category();
        try {
            PreparedStatement stmt3 = DatabaseConnect.dbconn().prepareStatement("SELECT * FROM category WHERE category_id = '" + id + "'");
            ResultSet rs = DbOperations.getData(stmt3);
            while (rs.next()) {
                category.setId(rs.getString("category_id"));
                category.setName(rs.getString("category_name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return category;
    }

    public static void deleteCategory(String id) throws SQLException {
        PreparedStatement stmt4 = DatabaseConnect.dbconn().prepareStatement("DELETE FROM category WHERE category _id = ?");
        stmt4.setString(1, id);
        DbOperations.setDataOrDelete(stmt4, "Category Deleted Successfully!");
    }

    public static void updateCategory(Category category) throws SQLException {
        PreparedStatement stmt5 = DatabaseConnect.dbconn().prepareStatement("UPDATE category SET category_name = ? WHERE category_id = ?");
        stmt5.setString(1, category.getName());
        stmt5.setString(2, category.getId());

        DbOperations.setDataOrDelete(stmt5, "Category Updated Successfully!");

    }
    
    public static Category checkRecord(String name) {
    Category category = null;
    try {
        PreparedStatement stmt6 = DatabaseConnect.dbconn().prepareStatement("SELECT * FROM category WHERE category_name = ?");
        stmt6.setString(1, name);
        ResultSet rs = DbOperations.getData(stmt6);
        if (rs.next()) {
            category = new Category();
            category.setId(rs.getString("category_id"));
            category.setName(rs.getString("category_name"));
        }
    } catch (SQLException e) {
        // Let the caller handle the exception
        e.printStackTrace();
    }
    return category;
}






}
