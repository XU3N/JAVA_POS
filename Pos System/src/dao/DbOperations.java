
package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ImageIcon;

/**
 *
 * @author XU3N
 */
public class DbOperations {
    public static void setDataOrDelete(PreparedStatement stmt, String msg) {
        try{
            Connection conn = DatabaseConnect.dbconn();
            Statement s = conn.createStatement();
            stmt.executeUpdate();
            if(!msg.equals("")) {
                ImageIcon icon = new ImageIcon("src/pos/system/img/checked.png");
                JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE, icon);
                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ResultSet getData(PreparedStatement stmt) {
        try{
            Connection conn = DatabaseConnect.dbconn();
            Statement s = conn.createStatement();
            ResultSet rs = stmt.executeQuery();
            return rs;
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
