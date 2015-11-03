package prog3.jdbc.Metzgerei;

import java.sql.*;

/**
 * Created by MichaelDick and Philipp Ratz on 02/11/15.
 */
public class SelectTest {

    public static void main(String[] args) {

        Connection con;
        Statement stmt;
        ResultSet result;


        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("driver loaded");
        } catch (Exception ex) {
            System.out.println("Driver: " + ex.getMessage());
            System.out.println("Error: " + ex.toString());
        }

        //Connection
        try {


            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost/wurstDB", "root", "");



            System.out.println("connection established");


            stmt = con.createStatement();

            String query = "SELECT * FROM wurst";

            result = stmt.executeQuery(query);

            while (result.next()) {

                System.out.println("PLU: " + result.getInt("plu"));
                System.out.println("Bezeichnung: " + result.getString("bezeichnung"));
                System.out.println("Kilopreis: " + result.getDouble("kilopreis") + "€");
                System.out.println("Kilobestand: " + result.getDouble("kilobestand") + "kg");
                System.out.println("-----------------------------------");
            }



        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());

        }


    }

}
