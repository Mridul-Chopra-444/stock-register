/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f4;



import java.awt.Color;
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
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;

public class stocks1 extends javax.swing.JFrame implements Printable{
Connection cn;
String url,sql;
Statement st;
ResultSet rs;
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();

DefaultTableModel model;
    Vector v = new Vector(0,1);
   
         String [] items;
    public stocks1() {
        go();
        initComponents();
        
        this.getContentPane().setBackground(new java.awt.Color(221,217,217));
        panel.hide();
        open();
       panel.hide();
           JComboBox combobox = new JComboBox(items);
        model = (DefaultTableModel)table.getModel();
       combobox.setEditable(true);
        AutoCompleteDecorator.decorate(combobox);
       
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setCellEditor(new ComboBoxCellEditor(combobox));
       
        centerRenderer.setHorizontalAlignment( JLabel.LEFT);
table.setDefaultRenderer(Float.class, centerRenderer);
    }

    
    
    
    
    int z=0,ppage=-1;

     
@Override
 public int print(Graphics g,PageFormat pf,int page)
{     System.out.println("--------"+page);
    int[] pageBreaks = null;
    Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();
    if (pageBreaks == null) {
            
              float linesPerPage = 15;
            float num =v.size() / linesPerPage;
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
SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");


Graphics2D g2d = (Graphics2D)g;
g2d.translate(pf.getImageableX(), pf.getImageableY());

    font = new Font("Times New Roman", Font.BOLD, 24);
AttributedString atString= new AttributedString("Ajay Sareen & Co.");
atString.addAttribute(TextAttribute.FONT, font);

g.drawString(atString.getIterator(),220,100);


 font = new Font("Times New Roman", Font.BOLD, 14);


    
    g.drawLine(80+100,200 -60,335+100,200-60);
    g.drawLine(80+100,225-60,335+100,225-60);
    int x[]={85+100,243+100,345+100,440+100};
    atString= new AttributedString("Item");
    atString.addAttribute(TextAttribute.FONT, font);
     g.drawString(atString.getIterator(),x[0],215-60);
     
    atString= new AttributedString("Quantity");
    atString.addAttribute(TextAttribute.FONT, font);
    g.drawString(atString.getIterator(),x[1],215-60);
    
    
  
   int y= 243-60;
   int i=z;
//System.out.println(page);
   while( i<v.size() & i<pageBreaks[page] )
   {  
   
   
      
    { 
       for( int j=0;j<2;j++)
       { 
         String text=(table.getValueAt(Integer.parseInt(v.get(i).toString()),j)==null) ?""  :table.getValueAt(Integer.parseInt(v.get(i).toString()),j).toString()    ;
           g.drawString(text+"",x[j],y);
         //  g.drawString(i+"",x[j],y);
       }
    } 
      
   g.drawLine(80+100,y+7,335+100,y+7);
   y+=27;
   
   
   i++;
   
   
   }
   z=i;
   if(z>=v.size())
   { ppage=-1;
   z=0;
  // System.out.print("Clearing ;;");
   
   
   }
   g.drawLine(80+100,200-60,80+100,y-27+7);
   g.drawLine(x[1]-3,200-60,x[1]-3,y-27+7);
  g.drawLine(x[2]-10,200-60,x[2]-10,y-27+7);
   
  
    }
   ppage=page;
return PAGE_EXISTS; 
} 

    
    
    
    
    
    
    
   public void go()
 { 
     try
     {
     myconnection();
 sql="Select * from stocks order by item;";
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    rs.last();
    items=new String[rs.getRow()+1];
    items[0]="";
  rs=st.executeQuery(sql);
   
    int i=0;
     while(rs.next())
    {
         items[i+1]=rs.getString("item");
      
        
         i++;
     }
     
    
         }
     
     catch(Exception e)
     {JOptionPane.showMessageDialog(this,e+"--------");
     } }
   
   public void save(String item,float quan)
   { 
   
   try{
   myconnection();
   sql="Select * from stocks where item ='"+item+"' ;";
   st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
  if(!rs.next())
  { 
  sql="Insert into stocks values ('"+item.toUpperCase()+"' ,'"+quan+"');";
        st=cn.createStatement();
           st.executeUpdate(sql);
  
  }
  else { 
  
   sql="Update stocks set quantity='"+quan+"' where item='"+item+"' ;";
  st=cn.createStatement();
           st.executeUpdate(sql);
  }
    
  
   
   }
   catch(Exception e)
   { 
   
   JOptionPane.showMessageDialog(this,e);
   }
   
   }
   
   
   
   public void save()
   { 
   
   v.clear();
   check();
   for(int i=0;i<v.size();i++)
   { 
   String item = table.getValueAt(Integer.parseInt(v.get(i).toString()) ,0 ).toString() ;
   float quan =   Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()) ,1).toString()) ;
 save(item,quan);
   }
   JOptionPane.showMessageDialog(this,"Save Succesful");
   
   }
   
   
   
   public void open()
   {
   
   try {
       myconnection();
   sql="Select * from stocks order by item";
    st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
   for(int i=0;rs.next();i++)
   {
   
   table.setValueAt(rs.getString("item"),i,0);
   table.setValueAt(String.format("%.3f",rs.getFloat("quantity") ),i,1);
   
           
   }
   

   }
   catch(Exception e)
   { JOptionPane.showMessageDialog(this,e);}
   
   }
   public void check()
{ 

    for(int i =0;i<table.getRowCount()-1;i++)
    { 
            if(table.getValueAt(i,0)!=null & table.getValueAt(i,1)!=null )
            {   v.add(i);
            }
            else if(table.getValueAt(i,0)==null & table.getValueAt(i,1)==null)
            {continue; }
            else if(table.getValueAt(i,0)==null | table.getValueAt(i,1)==null)
            {
                JOptionPane.showMessageDialog(this,"Please fill all the required Details in Table");
                break;
                
            }
    }

for(int i =0 ;i<v.size() ;i++)
{ 

{ System.out.println(v.get(i));}
}

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

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        stocks = new javax.swing.JLabel();
        sales = new javax.swing.JLabel();
        gate = new javax.swing.JLabel();
        purchase = new javax.swing.JLabel();
        purchase1 = new javax.swing.JLabel();
        damage = new javax.swing.JLabel();
        damage1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

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
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ITEM", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setIntercellSpacing(new java.awt.Dimension(1, 3));
        table.setRowSelectionAllowed(false);
        table.setSelectionBackground(new java.awt.Color(255, 255, 153));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 900, -1));

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

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 160, 440));

        jLabel1.setBackground(new java.awt.Color(255, 102, 102));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 10, 530));

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 0));
        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setForeground(new java.awt.Color(255, 255, 51));
        jMenu1.setText("OPTIONS");
        jMenu1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu1.setOpaque(true);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem1.setText("SAVE");
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem2.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem2.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem2.setText("PRINT");
        jMenuItem2.setOpaque(true);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        // TODO add your handling code here:
     
    }//GEN-LAST:event_tableFocusGained

    private void tableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tableFocusLost

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        v.clear();
        check();
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            boolean ok = job.printDialog();
            if (ok) {
                try {
                    job.print();
                    
                    v.clear();
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(this,ex);
                } }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseExited
        // TODO add your handling code here:
       
    }//GEN-LAST:event_panelMouseExited

    private void salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseClicked
        // TODO add your handling code here:
        sales_report obj = new sales_report();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_salesMouseClicked

    private void stocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseEntered
       // TODO add your handling code here:
       panel.show();
    }//GEN-LAST:event_stocksMouseEntered

    private void salesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseEntered
    // TODO add your handling code here:
    panel.show();
    }//GEN-LAST:event_salesMouseEntered

    private void gateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMouseEntered
       // TODO add your handling code here:
       panel.show();
    }//GEN-LAST:event_gateMouseEntered

    private void purchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMouseEntered
      // TODO add your handling code here:
      panel.show();
    }//GEN-LAST:event_purchaseMouseEntered

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
panel.show();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void stocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_stocksMouseExited

    private void salesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseExited
     // TODO add your handling code here:
    }//GEN-LAST:event_salesMouseExited

    private void gateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMouseExited
      // TODO add your handling code here:
    }//GEN-LAST:event_gateMouseExited

    private void purchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseMouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
        panel.hide();
    }//GEN-LAST:event_formMouseEntered

    private void gateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMousePressed
window obj = new window();
this.dispose();
obj.show();// TODO add your handling code here:
    }//GEN-LAST:event_gateMousePressed

    private void purchaseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMousePressed
        // TODO add your handling code here:
        options obj = new options();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_purchaseMousePressed

    private void stocksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMousePressed
        // TODO add your handling code here:
        stocks1 obj = new stocks1();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_stocksMousePressed

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
home obj = new home();
        this.dispose();
        obj.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is noTABLEable, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(stocks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(stocks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(stocks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(stocks1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stocks1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel damage;
    private javax.swing.JLabel damage1;
    private javax.swing.JLabel gate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel purchase;
    private javax.swing.JLabel purchase1;
    private javax.swing.JLabel sales;
    private javax.swing.JLabel stocks;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
