/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doorto;


import java.sql.DriverManager;
import java.sql.Connection;


public class Database {
    
    public static Connection connectDb(){
        
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           Connection connect= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/doorproject","admin","1234");//Database name: admindoor
           return connect;
           
       }catch(Exception e)
       {
           e.printStackTrace();
       }
        return null;
    }
    
    
}
