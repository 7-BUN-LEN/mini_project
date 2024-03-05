package model.dao;

import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService {
    boolean insert(Product products) throws SQLException;
    boolean update(Product products) throws SQLException;
    boolean delete(Product products) throws SQLException;
    boolean search(Product products) throws SQLException;
    boolean view (String views) throws SQLException;
}
