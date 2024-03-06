import model.dao.ProductImplement;
import view.View;
import controller.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ResultSet rs;
    private static boolean b =true;
    public static void main(String[] args) {
        ProductImplement pm = new ProductImplement();
        rs =pm.selectAllData();
        do{
            try{
                View.display(rs,1,5);
            }catch (SQLException ex){
                System.out.println("Noo Data!!!!!!!!!!!!!!!");
            }
            System.out.print("Press => ");
            String option = scanner.nextLine();
            switch (option.toLowerCase()){
                case "w"->{ Control.writeDate();rs =pm.selectAllData();}
                case "u"->{ Control.updateData();}
                case "d"->{ Control.deleteDate();rs =pm.selectAllData();}
                case "f"->{ Control.firstPage();}
                case "p"->{ Control.previous();}
                case "n"->{ Control.next();}
                case "l"->{ Control.lastPage();}
                case "s"->{ Control.search();}
                case "g"->{ Control.Goto();}
                case "se"->{Control.setRow();}
                case "sa"->{Control.save();}
                case "ba"->{Control.backUP();}
                case "re"->{Control.restore();}
                case "h"->{ Control.help();}
                case "e"->{ b = false;}
            }
        }while (b);
    }
}
