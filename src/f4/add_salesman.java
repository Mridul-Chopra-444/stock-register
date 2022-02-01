
package f4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class add_salesman extends javax.swing.JPanel {

 Connection cn;
String url,sql;
Statement st;
ResultSet rs;


    public add_salesman() {
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
   public void enter()
   { 
   
   try {
   myconnection();
   sql="Insert into salesman values ('"+name.getText().toUpperCase()+"' );";
    st=cn.createStatement();
           st.executeUpdate(sql);
   JOptionPane.showMessageDialog(this,"SalesMan added");
   }
   catch(Exception e)
   {JOptionPane.showMessageDialog(this,e); }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter Name :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 110, 50));
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        enter();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField name;
    // End of variables declaration//GEN-END:variables
}
