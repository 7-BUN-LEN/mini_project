package model.dao;

import model.dto.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProductService {
    boolean insert(Product products) throws SQLException;
    boolean update(Product products) throws SQLException;
    boolean delete(Product products) throws SQLException;
    boolean search(Product products) throws SQLException;
    ResultSet view (String views) throws SQLException;
    int count() throws SQLException;
    boolean duplicate(Product products) throws SQLException;
    ResultSet selectAllData() throws SQLException;
}
