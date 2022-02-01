
package f4;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.print.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;


import javax.swing.JComboBox;
import javax.swing.*;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;


import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;



 
public class window extends javax.swing.JFrame implements Printable{
 Connection cn;
String url,sql;
Statement st;
ResultSet rs;
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
   DefaultTableModel model;
 
    String items[];     
    String names[];
   
    int so;
 A a = new A();
        B b = new B();
 
    JTextArea txt = new JTextArea();  
    public window() {
        go();
        get_names();
        
        initComponents();
         this.getContentPane().setBackground(new java.awt.Color(221,217,217));
panel.hide();
        get_sno();
        //this.getContentPane().setBackground(new java.awt.Color(204, 255, 255));
        sno.setText(so+"");
        
       
       
       JComboBox combobox = new JComboBox(items);
        model = (DefaultTableModel)table.getModel();
       
        AutoCompleteDecorator.decorate(combobox);
       
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setCellEditor(new ComboBoxCellEditor(combobox));
       centerRenderer.setHorizontalAlignment( JLabel.CENTER);
table.setDefaultRenderer(Float.class, centerRenderer);

       b.start();
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
    
    atString= new AttributedString("S.No : ");
    atString.addAttribute(TextAttribute.FONT, font);
     g.drawString(atString.getIterator(),100,145);
    g.drawString(sno.getText(),140,145);
    
     atString= new AttributedString("Sales-Man Name : ");
    atString.addAttribute(TextAttribute.FONT, font);
    g.drawString(atString.getIterator(),100,170);
   g.drawString(name.getSelectedItem().toString(),220,170);
   
    atString= new AttributedString("Date : ");
    atString.addAttribute(TextAttribute.FONT, font);
    g.drawString(atString.getIterator(),295,145);
    g.drawString(formater.format(date.getDate()),340,145);
    
    
    g.drawLine(80,200,520,200);
    g.drawLine(80,225,520,225);
    int x[]={85,243,345,440};
    atString= new AttributedString("Item");
    atString.addAttribute(TextAttribute.FONT, font);
     g.drawString(atString.getIterator(),x[0],215);
     
    atString= new AttributedString("Quantity Out");
    atString.addAttribute(TextAttribute.FONT, font);
    g.drawString(atString.getIterator(),x[1],215);
    
    atString= new AttributedString("Quantity In");
    atString.addAttribute(TextAttribute.FONT, font);
    g.drawString(atString.getIterator(),x[2],215);
    
    atString= new AttributedString("Net Sale");
    atString.addAttribute(TextAttribute.FONT, font);
   g.drawString(atString.getIterator(),x[3],215);
  
   int y= 243;
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
       g.drawString("",x[2],y);
       g.drawString("",x[3],y);
   g.drawLine(80,y+7,520,y+7);
   y+=27;
   
   
   i++;
   
   
   }
   z=i;
   if(z>=v.size())
   { ppage=-1;
   z=0;
  // System.out.print("Clearing ;;");
   
   
   }
   g.drawLine(80,200,80,y-27+7);
   g.drawLine(x[1]-3,200,x[1]-3,y-27+7);
  g.drawLine(x[2]-10,200,x[2]-10,y-27+7);
   g.drawLine(x[3]-10,200,x[3]-10,y-27+7);
   g.drawLine(520,200,520,y-27+7);
  g.drawString("TOTAL : ",x[3],y-7);
    }
   ppage=page;
return PAGE_EXISTS; 
} 


Vector v = new Vector(0,1);
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




public void save()
{ 
check();
myconnection();

   

   
   Calendar cal =Calendar.getInstance();
   cal.setTime(date.getDate());
  
   java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
try{
for(int i=0;i<v.size();i++)
{ 
    float s;
    if(table.getValueAt(Integer.parseInt(v.get(i).toString()),2)!=null)
    {s= Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),2).toString());
    }
    else {s=0.0F;}
    
    sql="Insert into sales(sno,item,salesman,qout,qin,net,dos) values ("+
           Integer.parseInt(sno.getText()) +","+
            "'"+table.getValueAt(Integer.parseInt(v.get(i).toString()),0).toString()+"',"+
            
            "'"+name.getSelectedItem().toString()+"',"+
            
    +Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),1).toString()) +","+
            s+","
            +Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),3).toString()) +","+
            
        "'"+timestamp+"');";
     st=cn.createStatement();
  st.executeUpdate(sql);
stocks_update(table.getValueAt(Integer.parseInt(v.get(i).toString()),0).toString(),-Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),3).toString()) );
}
JOptionPane.showMessageDialog(this,"Record Saved");

}
catch(Exception e)
{ System.out.println(e);}


}




public void get_sno()
{ 

myconnection();
try
{
sql="select distinct sno from sales";
st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
  
 //while(!rs.last())
 {
// so = rs.getInt("sno");
   }
 
  //System.out.println(rs.getString("salesman") );
  if(rs.next())
  {
   System.out.println("-----SETTING  1 ---"+so);
  rs.last();
   so = rs.getInt("sno");
  // System.out.println("----SETTING 2 ---"+so);
   so+=1;
   System.out.println("----SETTING 3 ---"+so);
  }
  else {so=1;}
  
 
}
catch(Exception e)
{ JOptionPane.showMessageDialog(this,e);}

}


public void after_save()
{ 

int rowCount = v.size();
//Remove rows one by one from the end of the table
for (int i = rowCount - 1; i >= 0; i--) {
    table.setValueAt(null,Integer.parseInt(v.get(i).toString()),0);
    table.setValueAt(null,Integer.parseInt(v.get(i).toString()),1);
   table.setValueAt(null,Integer.parseInt(v.get(i).toString()),2);
table.setValueAt(null,Integer.parseInt(v.get(i).toString()),3);

}

 so=Integer.parseInt(sno.getText())+1;
sno.setText(     so+"" );

}

public void open(int s)
{ 
  
myconnection();
try{
 
sql = "Select * from sales where sno ='"+s+"';";
st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
rs=st.executeQuery(sql);
int i=0;
//a.start();
while(rs.next())
{ 
table.setValueAt(rs.getString("item"),i,0);
table.setValueAt(rs.getInt("qout"),i,1);
table.setValueAt(rs.getString("qin"),i,2);
table.setValueAt(rs.getString("net"),i,3);
lname.setText(rs.getString("salesman"));
ldate.setText(rs.getDate("dos").toString());
date.setDate(rs.getDate("dos"));
name.setSelectedItem(rs.getString("salesman"));
i++;
sno.setText(s+"");
}
for(int j=i;j<table.getRowCount();j++)
{
table.setValueAt(null,j,0);
table.setValueAt(null,j,1);
table.setValueAt(null,j,2);
table.setValueAt(null,j,3);

}

if(i==0)
{ JOptionPane.showMessageDialog(this,"No Records Found");}

else { date.hide(); name.hide();
        lname.show();ldate.show();

}
System.out.println(table.getSelectedRow());

}
catch(Exception e)
{
JOptionPane.showMessageDialog(this,e);
}


}


public void update()
{ 
    v.clear();
    
myconnection();
try {
sql = "Select * from sales where sno='"+sno.getText()+"'";
st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
rs=st.executeQuery(sql);

if(!rs.next())
{JOptionPane.showMessageDialog(this,"No Record Found to be Updated.\n Make Sure that you have entered the record before.");
}
else
{
check();
Vector n = new Vector();
Vector z = new Vector();
Vector x = new Vector();
Vector y = new Vector();
rs=st.executeQuery(sql);
while(rs.next())
{ 
z.add(rs.getInt("id"));
x.add(rs.getInt("qin"));
y.add(rs.getInt("qout"));
n.add(rs.getString("item"));
}
for(int i=0;i<v.size();i++)
{ 
    
  
     Calendar cal =Calendar.getInstance();
   cal.setTime(date.getDate());
  
   java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
    if(i<z.size())
    {    
    
sql = "Update sales set item='"+table.getValueAt(Integer.parseInt(v.get(i).toString()),0)+"'"+
                                                  ", qout = '"+table.getValueAt(Integer.parseInt(v.get(i).toString()),1)+"'"+
                                                    ",qin ='"+table.getValueAt(Integer.parseInt(v.get(i).toString()),2)+"',"+
                                                     "net ='"+table.getValueAt(Integer.parseInt(v.get(i).toString()),3)+"' ,"+
                                                      "dos ='"+timestamp+"' ,"+
                                                      "salesman ='"+name.getSelectedItem()+"'"+
        "where id = '"+z.get(i)+"'";
 st=cn.createStatement();
   st.executeUpdate(sql);
    if(n.get(i).equals(table.getValueAt(i,0)))
    {
String item=table.getValueAt(Integer.parseInt(v.get(i).toString()),0).toString();
float a =Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),1).toString())- Float.parseFloat(y.get(i).toString());
float b = Float.parseFloat(x.get(i).toString())-Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),2).toString());
float quan = a+b;
stocks_update(item,-quan); 
    }
    
    else { 
    
    stocks_update(n.get(i).toString(),  -Float.parseFloat(x.get(i).toString())+Float.parseFloat(y.get(i).toString()) );
    stocks_update(table.getValueAt(Integer.parseInt(v.get(i).toString()),0).toString(),-Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),3).toString()) );

    }
    
    
    
    } 
else {
         
         float s;
    if(table.getValueAt(Integer.parseInt(v.get(i).toString()),2)!=null)
    {s= Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),2).toString());
    }
    else {s=0;}
    
    sql="Insert into sales(sno,item,salesman,qout,qin,net,dos) values ("+
           Integer.parseInt(sno.getText()) +","+
            "'"+table.getValueAt(Integer.parseInt(v.get(i).toString()),0).toString()+"',"+
            
            "'"+name.getSelectedItem().toString()+"',"+
            
    +Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),1).toString()) +","+
            s+","
            +Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),3).toString()) +","+
            
        "'"+timestamp+"');";
     st=cn.createStatement();
  st.executeUpdate(sql);
stocks_update(table.getValueAt(Integer.parseInt(v.get(i).toString()),0).toString(),-Float.parseFloat(table.getValueAt(Integer.parseInt(v.get(i).toString()),3).toString()) );

            
        
        }
}
JOptionPane.showMessageDialog(this,"Update Successful");
}

}
catch(Exception e)
{ 
JOptionPane.showMessageDialog(this,e);

}

}


 public void stocks_update(String item , float quan)
 { 
 try
 {
 sql="Select * from stocks where item ='"+item+"';";
 st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs=st.executeQuery(sql);
    if(rs.next())
    {
    int quant=rs.getInt(2);
           float n = quant+quan;
     sql="Update stocks set quantity='"+n+"' where item='"+item.toUpperCase()+"' ;";
             st=cn.createStatement();
           st.executeUpdate(sql);
    }
    else {
    
    sql="Insert into stocks values ('"+item.toUpperCase()+"' ,'"+quan+"' );";
     st=cn.createStatement();
           st.executeUpdate(sql);
    }

 }
 catch(Exception e)
 {JOptionPane.showMessageDialog(this,e);}
 
 }
 


public void new_save()
{ 
    try{
myconnection();
sql = "Select * from sales where sno='"+sno.getText()+"'";
st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
rs=st.executeQuery(sql);

if(rs.next())
{ update();
after_save();
get_sno();
sno.setText(so+"");
        v.clear();}
else
{
save();
        after_save();
get_sno();
sno.setText(so+"");
        v.clear();
}

    }
    catch(Exception e)
    {JOptionPane.showMessageDialog(this,e);}

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

  
  
  
  class A extends Thread
{
 public void run()
 { 
 System.out.println("thread is running...");  
   int row1,row=table.getSelectedRow();
     int column1,column=table.getSelectedColumn();
   
 while(true)
 {
     
    row1=row;
     column1=column;
     System.out.println(row1);
     if(row1!=-1 & column1!=-1)
     {
     
      if ((table.getSelectedColumn()==0|table.getSelectedColumn()==2|table.getSelectedRow()!=row1|table.getSelectedColumn()==3) &table.getValueAt(row1,1)!=null)
     {  
         float diff= (table.getValueAt(row, 2)==null)
                 ? Float.parseFloat(table.getValueAt(row1, 1).toString())
         : Float.parseFloat(table.getValueAt(row1, 1).toString())-Float.parseFloat(table.getValueAt(row1, 2).toString());
         diff =Float.parseFloat(String.format("%.3f",diff ));
         table.setValueAt(diff,row1,3);       
        
     }
      if ((table.getSelectedColumn()==0|table.getSelectedColumn()==2|table.getSelectedRow()!=row1|table.getSelectedColumn()==3) &table.getValueAt(row1,1)==null)
     {
      table.setValueAt(null,row1,3);
      }
    if ((table.getSelectedColumn()==0|table.getSelectedColumn()==3|table.getSelectedRow()!=row1|table.getSelectedColumn()==1) &table.getValueAt(row1,1)!=null &table.getValueAt(row1,2)!=null)
     {  
         float diff= (table.getValueAt(row1, 2)==null)
                 ? Float.parseFloat(table.getValueAt(row1, 1).toString())
         : Float.parseFloat(table.getValueAt(row1, 1).toString())-Float.parseFloat(table.getValueAt(row1, 2).toString());
         diff =Float.parseFloat(String.format("%.3f",diff ));
  table.setValueAt(diff,row1,3);
        
     }
       
   
  }
row=table.getSelectedRow();
      column=table.getSelectedColumn(); }
  }
  }
 
  
  class B extends Thread
          { 
            public void run()
            { 
            while(true)
            { float total =0;
            for(int i=0;i<table.getRowCount();i++)
            { 
                if(table.getValueAt(i,3)!=null & table.getSelectedColumn()!=-1&table.getSelectedRow()!=-1)
                {
            total=total+Float.parseFloat(table.getValueAt(i,3).toString());
            }
            }
             sum.setText("TOTAL : "+total);
            }
            }
          }
  
         
 public void go()
 { 
     try
     {
     myconnection();
 sql="Select * from stocks order by item ;";
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
     {JOptionPane.showMessageDialog(this,e);
     }
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        l = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        sno = new javax.swing.JLabel();
        sum = new javax.swing.JLabel();
        name = new javax.swing.JComboBox<>();
        lname = new javax.swing.JLabel();
        ldate = new javax.swing.JLabel();
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
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1600, 900));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        l.setText("S.NO");
        getContentPane().add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 40, 30));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Date");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 50, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Sales-Man Name ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 140, 30));

        table.setBackground(new java.awt.Color(255, 255, 204));
        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        table.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ITEM", "Quantity Out", "Quantity In", "Net Sale"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setIntercellSpacing(new java.awt.Dimension(1, 2));
        table.setRowSelectionAllowed(false);
        table.setSelectionBackground(new java.awt.Color(255, 255, 153));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.setShowHorizontalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocusLost(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 157, 1220, 490));
        getContentPane().add(sno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 100, 30));
        getContentPane().add(sum, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 210, 30));

        name.setModel(new javax.swing.DefaultComboBoxModel<>(names));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 110, -1));

        lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lnameMouseClicked(evt);
            }
        });
        getContentPane().add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 110, 20));

        ldate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ldateMouseClicked(evt);
            }
        });
        getContentPane().add(ldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 140, 30));

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

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 160, 440));

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
        jMenuBar1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jMenu1.setBackground(new java.awt.Color(51, 51, 51));
        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(255, 255, 0));
        jMenu1.setText("Options");
        jMenu1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jMenu1.setOpaque(true);
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem1.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(204, 0, 0));
        jMenuItem1.setText("OPEN");
        jMenuItem1.setOpaque(true);
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem5.setText("SAVE");
        jMenuItem5.setOpaque(true);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem3.setText("PRINT");
        jMenuItem3.setOpaque(true);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setBackground(new java.awt.Color(51, 51, 51));
        jMenuItem4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jMenuItem4.setForeground(new java.awt.Color(255, 0, 0));
        jMenuItem4.setText("REFRESH");
        jMenuItem4.setOpaque(true);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        // TODO add your handling code here:
        if(!a.isAlive())
        a.start();
        
    }//GEN-LAST:event_tableFocusGained

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         String ck = JOptionPane.showInputDialog(this,"Please Enter Serial Number of SalesMan");
         if(ck!=null)
         try{
             open(Integer.parseInt(ck));
         }
         catch(java.lang.NumberFormatException ex)
         { JOptionPane.showMessageDialog(this,"Invalid Input");}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        
        
        {

            
       
        
        check();
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
                after_save();
                v.clear();
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(this,ex);
            } } }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        
        lname.hide();
        ldate.hide();
        name.show();
        date.show();
        
    for(int i =0;i<table.getRowCount()-1;i++)
    { 
            if(table.getValueAt(i,0)!=null |table.getValueAt(i,1)!=null |table.getValueAt(i,2)!=null)
            {   v.add(i);
            }
           
    }
        after_save();
         get_sno();
         sno.setText(so+"");
        sum.setText("");
        v.clear();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void tableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableFocusLost

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        check();
        if(date.getDate()==null)
            {JOptionPane.showMessageDialog(this,"Please Select Date first");}
        else if(v.size()==0)
            {JOptionPane.showMessageDialog(this,"Please Enter details in table");
            }
        else
        {
          v.clear();
        new_save();
        v.clear();
       
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void lnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lnameMouseClicked
        // TODO add your handling code here:
        name.show();
        lname.hide();
    }//GEN-LAST:event_lnameMouseClicked

    private void ldateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ldateMouseClicked
        // TODO add your handling code here:
        date.show();
        ldate.hide();
    }//GEN-LAST:event_ldateMouseClicked

    private void panelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_panelMouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        panel.show();   // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
panel.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    private void tableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseEntered
        // TODO add your handling code here:
        panel.hide();
    }//GEN-LAST:event_tableMouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
home obj = new home();
        this.dispose();
        obj.show();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void purchase1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase1MousePressed
        // TODO add your handling code here
        purchase1 obj = new purchase1();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_purchase1MousePressed

    private void purchase1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase1MouseExited

    private void purchase1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchase1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_purchase1MouseEntered

    private void purchaseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMousePressed
        // TODO add your handling code here:
        options obj = new options();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_purchaseMousePressed

    private void purchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_purchaseMouseExited

    private void purchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_purchaseMouseEntered

    private void gateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMousePressed
        window obj = new window();
        this.dispose();
        obj.show();// TODO add your handling code here:
    }//GEN-LAST:event_gateMousePressed

    private void gateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_gateMouseExited

    private void gateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gateMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_gateMouseEntered

    private void salesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_salesMouseExited

    private void salesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_salesMouseEntered

    private void salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesMouseClicked
        // TODO add your handling code here:
        sales_report obj = new sales_report();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_salesMouseClicked

    private void stocksMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMousePressed
        // TODO add your handling code here:
        stocks1 obj = new stocks1();
        this.dispose();
        obj.show();
    }//GEN-LAST:event_stocksMousePressed

    private void stocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_stocksMouseExited

    private void stocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksMouseEntered
        // TODO add your handling code here:
        panel.show();
    }//GEN-LAST:event_stocksMouseEntered

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
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel damage;
    private javax.swing.JLabel damage1;
    private org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JLabel gate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l;
    private javax.swing.JLabel ldate;
    private javax.swing.JLabel lname;
    private javax.swing.JComboBox<String> name;
    private javax.swing.JPanel panel;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JLabel purchase;
    private javax.swing.JLabel purchase1;
    private javax.swing.JLabel sales;
    private javax.swing.JLabel sno;
    private javax.swing.JLabel stocks;
    private javax.swing.JLabel sum;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
