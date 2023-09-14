
package dao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author XU3N
 */
public class UserDao {
    public static void saveData(User user) throws SQLException {
        PreparedStatement stmt= DatabaseConnect.dbconn().prepareStatement("INSERT INTO user(user_name, user_email, user_tel, user_address, password, security_question, answer, status)"
                                    + "VALUES (?,?,?,?,?,?,?,?)");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, user.getTelNo());
        stmt.setString(4, user.getAddress());
        stmt.setString(5, user.getPassword());
        stmt.setString(6, user.getSecurityQuestion());
        stmt.setString(7, user.getAnswer());
        stmt.setString(8, user.getStatus());
        DbOperations.setDataOrDelete(stmt, "Registered Successfully! Please Wait For Admin Approval!");
    }
    
    public static User checkEmailAndUsername(String email, String name) {
        User user = null;
        try{
            PreparedStatement stmt= DatabaseConnect.dbconn().prepareStatement("SELECT * FROM user WHERE user_email = ? OR user_name = ?");
            stmt.setString(1, email);
            stmt.setString(2, name);
            ResultSet rs = DbOperations.getData(stmt);
            while(rs.next()) {
                user = new User();
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setStatus(rs.getString(9));
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static ArrayList<User> getAllRecords() {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            PreparedStatement stmt2 = DatabaseConnect.dbconn().prepareStatement("SELECT * FROM user");
            ResultSet rs = DbOperations.getData(stmt2);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setName(rs.getString("user_name"));
                user.setEmail(rs.getString("user_email"));
                user.setTelNo(rs.getString("user_tel"));
                user.setAddress(rs.getString("user_address"));
                user.setSecurityQuestion(rs.getString("security_question"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }
    
    public static User login(String email, String password) {
        User user = null;
        try{
            PreparedStatement stmt= DatabaseConnect.dbconn().prepareStatement("SELECT * FROM user WHERE user_email = ? AND password = ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = DbOperations.getData(stmt);
            while(rs.next()) {
                user = new User();
                user.setStatus(rs.getString(9));
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email) 
    {
        User user = null;
        try{
            PreparedStatement stmt= DatabaseConnect.dbconn().prepareStatement("SELECT * FROM user WHERE user_email = ?");
            stmt.setString(1, email);
            ResultSet rs = DbOperations.getData(stmt);
            while(rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("security_question"));
                user.setAnswer(rs.getString("answer"));
            }
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static void update(String email, String newPassword) {
        try{
            PreparedStatement stmt= DatabaseConnect.dbconn().prepareStatement("UPDATE user set password = ? WHERE user_email = ?");
            stmt.setString(1, email);
            stmt.setString(2, newPassword);
            DbOperations.setDataOrDelete(stmt, "Password Changed Successfully!");
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void changeStatus(String email, String status) {
        PreparedStatement stmt;
        try {
            stmt = DatabaseConnect.dbconn().prepareStatement("UPDATE user SET status = ? WHERE email = ?");
            stmt.setString(1, status);
            stmt.setString(2, email);
            DbOperations.setDataOrDelete(stmt, "Status Change Successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
