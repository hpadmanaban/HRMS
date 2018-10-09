package com.utkrusht.leavemodule.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionAgent {
    public static Connection con;

    public static Connection getConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leavemodule", "root", "Practo");
            return con;
        }
        catch (SQLException e){
            System.out.println("Error in connecting " + e.getMessage());
            return null;
        }
    }

}
