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
        String insert= "INSERT INTO product_tb(Name,Unit_Price,QTY)\n" +
                "VALUES ('" +products.getName()+
                "'," +products.getUnitPrice()+
                "," +products.getQty()+
                ")";
        return false;
    }
    @Override
    public boolean update(Product products) {
        String update= "UPDATE product_tb SET name = Sting WHERE id = 1";
        return false;
    }
    @Override
    public boolean delete(Product products) {
        String delete= "DELETE FROM product_tb WHERE id = 1";
        return false;
    }
    @Override
    public boolean search(Product products) {
        String search= "SELECT * FROM product_tb WHERE name LIKE '%s%'";
        return false;
    }
    @Override
    public boolean view(String views) {
        String view= "SELECT * FROM product_tb WHERE id = 2";
        return false;
    }
    @Override
    public int count(){
        String view= "SELECT COUNT(*) FROM product_tb";
        return 0;
    }
    @Override
    public boolean dupplicate(Product products) throws SQLException {
        String duplicate= "SELECT name FROM product_tb WHERE LOWER(name) = 'coca' AND id != 2";
        if(duplicate != null){
            return true;
        }else {
            return false;
        }
    }
//    @Override
//    public int auto_id() throws SQLException {
//        String view= "SELECT id FROM product_tb ORDER BY id DESC LIMIT 1";
//        return 1;
//    }
}
