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
public class delete_salesman extends javax.swing.JPanel {

    Connection cn;
String url,sql;
Statement st;
ResultSet rs;
String names[];
    public delete_salesman() {
        get_names();
        initComponents();
    }

   public void get_names()
{ 

try{
myconnection();
 
sql="Select * from salesman";
st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    rs.last();
    names=new String[rs.getRow()+1];
     rs=st.executeQuery(sql);
    int i=0;
    while(rs.next())
    { 
    names[i]=rs.getString("name");
    i++;
    }
}
catch(Exception e)
{ JOptionPane.showMessageDialog(this,e);}

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
public void delete()
   { 
   
   try {
   myconnection();
   sql="Delete from salesman where name='"+name.getSelectedItem()+"' ;";
    st=cn.createStatement();
           st.executeUpdate(sql);
   JOptionPane.showMessageDialog(this,"Sales-Man Deleted");
  rs.close();
cn.close();
st.close(); 
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this,e); }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Sales-Man Name ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 77, 110, 20));

        name.setModel(new javax.swing.DefaultComboBoxModel<>(names));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 110, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> name;
    // End of variables declaration//GEN-END:variables
}
