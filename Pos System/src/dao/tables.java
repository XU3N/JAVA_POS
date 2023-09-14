
package dao;

/**
 *
 * @author XU3N
 */

import javax.swing.JOptionPane;
import java.sql.*; 

public class tables {
    public static void main(String[] args) {
        try{
            // create table using prepared statement
            String userTable = "CREATE TABLE user(user_id int AUTO_INCREMENT PRIMARY KEY, user_name VARCHAR(50), "
                    + "user_email VARCHAR(100), user_tel VARCHAR(11), user_address VARCHAR(100), "
                    + "password VARCHAR(50), security_question VARCHAR(100), answer VARCHAR(100), status VARCHAR(20), "
                    + "UNIQUE(user_email))";
            PreparedStatement stmt1 = DatabaseConnect.dbconn().prepareStatement(userTable);
            
            // insert default admin data into database using prepared statement
            PreparedStatement stmt2 = DatabaseConnect.dbconn().prepareStatement("INSERT INTO user(user_name, user_email, user_tel, user_address, password, security_question, answer, status)"
                                    + "VALUES (?,?,?,?,?,?,?,?)");
            stmt2.setString(1, "Admin");
            stmt2.setString(2, "admin@gmail.com");
            stmt2.setString(3, "1234567890");
            stmt2.setString(4, "KL");
            stmt2.setString(5, "admin");
            stmt2.setString(6, "What primary school did you attend?");
            stmt2.setString(7, "ABC");
            stmt2.setString(8, "true");
            
            // create category table
            String categoryTable = "CREATE TABLE category(category_id int AUTO_INCREMENT PRIMARY KEY, category_name VARCHAR(50))";
            PreparedStatement stmt3 = DatabaseConnect.dbconn().prepareStatement(categoryTable);
            
            // create product table
            String productTable = "CREATE TABLE product(product_id int AUTO_INCREMENT PRIMARY KEY, product_name VARCHAR(50), category VARCHAR(50), price VARCHAR(50))";
            PreparedStatement stmt4 = DatabaseConnect.dbconn().prepareStatement(productTable);
            
            DbOperations.setDataOrDelete(stmt1, "User Table Created Successfully!");
            DbOperations.setDataOrDelete(stmt2, "Admin Details Added Successfully!");
            DbOperations.setDataOrDelete(stmt3, "Category Table Created Successfully!");
            DbOperations.setDataOrDelete(stmt4, "Product Table Created Successfully!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
}
