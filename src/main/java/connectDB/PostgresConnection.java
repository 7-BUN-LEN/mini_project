package connectDB;

import model.Product;
import util.GetProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class PostgresConnection {
    private static  final  String USERNAME = GetProperties.read().getProperty("user");
    private static  final  String PASSWORD = GetProperties.read().getProperty("password");
    private static  final  String URL = GetProperties.read().getProperty("url");
    public static Connection connection() {
        try {
            Connection cn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return cn;
        }catch (SQLException ex){
            return null;
        }
    }
}
