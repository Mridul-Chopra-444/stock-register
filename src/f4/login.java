
package f4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;


public class login extends javax.swing.JFrame {
 Connection cn;
String url,sql;
Statement st;
ResultSet rs;
String eml;
   
    public login() {
        initComponents();
         this.getContentPane().setBackground(new java.awt.Color(221,217,217));
        pass.setEchoChar('*');
    }

  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        pass = new java.awt.TextField();
        cb = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1600, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Enter Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 110, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Forgot Password ?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel2.setText("Stock Register");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 290, 50));
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 240, 160, -1));

        cb.setText("Show/Hide");
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });
        getContentPane().add(cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        go();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        password();
        recover();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
        if(cb.isSelected())
        pass.setEchoChar( (char)0 );
        else
        pass.setEchoChar('*');
    }//GEN-LAST:event_cbActionPerformed

   public void myconnection()
    { 
        try
        {
    Class.forName("com.mysql.jdbc.Driver");  
    cn=DriverManager.getConnection("jdbc:mysql://35.200.172.14/stock_register","root","123");      }
       catch(Exception e)
    {JOptionPane.showMessageDialog(this, e); }
    }
      public void go()
{ 
try
        {
            
        myconnection();
      sql="Select * from info where pass = '"+F4.e(pass.getText())+"' ;";
     
      st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      if(rs.next())
      {
          this.dispose();
  home obj= new home();
     obj.show();
      }
      else if(!rs.next())
      { 
      JOptionPane.showMessageDialog(this,"Incorrect Password");
      }
      
      
     
      
         }
       
        
        catch(Exception e)
        { JOptionPane.showMessageDialog(this,e);}


}
       String pas="";
     public void password()
     {
         Random ran=new Random();
                
                int top=6;
                char data=' ';
                for(int i=0;i<=top;i++)
                {
                    data=(char)(ran.nextInt(25)+97);
                    pas=data+pas;
                }
     }
    
     public void email1()
    {
        try
        {
         Email email = new SimpleEmail();
email.setHostName("smtp.googlemail.com");
email.setSmtpPort(465);
email.setAuthentication("passmanagerword@gmail.com","mridul123456");
email.setSSLOnConnect(true);
email.setFrom("passmanagerword@gmail.com");
email.setSubject("Password Recovery");
            
email.setMsg("Recovery Password for Stock Register is " + "Password ="+pas+".   "
        + " Please change password after login.");
email.addTo(eml);
email.send();
               JOptionPane.showMessageDialog(this,"Email Successfully Sent!");
               
        }
        
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this,e);
            }
    }    
     public void recover()
     { 
     try
     {
     myconnection();
     sql="Select * from info";
     st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
      rs=st.executeQuery(sql);
      if(rs.next())
{     eml=F4.d(rs.getString("email"));
        
      
      sql = "Update info set pass = '"+ F4.e(pas)+ "' ;";
      
           st=cn.createStatement();
         st.executeUpdate(sql);
       
          
 
           email1();        
    
}
     
     
     }
     catch(Exception e)
     {JOptionPane.showMessageDialog(this,e);}
     }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.TextField pass;
    // End of variables declaration//GEN-END:variables
}
