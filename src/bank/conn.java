/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmdb?zeroDateTimeBehavior=convertToNull","root","1040");
            s = c.createStatement();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}
