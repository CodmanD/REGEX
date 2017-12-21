/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeinputstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class ChangeInputString {

    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         String text="with Its Powerful,E tools And,H dazzling effects,Keynote makes..   t it Easy to create stunning and memorable presentations.to ";
        
         
       // String text = "See Who you `re working with ... While you`re editing, a separate.tooo list lets you quickly see who else is in the presentation.";
         
        StringBuffer buffer = new StringBuffer();
         
         //Изменяем первую букву текста
         Pattern p=Pattern.compile("\\A[a-z]");
         Matcher m =p.matcher(text); 
       
         if(m.find())
            text = m.replaceAll( m.group().toUpperCase());
         System.out.println(text);
         
         
         //Изменяем большие буквы после запятой
          p = Pattern.compile("\u002c[A-Z]");  
          m = p.matcher(text);  
           buffer.delete(0,buffer.capacity());
          while(m.find())
          {
              
            // System.out.println(" rep = "+m.group().substring(m.group().length()-1,m.group().length()).toUpperCase());
              m.appendReplacement(buffer,", "+ m.group().substring(m.group().length()-1,m.group().length()).toLowerCase());
          }
           m.appendTail(buffer);
         text=buffer.toString();
        System.out.println(text);
  
  
         
        //Изменяем большие буквы внутри текста
          p = Pattern.compile("[a-z]\\s[A-Z]");  
          m = p.matcher(text);  
          buffer.delete(0,buffer.capacity());
      
          while(m.find())
          {
              
             // System.out.println(" rep = "+m.group().substring(m.group().length()-1,m.group().length()).toUpperCase());
              m.appendReplacement(buffer,m.group().substring(0,1)+" "+ m.group().substring(m.group().length()-1,m.group().length()).toLowerCase());
          }
           m.appendTail(buffer);
           text=buffer.toString();
           System.out.println(text);
   
           
           //Изменяем маленькие буквы после точки
          p = Pattern.compile("\\.[a-z]");  
          m = p.matcher(text);  
          buffer.delete(0,buffer.capacity());
      
          while(m.find())
          {
              
             // System.out.println(" report = "+m.group().substring(m.group().length()-1,m.group().length()).toUpperCase());
              m.appendReplacement(buffer,". "+ m.group().substring(m.group().length()-1,m.group().length()).toUpperCase());
          }
          m.appendTail(buffer);
          text=buffer.toString();
          System.out.println(text);
         
         
    }
    
}
