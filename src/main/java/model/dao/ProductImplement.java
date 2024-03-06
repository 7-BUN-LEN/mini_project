package model.dao;

import connectDB.PostgresConnection;
import model.dto.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ProductImplement implements ProductService {
    @Override
    public boolean insert(Product products)  {
        String insert= "INSERT INTO product_tb(Name,Unit_Price,QTY)\n" +
                "VALUES ('" +products.getName()+
                "'," +products.getUnitPrice()+
                "," +products.getQty()+
                ")";
        try(Connection cn = PostgresConnection.connection()){
            Statement st = cn.createStatement();
            st.execute(insert);
            return true;
        }catch (SQLException ex){
            return false;
        }
    }
    @Override
    public boolean update(Product products) {
        String update= "UPDATE product_tb SET name = Sting WHERE id = 6";
        try(Connection cn = PostgresConnection.connection()){
            Statement st = cn.createStatement();
            st.execute(update);
            return true;
        }catch (SQLException ex){
            return false;
        }
    }
    @Override
    public boolean delete(Product products) {
        String delete= "DELETE FROM product_tb WHERE id = "+products.getId()+"";
        try(Connection cn = PostgresConnection.connection()){
            Statement st = cn.createStatement();
            st.execute(delete);
            return true;
        }catch (SQLException ex){
            return false;
        }
    }
    @Override
    public boolean search(Product products) {
        String search= "SELECT * FROM product_tb WHERE name LIKE '%s%'";
        try(Connection cn = PostgresConnection.connection()){
            Statement st = cn.createStatement();
            st.execute(search);
            return true;
        }catch (SQLException ex){
            return false;
        }
    }
    @Override
    public ResultSet view(String views) {
        String view= "SELECT * FROM product_tb WHERE id = 2";
        try(Connection cn = PostgresConnection.connection()){
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(view);
            return rs;
        }catch (SQLException ex){
            return null;
        }
    }
    @Override
    public int count(){
        String count = "SELECT COUNT(*) FROM product_tb";
        try(Connection cn = PostgresConnection.connection()){
            Statement st = cn.createStatement();
            st.execute(count);
            return 1;
        }catch (SQLException ex) {
            return 1;
        }
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
