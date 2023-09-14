package pos.system;

import dao.CategoryDao;
import dao.DatabaseConnect;
import dao.UserDao;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Category;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.table.TableModel;
import model.User;

public class VerifyUser1 extends javax.swing.JPanel {

    /**
     * Creates new form Customer
     */

    public VerifyUser1() {

        initComponents();

        table_load("");
    }

    private void table_load(String email) {
        DefaultTableModel dtm = (DefaultTableModel) user_table.getModel();
        dtm.setRowCount(0);
        ArrayList<User> list = UserDao.getAllRecords();
        for (User userObj : list) {
            if (!userObj.getEmail().equals("admin@gmail.com")) {
                dtm.addRow(new Object[]{userObj.getId(), userObj.getName(), userObj.getEmail(), userObj.getTelNo(), userObj.getAddress(), userObj.getStatus()});
            }
        }
    }

    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        user_table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        user_search_table = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButton2.setText("Save");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(43, 99, 63));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(242, 242, 242));
        jLabel6.setText("User Management");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 242, 242));
        jLabel7.setText("Administration / User Panel");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(859, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(19, 19, 19))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1150, -1));

        user_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "TelNo", "Address", "Security Question", "Status"
            }
        ));
        user_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(user_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 910, 410));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Search Table:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 130, -1));

        user_search_table.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        user_search_table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_search_tableActionPerformed(evt);
            }
        });
        user_search_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                user_search_tableKeyReleased(evt);
            }
        });
        add(user_search_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 300, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CLICK ON ROW TO CHANGE USER'S STATUS");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/system/img/background.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, -20, 1400, -1));
    }// </editor-fold>//GEN-END:initComponents
   

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here: 
    }//GEN-LAST:event_formComponentShown

    private void user_search_tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_search_tableActionPerformed
        
    }//GEN-LAST:event_user_search_tableActionPerformed

    private void user_search_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_search_tableKeyReleased
        String email = user_search_table.getText();
        table_load(email);
    }//GEN-LAST:event_user_search_tableKeyReleased

    private void user_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_tableMouseClicked
        // TODO add your handling code here:
        int index = user_table.getSelectedRow();
        TableModel model = user_table.getModel();
        String email = model.getValueAt(index, 2).toString();
        String status = model.getValueAt(index, 6).toString();

        if (status.equals("true")) {
            status = "false";
        } else {
            status = "true";
        }
        int a = JOptionPane.showConfirmDialog(null, "Do you want to change the status of "+email+"", "select", JOptionPane.YES_NO_OPTION);
        if (a==0) {
            UserDao.changeStatus(email, status);
        }
        table_load("");
    }//GEN-LAST:event_user_tableMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField user_search_table;
    private javax.swing.JTable user_table;
    // End of variables declaration//GEN-END:variables
}
