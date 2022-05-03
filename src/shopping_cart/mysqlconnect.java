
package shopping_cart;
import java.sql.*;
public class mysqlconnect {

	private static Connection con;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
 
    public Connection getConnection() {
        con = null;
        
        try {
            URL = "jdbc:mysql://localhost:3306/shopping";
            USER = "root";
            PASSWORD = "";
            con =DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return (con);
    }
 
    public static void freeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
    }
 
}

