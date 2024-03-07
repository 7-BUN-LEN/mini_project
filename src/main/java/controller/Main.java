package controller;

import model.dao.ProductImplement;
import model.dto.Product;
import util.Validate;
import view.View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ProductImplement model = new ProductImplement();
        int start = 0;
        int limite = 2;
        int cur_page = 1;
        int totalItems = model.count();
        int totalPages = (int) Math.ceil((double) totalItems / limite);
        do {
            View view = new View();
            int count = model.count();
            try {
                ResultSet rs = model.selectAll(limite,start);
                view.display(rs,limite,count,cur_page);
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
            System.out.println("F) First\t\t P) Previous\t\t N) Next\t\t L) Last\t\t G) Go to");
            System.out.println();
            System.out.println("================================================== Display ==================================================");
            System.out.println("W) Write\t\t R) Read\t\t U) update\t\t D) Delete\t\t S) Search\t\t Se) Set Row");
            System.out.println("Sa) Save\t\t Un) UnSave\t\t Ba) BackUp\t\t Re) Restore\t\t E)exit");
            System.out.println("=============================================================================================================");
            System.out.print("Choose Option : ");
            String option = scanner.next();
//            try {
//                if(!Validate.validate_option_char(option)){
//                    do {
//                        System.out.println("Option do not match !!!!");
//                        System.out.print("Choose Option : ");
//                        option = scanner.next();
//                    }while (!Validate.validate_option_char(option));
//                }
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
            switch (option){
                case "F" ->{
                    cur_page=1;
                    start = 0;
                    break;
                }
                case "P" ->{
                    if(cur_page > 1){
                        cur_page--;
                    }
                    if(start != 0){
                        start = start-limite;
                    }else{
                        start = 0;
                    }
                    break;
                }
                case "N" ->{
                    if(cur_page != totalPages){
                        cur_page++;
                    }else{
                        start = totalItems - limite;
                    }
                    if(start < totalItems-limite){
                        start = start+limite;
                    }else{
                        start = (totalItems - 1) * limite;
                    }
                    break;
                }
                case "L" ->{
                    cur_page = totalPages;
                    if(limite == 2){
                        start = totalItems-(totalItems % limite) - 2 ;
                    }else{
                        start = totalItems-(totalItems % limite);
                    }
                    break;
                }
                case "G" ->{
                    System.out.print("Enter page :");
                    int page_re = scanner.nextInt();
                    scanner.nextLine();
                    if(page_re <= totalPages){
                        cur_page = page_re;
                        start = (page_re - 1) * limite;
                    }else{
                        System.out.println("Out off limite page");
                        return;
                    }
                    break;
                }
                case "W" ->{
                    Product insert = view.write();
                    model.insert(insert);
                    System.out.println("Product created successfully");
                    break;
                }
                case "R" ->{
                    System.out.print("Enter ID to show product : ");
                    String id = scanner.next();
                    ResultSet rs = model.view(id);
                    view.read(rs);
                    break ;
                }
                case "U" ->{

                    break;
                }
                case "D" ->{
                    System.out.print("Enter ID to delete product : ");
                    String id = scanner.next();
                    ResultSet rs = model.delete(id);
                    view.delete(rs);
                    break;
                }
                case "S" ->{
                    System.out.print("Enter product name to search : ");
                    String search = scanner.next();
                    ResultSet rs = model.search(search);
                    view.search(rs);
                    break;
                }
                case "Se" ->{
                    break;
                }
                case "Sa" ->{
                    break;
                }
                case "Un" ->{
                    break;
                }
                case "Ba" ->{
                    break;
                }
                case "Re" ->{
                    break;
                }
                case "E" ->{
                    break;
                }
            }
        }while (true);
    }
}
