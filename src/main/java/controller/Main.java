package controller;

import model.dao.ProductImplement;
import view.View;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ProductImplement pm = new ProductImplement();
        try{
            View.display(pm.selectAllData(),1,5);
        }catch (SQLException ex){
            System.out.println("Noo Data!!!!!!!!!!!!!!!");
        }
    }
}
