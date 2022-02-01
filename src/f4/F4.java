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
public class F4 {
public static String e(String my)
{ String m = "";
    for(int i=0;i<my.length();i++)
		{
		switch (my.charAt(i) )
		{
		case 'a':
  {
 m= m +  "q";
 break;
  }
case  'b' :
  {
 m= m +  "w";
 break;
  }
case 'c' :
  {
 m= m +  "e";
 break;
  }
case 'd' :
  {
 m= m + "r" ;
 break;
  }
case 'e' :
  {
 m= m + "t" ;
 break;
  }
case 'f' :
  {
 m= m + "y" ;
 break;
  }
case 'g' :
  {
 m= m + "u" ;
 break;
  }
case 'h' :
  { 
 m= m + "i" ;
 break;
  }
case 'i' :
  {
 m= m + "o" ;
 break;
  }
case 'j' :
  {
 m= m + "p" ;
 break;
  }
case 'k' :
  {
 m= m + "a" ;
 break;
  }
case 'l' :
  {
 m= m + "s" ;
 break;
  }
case 'm' :
  { 
 m= m + "d" ;
 break;
  }
case 'n' :
  {
 m= m + "f" ;
 break;
  }
case 'o' :
  {
 m= m + "g" ;
 break;
  }
case 'p' :
  {
 m= m + "h" ;
 break;
  }
case 'q' :
  {
 m= m + "j" ;
 break;
  }
case 'r' :
  {
 m= m + "k" ;
 break;
  }
case 's' :
  {
 m= m + "l" ;
 break;
  }
case 't' :
  {
 m= m + "z" ;
 break;
  }
case 'u':
  {
 m= m + "x" ;
 break;
  }
case 'v':
  {
 m= m +  "c";
 break;
  }
case 'w':
  {
 m= m + "v" ;
 break;
  }
case 'x':
  {
 m= m + "b" ;
 break;
  }
case 'y':
  {
 m= m + "n" ;
 break;
  }
case 'z':
  {
 m= m + "m" ;
 break;
  }
case 'A':
  {
 m= m +  "M";
 break;
  }
case 'B':
  {
 m= m + "N";
 break;
  }
case 'C':
  {
 m= m +  "B";
 break;
  }
case 'D':
  {
 m= m + "V" ;
 break;
  }
case 'E':
  {
 m= m + "C" ;
 break;
  }
case 'F':
  {
 m= m + "X" ;
 break;
  }
case 'G':
  {
 m= m + "Z" ;
 break;
  }
case 'H':
  {
 m= m +  "L";
 break;
  }
case 'I':
  {
 m= m +  "K";
 break;
  }
case 'J':
  {
 m= m + "J" ;
 break;
  }
case 'K':
  {
 m= m + "H" ;
 break;
  }
case 'L':
  {
 m= m +  "G";
 break;
  }
case 'M':
  {
 m= m +  "F";
 break;
  }
case 'N':
  {
 m= m +  "D";
 break;
  }
case 'O':
  {
 m= m +  "S";
 break;
  }
case 'P':
  {
 m= m +  "A";
 break;
  }
case 'Q':
  {
 m= m + "P" ;
 break;
  }
case 'R':
  {
 m= m + "O" ;
 break;
  }
case 'S':
  {
 m= m + "I" ;
 break;
  }
case 'T':
  {
 m= m + "U" ;
 break;
  }
case 'U':
  {
 m= m + "Y" ;
 break;
  }
case 'V':
  {
 m= m + "T" ;
 break;
  }
case 'W':
  {
 m= m + "R" ;
 break;
  }
case 'X':
  {
 m= m + "E"  ;
 break;
  }
case 'Y':
  {
 m= m + "W" ;
 break;
  }
case 'Z':
  {
 m= m + "Q"  ;
 break;
  }

 case '0':
  { m=m+"1";
  break;}
  case '1':
  { m=m+"4";
  break;}
  case '2':
  { m=m+"3";
  break;}
  case '3':
  { m=m+"2";
  break;}
  case '4':
  { m=m+"5";
  break;}
  case '5':
  { m=m+"6";
  break;}
  case '6':
  { m=m+"7";
  break;}
  case '7':
  { m=m+"0";
  break;}
    case '8':
  { m=m+"9";
  break;}
  case '9':
  { m=m+"8";
  break;}
default :
{  
m=m+my.charAt(i);
}

} } 
return(m);
}
    
    
  public static String d (String my)
  { String m="";
      for(int i=0;i<my.length();i++)
		{
		switch (my.charAt(i) )
		{
		case 'a':
  {
 m= m +  "k";
 break;
  }
case  'b' :
  {
 m= m +  "x";
 break;
  }
case 'c' :
  {
 m= m +  "v";
 break;
  }
case 'd' :
  {
 m= m + "m" ;
 break;
  }
case 'e' :
  {
 m= m + "c" ;
 break;
  }
case 'f' :
  {
 m= m + "n" ;
 break;
  }
case 'g' :
  {
 m= m + "o" ;
 break;
  }
case 'h' :
  { 
 m= m + "p" ;
 break;
  }
case 'i' :
  {
 m= m + "h" ;
 break;
  }
case 'j' :
  {
 m= m + "q" ;
 break;
  }
case 'k' :
  {
 m= m + "r" ;
 break;
  }
case 'l' :
  {
 m= m + "s" ;
 break;
  }
case 'm' :
  { 
 m= m + "z" ;
 break;
  }
case 'n' :
  {
 m= m + "y" ;
 break;
  }
case 'o' :
  {
 m= m + "i" ;
 break;
  }
case 'p' :
  {
 m= m + "j" ;
 break;
  }
case 'q' :
  {
 m= m + "a" ;
 break;
  }
case 'r' :
  {
 m= m + "d" ;
 break;
  }
case 's' :
  {
 m= m + "l" ;
 break;
  }
case 't' :
  {
 m= m + "e" ;
 break;
  }
case 'u':
  {
 m= m + "g" ;
 break;
  }
case 'v':
  {
 m= m +  "w";
 break;
  }
case 'w':
  {
 m= m + "b" ;
 break;
  }
case 'x':
  {
 m= m + "u" ;
 break;
  }
case 'y':
  {
 m= m + "f" ;
 break;
  }
case 'z':
  {
 m= m + "t" ;
 break;
  }
case 'A':
  {
 m= m +  "P";
 break;
  }
case 'B':
  {
 m= m + "C";
 break;
  }
case 'C':
  {
 m= m +  "E";
 break;
  }
case 'D':
  {
 m= m + "N" ;
 break;
  }
case 'E':
  {
 m= m + "X" ;
 break;
  }
case 'F':
  {
 m= m + "M" ;
 break;
  }
case 'G':
  {
 m= m + "L" ;
 break;
  }
case 'H':
  {
 m= m +  "K";
 break;
  }
case 'I':
  {
 m= m +  "S";
 break;
  }
case 'J':
  {
 m= m + "J" ;
 break;
  }
case 'K':
  {
 m= m + "I" ;
 break;
  }
case 'L':
  {
 m= m +  "H";
 break;
  }
case 'M':
  {
 m= m +  "A";
 break;
  }
case 'N':
  {
 m= m +  "B";
 break;
  }
case 'O':
  {
 m= m +  "R";
 break;
  }
case 'P':
  {
 m= m +  "Q";
 break;
  }
case 'Q':
  {
 m= m + "Z" ;
 break;
  }
case 'R':
  {
 m= m + "W" ;
 break;
  }
case 'S':
  {
 m= m + "O" ;
 break;
  }
case 'T':
  {
 m= m + "V" ;
 break;
  }
case 'U':
  {
 m= m + "T" ;
 break;
  }
case 'V':
  {
 m= m + "D" ;
 break;
  }
case 'W':
  {
 m= m + "Y" ;
 break;
  }
case 'X':
  {
 m= m + "F"  ;
 break;
  }
case 'Y':
  {
 m= m + "U" ;
 break;
  }
case 'Z':
  {
 m= m + "G"  ;
 break;
  }
	
case '0':
  { m=m+"7";
 break;}
  case '1':
  { m=m+"0";
  break;}
  case '2':
  { m=m+"3";
  break;}
  case '3':
  { m=m+"2";
  break;}
  case '4':
  { m=m+"1";
  break;}
  case '5':
  { m=m+"4";
  break;}
  case '6':
  { m=m+"5";
  break;}
  case '7':
  { m=m+"6";
  break;}
    case '8':
  { m=m+"9";
  break;}
  case '9':
  { m=m+"8";
  break;}
  default :
{  
m=m+my.charAt(i);
}
		}
		}
      return(m);
  }
    

    public static void main(String[] args) {
        // TODO code application logic here
login obj = new login();
obj.show();
    }
    
}
