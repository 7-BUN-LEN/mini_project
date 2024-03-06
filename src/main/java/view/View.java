package view;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.ResultSet;
import java.sql.SQLException;

public class View {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_VIOLETS = "\u001b[36m";

    //    ResultSet resultSet , int start, int limit
    public static void display(ResultSet resultSet, int start, int limit) throws SQLException
    {
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table t = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);

        t.setColumnWidth(0, 15, 30);
        t.setColumnWidth(1, 25, 30);
        t.setColumnWidth(2, 25, 30);
        t.setColumnWidth(3, 25, 30);
        t.setColumnWidth(4, 25, 30);

        t.addCell(ANSI_BLUE + "ID" + ANSI_RESET, numberStyle);
        t.addCell(ANSI_GREEN + "Product Name" + ANSI_RESET, numberStyle);
        t.addCell(ANSI_YELLOW + "Unit Price" + ANSI_RESET, numberStyle);
        t.addCell(ANSI_RED + "QTY" + ANSI_RESET, numberStyle);
        t.addCell(ANSI_RED + "Imported Date" + ANSI_RESET, numberStyle);

        start = 0;
        limit = 5;
        while (resultSet.next() && start< limit) {
            resultSet.next();
            resultSet.getRowId("id");
            resultSet.getString("name");
            resultSet.getDouble("unitPrice");
            resultSet.getInt("qty");
            resultSet.getDate("imported date");
            start++;
        }

        System.out.println(t.render());

    }


}

