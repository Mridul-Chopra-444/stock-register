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
public class change_email extends javax.swing.JPanel {
Connection cn;
String url,sql;
Statement st;
ResultSet rs;
    public change_email() {
        initComponents();
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
    public void ce()
   { 
   try{
   
       myconnection();
       
       sql = "Update info set email = '"+ F4.e(email.getText())+ "' ;";
      
         st=cn.createStatement();
         st.executeUpdate(sql);
         JOptionPane.showMessageDialog(this,"Email Changed");
 
    
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this,e) ;}
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter Email");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 80, 30));
        add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 270, 30));

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ce();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
