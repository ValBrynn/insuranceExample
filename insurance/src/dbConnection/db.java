/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

/**
 *
 * @author Administrator
 */

    import java.sql.*;
public class db {

    private static Connection conn=null;
    //private Connection conn=null;

    public   static  Connection  getConnection() throws SQLException {

        try{
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance?autoReconnect=true&useSSL=false","root","kth123");
           
           // System.out.println("DB connected");
        }catch(SQLException exec){

        exec.printStackTrace();
    }
    
    return conn;
}
    
    public void disConnect() throws SQLException{
     
        conn.close();
        
    }
}


