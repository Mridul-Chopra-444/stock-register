/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class change_pass extends javax.swing.JPanel {

     Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    public change_pass() {
         
        initComponents();
        pass.setEchoChar('*');
    }

     public void myconnection()
    { 
        try
        {
      Class.forName("com.mysql.jdbc.Driver");  
    cn=DriverManager.getConnection("jdbc:mysql://35.200.172.14/stock_register","root","123");      }
         catch(Exception e)
        { System.out.println(e);}
        
    }
     public void cp()
   { 
   try{
   
       myconnection();
       
       sql = "Update info set pass = '"+ F4.e(pass.getText())+ "' ;";
      
         st=cn.createStatement();
         st.executeUpdate(sql);
         JOptionPane.showMessageDialog(this,"Password Changed");
        
   
          
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this,e+"===") ;}
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pass = new java.awt.TextField();
        cb = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("ENTER PASSWORD");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("CHANGE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, -1, -1));

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 160, 30));

        cb.setText("Show/Hide");
        cb.setOpaque(false);
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
        if(cb.isSelected())
        pass.setEchoChar( (char)0 );
        else
        pass.setEchoChar('*');
    }//GEN-LAST:event_cbActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cp();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private java.awt.TextField pass;
    // End of variables declaration//GEN-END:variables
}
