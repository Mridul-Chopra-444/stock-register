package f4;


import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class m extends JTable
{
  static Component c;
    
   
    public Component prepareRenderer(TableCellRenderer r,int rw,int col)
    {
         c = super.prepareRenderer(r,rw,col);
        c.setBackground(Color.WHITE);
      if(col==0 & rw==1)
        {c.setBackground(Color.PINK);}
        return c;
        
    }
    
    public static Component change(int col , int rw)
    { 
   //  if(col==0 & rw==1)
        {
            c.setBackground(Color.PINK);
        }
        return c;

    }
     public void focusGained(java.awt.event.FocusEvent evt) {
                
            }

}
