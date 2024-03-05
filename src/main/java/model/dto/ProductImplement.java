package model.dto;

import connectDB.PostgresConnection;
import model.Product;
import model.dao.ProductService;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProductImplement implements ProductService {

    @Override
    public boolean insert(Product products)  {
        //connection
        //statement
        String query= "INSERT INTO product_tb(Name,Unit_Price,QTY)\n" +
                "VALUES ('" +products.getName()+
                "'," +products.getUnitPrice()+
                "," +products.getQty()+
                ")";
        try(
                Connection cn = PostgresConnection.connection();
                ) {
            Statement st = cn.createStatement();
            st.execute(query);
            return true;
        }catch (SQLException ex){
        return false;
        }

    }
    @Override
    public boolean update(Product products) {
        return false;
    }

    @Override
    public boolean delete(Product products) {
        return false;
    }

    @Override
    public boolean search(Product products) {
        return false;
    }

    @Override
    public boolean view(String views) {
        return false;
    }
}
