package f4;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextAttribute;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class sales_report extends javax.swing.JFrame implements Printable {
Connection cn;
String url,sql;
Statement st;
ResultSet rs;
String names[];
String items[];
DefaultTableModel model;
DefaultTableModel model2;
DefaultTableModel model3;
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    public sales_report() {
        names();
        
        initComponents();
        
        this.getContentPane().setBackground(new java.awt.Color(221,217,217));
panel.hide();
table.setDefaultEditor(Object.class, null);
        model = (DefaultTableModel)table.getModel();
        model2 = (DefaultTableModel)table2.getModel();
        model3 = (DefaultTableModel)table3.getModel();
        
        get_items();
        tnames();
        
        
         centerRenderer.setHorizontalAlignment( JLabel.CENTER);
table.setDefaultRenderer(Float.class, centerRenderer);
table2.setDefaultRenderer(Float.class, centerRenderer);
table3.setDefaultRenderer(Float.class, centerRenderer);

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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable(

        );
        jLabel1 = new javax.swing.JLabel();
        date1 = new org.jdesktop.swingx.JXDatePicker();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        date2 = new org.jdesktop.swingx.JXDatePicker();
        panel = new javax.swing.JPanel();
        stocks = new javax.swing.JLabel();
        sales = new javax.swing.JLabel();
        gate = new javax.swing.JLabel();
        purchase = new javax.swing.JLabel();
        purchase1 = new javax.swing.JLabel();
        damage = new javax.swing.JLabel();
        damage1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1600, 900));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBackground(new java.awt.Color(255, 255, 204));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        table.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },names

        ));
        table.setIntercellSpacing(new java.awt.Dimension(1, 2));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getAccessibleContext().setAccessibleName("");
        table.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 1290, 330));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Initial Date:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 80, 40));
        getContentPane().add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 160, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("CHECK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Final Date :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 80, 40));
        getContentPane().add(date2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 150, -1));

        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMouseExited(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        stocks.setBackground(new java.awt.Color(153, 153, 153));
        stocks.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        stocks.setForeground(new java.awt.Color(255, 255, 255));
        stocks.setText("STOCKS");
        stocks.setOpaque(true);
        stocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                stocksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                stocksMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stocksMousePressed(evt);
            }
        });
        panel.add(stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        sales.setBackground(new java.awt.Color(153, 153, 153));
        sales.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        sales.setForeground(new java.awt.Color(255, 255, 255));
        sales.setText("SALES REPORT");
        sales.setOpaque(true);
        sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salesMouseExited(evt);
            }
        });
        panel.add(sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 160, 60));

        gate.setBackground(new java.awt.Color(153, 153, 153));
        gate.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        gate.setForeground(new java.awt.Color(255, 255, 255));
        gate.setText("GATE PASS");
        gate.setOpaque(true);
        gate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                gateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                gateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gateMousePressed(evt);
            }
        });
        panel.add(gate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 160, 60));

        purchase.setBackground(new java.awt.Color(153, 153, 153));
        purchase.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        purchase.setForeground(new java.awt.Color(255, 255, 255));
        purchase.setText("OPTIONS");
        purchase.setOpaque(true);
        purchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purchaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purchaseMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purchaseMousePressed(evt);
            }
        });
        panel.add(purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 160, 50));

        purchase1.setBackground(new java.awt.Color(153, 153, 153));
        purchase1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        purchase1.setForeground(new java.awt.Color(255, 255, 255));
        purchase1.setText("PURCHASE ENTRY");
        purchase1.setOpaque(true);
        purchase1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                purchase1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                purchase1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purchase1MousePressed(evt);
            }
        });
        panel.add(purchase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 160, 60));

        damage.setBackground(new java.awt.Color(153, 153, 153));
        damage.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        damage.setForeground(new java.awt.Color(255, 255, 255));
        damage.setText("DAMAGE");
        damage.setOpaque(true);
        damage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                damageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                damageMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                damageMousePressed(evt);
            }
        });
        panel.add(damage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 160, 50));

        damage1.setBackground(new java.awt.Color(153, 153, 153));
        damage1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        damage1.setForeground(new java.awt.Color(255, 255, 255));
        damage1.setText("DISCOUNT/GIFT");
        damage1.setOpaque(true);
        damage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                damage1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                damage1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                damage1MousePressed(evt);
            }
        });
        panel.add(damage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 160, 50));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, 440));

        jLabel3.setBackground(new java.awt.Color(255, 102, 102));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 10, 530));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "DAMAGE", "NET SALE", "DISCOUNT/GIFT", "OPENING BALANCE", "CLOSING BALANCE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        table2.setAutoscrolls(false);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(0).setResizable(false);
            table2.getColumnModel().getColumn(1).setResizable(false);
            table2.getColumnModel().getColumn(2).setResizable(false);
            table2.getColumnModel().getColumn(3).setResizable(false);
            table2.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 720, 230));

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Salesman ", "Net Sale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table3);
        if (table3.getColumnModel().getColumnCount() > 0) {
            table3.getColumnModel().getColumn(0).setResizable(false);
            table3.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 640, 230));

        l1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 160, 30));

        l2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 170, 30));

        l3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 630, 220, 40));

        l4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, 140, 30));

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 51));
        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setForeground(new java.awt.Color(255, 255, 51));
        jMenu1.setText("OPTIONS");
        jMenu1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu1.setOpaque(true);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem1.setText("PRINT");
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(date1.getDate()==null || date2.getDate()==null)
            JOptionPane.showMessageDialog(this,"Please Select dates");
        else
        { fill();
        get_both("damage",1);
        get_both("discount",3);
        
        item_net_sale();
        salesman_net_sale();
        fill_ob();
        l1.setText("Total :"+ String.format("%.3f",total(table2,1)));
        l2.setText("Total :"+String.format("%.3f",total(table2,2)));
        l3.setText("Total :"+String.format("%.3f",total(table3,1)));
        l4.setText("Total :"+String.format("%.3f",total(table2,3)));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            boolean ok = job.printDialog();
            if (ok) {
                try {
                    

//job.setPrintable(new PrintEvents(), pf);  
                    job.print();
                    
                    
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(this,ex);
                } } 
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void stocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_stocksMouseEntered

    private void stocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_stocksMouseExited

    private void stocksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMousePressed
        // TODO add your handling code here:
        stocks1 obj = new stocks1();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_stocksMousePressed

    private void salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseClicked
        // TODO add your handling code here:
        sales_report obj = new sales_report();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_salesMouseClicked

    private void salesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_salesMouseEntered

    private void salesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_salesMouseExited

    private void gateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_gateMouseEntered

    private void gateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_gateMouseExited

    private void gateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMousePressed
        window obj = new window();
        this.dispose();
        obj.show();// TODO add your handling code here:
    }//GEN-LAST:event_gateMousePressed

    private void purchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_purchaseMouseEntered

    private void purchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseMouseExited

    private void purchaseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMousePressed
        // TODO add your handling code here:
        options obj = new options();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_purchaseMousePressed

    private void purchase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase1MouseEntered

    private void purchase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase1MouseExited

    private void purchase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase1MousePressed
        // TODO add your handling code here:
        purchase1 obj = new purchase1();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_purchase1MousePressed

    private void panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_panelMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        panel.show();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        panel.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseEntered
panel.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseEntered

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
home obj = new home();
        this.dispose();
        obj.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void damageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damageMouseEntered
        panel.show();        // TODO add your handling code here:
    }//GEN-LAST:event_damageMouseEntered

    private void damageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damageMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_damageMouseExited

    private void damageMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damageMousePressed
        this.dispose();
        damage obj = new damage();
        obj.show();
    }//GEN-LAST:event_damageMousePressed

    private void damage1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damage1MouseEntered
        panel.show();        // TODO add your handling code here:
    }//GEN-LAST:event_damage1MouseEntered

    private void damage1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damage1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_damage1MouseExited

    private void damage1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_damage1MousePressed
        this.dispose();
        gifts obj = new gifts();
        obj.show();
    }//GEN-LAST:event_damage1MousePressed

    private void table2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseEntered
      panel.hide();
    }//GEN-LAST:event_table2MouseEntered

    
    public void names()
    { 
        try{
    myconnection();
 sql="Select * from salesman order by name;";
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    rs.last();
    names=new String[rs.getRow()+1];
    names[0]=" ";
     rs=st.executeQuery(sql);
    for(int i=0;rs.next();i++)
    {  
   
    names[i+1]=rs.getString("name");
     
    }
    
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(this,e);}
    
    
    }
    
    public void tnames()
    { 
        try{
   
    for(int i=1;i<names.length;i++)
    {  
   
    model3.addRow(new Object[]{names[i]});    
    }
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(this,e);}
    
    
    }
    
    public void get_items()
    { 
    
    try{
    myconnection();
 sql="Select * from stocks order by item;";
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
  rs=st.executeQuery(sql);
  rs.last();
  items=new String[rs.getRow()];
int i=0;
rs=st.executeQuery(sql);
     while(rs.next())
    { 
   model.addRow(new Object[]{rs.getString("item")});
  model2.addRow(new Object[]{rs.getString("item")});
  
   items[i]=rs.getString("item");
   i++;  
    }
    
        }
        catch(Exception e)
        { JOptionPane.showMessageDialog(this,e);}
    
    
    
    
    }
   
    
    
    
    
    
     int z=0,ppage=-1;

     
@Override
 public int print(Graphics g,PageFormat pf,int page)
{    
    
    
    
    
    
    System.out.println("-------->> "+page+" : : "+ppage);
    int[] pageBreaks = null;
    Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();
        
    if (pageBreaks == null) {
            
            float linesPerPage = 20;
            float num =table.getRowCount() / linesPerPage;
            int numBreaks = (int) num;
            
            if((float)num>(float)numBreaks)
            { 
            numBreaks ++;
            }
            if(numBreaks>0)
            {
            pageBreaks = new int[numBreaks];
            for (int b=0; b<numBreaks; b++) {
                pageBreaks[b] = (int) ((b+1)*linesPerPage); 
            }}
            else
            { 
            pageBreaks = new int[1];
            pageBreaks[0]=20;
            }
             
            
        }
    
    if (page>pageBreaks.length-1) {
            return NO_SUCH_PAGE;
        }
    
   if(ppage==page)
    {
         System.out.println("Setting pf :");
   pf.setOrientation(PageFormat.LANDSCAPE);
   SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    
    
    Graphics2D g2d = (Graphics2D)g;
    g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        font = new Font("Times New Roman", Font.BOLD, 24);
AttributedString atString= new AttributedString("Ajay Sareen & Co.");
atString.addAttribute(TextAttribute.FONT, font);
 
    g.drawString(atString.getIterator(),350,50);
    
    
     font = new Font("Times New Roman", Font.BOLD, 10);
    int x = table.getColumnCount();
    g.drawLine(30,120-50,30+80*x+70,120-50);
    for(int i=0;i<names.length;i++)
    { 
    atString= new AttributedString(names[i]);
atString.addAttribute(TextAttribute.FONT, font);
//g.drawString("",80+(i+1)*27,140);
g.drawString(atString.getIterator(),30+(i+1)*80,105-20);
    //g.drawString("",80+(i+1)*81,140);
    }
   g.drawLine(30,140-50,30+80*x+70,140-50);
   int y= 110;
   int i=z;
//System.out.println(page);
   while( i<table.getRowCount() & i<pageBreaks[page] )
   {  
   
   
      
    
       for( int j=0;j<table.getColumnCount();j++)
       { 
         String text=(table.getValueAt(i,j)==null) ?""  :table.getValueAt(i,j).toString()    ;
         if(j==0)
         {
         g.drawString(text+"",40,y);
         }
         else
         { 
             g.drawString(text,36+(j+1)*80,y);
         
         }
         
       }
    
      
  //g.drawLine(80,y+7,335,y+7);
   y+=20;
   
   
   i++;
   
   
   }
   z=i;
  
   g.drawLine(30,120-50,30,y-15);
//  g.drawLine(230,120,230,y-27+7);
 // g.drawLine(230+60,120,230+60,y-27+7);
  for(int k=0;k<table.getColumnCount();k++)
  { 
  
 g.drawLine(180+k*80,120-50,180+k*80,y-15);
  
  
  }
//  g.drawLine(x[2]-10,200-60,x[2]-10,y-27+7);
 g.drawLine(30,y-15,30+80*x+30+40,y-15);
  
    for(int m =1;m<=10;m++)
    {y=y+20;
        g.drawString("MRIDUL CHOPRA",30,y-15);
    }
    }
   
   
   
  
   ppage=page;
    if(z>=table.getRowCount())
   { ppage=-1;
   z=0;
   System.out.print("Clearing ;;");
   
   
   }
return PAGE_EXISTS; 
} 
 
    public float calc_ob(String item)
    {
        float ob=0;
    myconnection();
    try{
    sql="Select * from stocks where item='"+item+"' ;";
    st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    float s=0;
    if(rs.next())
    s=rs.getFloat("quantity");
    
  Calendar cal =Calendar.getInstance();
  cal.setTime(date1.getDate());
  java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
   cal.setTime(date2.getDate());
   java.sql.Timestamp timestamp2 = new java.sql.Timestamp(cal.getTimeInMillis());
    
   sql="Select sum(net) as sales from sales where item='"+item+"' and dos >='"+timestamp+"' and dos <='"+timestamp2+"';";
    st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    float sa=0;
    if(rs.next())
     sa=rs.getFloat("sales");
    
   sql="Select sum(quantity) as damage from damage where item='"+item+"' and dod >='"+timestamp+"' and dod <='"+timestamp2+"';";
    st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    float d=0;
    if(rs.next())
     d=rs.getFloat("damage");
    
   sql="Select sum(quantity) as discount from discount where item='"+item+"' and dod >='"+timestamp+"' and dod <='"+timestamp2+"';";
    st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    float g=0;
    if(rs.next())
    g=rs.getFloat("discount");
    
  sql="Select sum(net) as purchase from purchase where item='"+item+"' and dop >'"+timestamp+"' and dop <='"+timestamp2+"';";
    st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
   float p=0;
    if(rs.next())
    p=rs.getFloat("purchase");
    ob=s+sa+d+g-p;
    
    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(this,e); }
    return ob;
    }
 
    public void fill_ob()
    { 
    for(int i=0;i<table2.getRowCount();i++)
    { 
        float ob = calc_ob(items[i]);
        table2.setValueAt(ob,i,4);
        float d=Float.parseFloat(table2.getValueAt(i,1).toString());
        float sa=Float.parseFloat(table2.getValueAt(i,2).toString());;
        float g=Float.parseFloat(table2.getValueAt(i,3).toString());;
        float cb=ob-d-sa-g;
        table2.setValueAt(cb,i,5);
    }    
    }
    
    public void get_both(String table,int col)
    { 
    myconnection();
    try{
        
        if(date1.getDate()==null || date2.getDate()==null)
        { 
        JOptionPane.showMessageDialog(this,"Please Select Dates");
        return;
        }
        Calendar cal =Calendar.getInstance();
   cal.setTime(date1.getDate());
  
      java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
   cal.setTime(date2.getDate());
   java.sql.Timestamp timestamp2 = new java.sql.Timestamp(cal.getTimeInMillis());
   for(int i=0;i<items.length;i++)
   {sql="Select * from "+table+" where dod >='"+timestamp+"' and  dod <='"+timestamp2+"'  and item='"+items[i]+"' ;";
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql); 
    float dam=0;
    while(rs.next())
    {
        dam = dam +rs.getFloat("quantity");
        
    }
    table2.setValueAt(dam+"",i,col);
    }

    }
    catch(Exception e)
    { JOptionPane.showMessageDialog(this,e);}
    
    }
    
    
    public void item_net_sale()
    { 
    
    for(int i=0;i<=items.length-1;i++)
    { 
        float sales =0;
        for(int j=0;j<names.length-1;j++)
        { 
           if(table.getValueAt(i,j+1 )!=null & table.getValueAt(i,j+1 )!="") 
            sales=sales+Float.parseFloat(table.getValueAt(i,j+1 ).toString());
         //System.out.print(i+"   "+table.getValueAt(i,j+1 ));
        }
        //System.out.println("");
        table2.setValueAt(sales,i,2);
    }
   
    }
    
    public void salesman_net_sale()
    { 
    
    for(int i=0;i<names.length-1;i++)
    { 
        float sales =0;
        for(int j=0;j<=items.length-1;j++)
        { 
           if(table.getValueAt(j,i+1 )!=null & table.getValueAt(j,i+1 )!="") 
            sales=sales+Float.parseFloat(table.getValueAt(j,i+1 ).toString());
         //System.out.print(i+"   "+table.getValueAt(i,j+1 ));
        }
        //System.out.println("");
        table3.setValueAt(sales,i,1);
    }
   
    }
    
    
    public float total(javax.swing.JTable table , int col)
    { 
        float sum =0;
    for(int i=0;i<table.getRowCount();i++)
    { 
        sum = sum + Float.parseFloat(table.getValueAt(i,col).toString());
    }
    return sum;
    }
    
    
    
    
    
    
    public float data(String name, String item)
    { 
    try{
        myconnection();
        
     Calendar cal =Calendar.getInstance();
   cal.setTime(date1.getDate());
  
   java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
   cal.setTime(date2.getDate());
   java.sql.Timestamp timestamp2 = new java.sql.Timestamp(cal.getTimeInMillis());
   
    sql="Select * from sales where dos >='"+timestamp+"' and dos <='"+timestamp2+"' and salesman ='"+name+"' and item='"+item+"' ;";
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    float val =0;
    while(rs.next())
    {
    val=val+rs.getFloat("net");
    }
    return val;
    }
    catch(Exception e)
    { JOptionPane.showMessageDialog(this,e);}
   return 0;
    }
    
    
    public void fill()
    { 
   for(int i=0;i<items.length;i++)
    {
   for(int j=0;j<names.length-1;j++)
    { 
float val=data(names[j+1],items[i]);
//System.out.println(names[j+1] + "  "+items[i] +" " + val);
if(val!=0)
{
   table.setValueAt(val,i,j+1);
}
    }
    }
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
            java.util.logging.Logger.getLogger(sales_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales_report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel damage;
    private javax.swing.JLabel damage1;
    private org.jdesktop.swingx.JXDatePicker date1;
    private org.jdesktop.swingx.JXDatePicker date2;
    private javax.swing.JLabel gate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel purchase;
    private javax.swing.JLabel purchase1;
    private javax.swing.JLabel sales;
    private javax.swing.JLabel stocks;
    private javax.swing.JTable table;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables
}
