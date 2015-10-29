package prog3.jdbc;

import java.sql.*;

/**
 * Created by MichaelDick on 28/10/15.
 * We use this abstacr class for providing the methods connect(String dbName) and disconnect()
 * the other methods are kept abstract so the logic still has to be implemented
 */

public abstract class GenericDBConnection<KEY , TYPE> {

    //java.sql.Connection etabished the connection to our target database
    public Connection connection;

    //java.sql.Statement is able to perform SQL-Queries on out database
    public Statement mStatement;

    //java.sql.PreparedStatement lets us set parameters(?) in our query to keep the query dynamic
    public PreparedStatement mPreparedStatement;

    public void connect(String dbName){
        //load jdbc driver --> unnecessary beacause we use maven
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("driver loaded");
        } catch (Exception ex) {
            System.out.println("Driver: " + ex.getMessage());
            System.out.println("Error: " + ex.toString());
        }

        //Connection
        try {
            //Connect to database --> name specified
            //username is root, pw is empty --> NOT RECOMMENDED
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/" + dbName, "root", "");

            System.out.println("connection established");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("Error: " + ex.getErrorCode());
        }
    }

    public void disconnect(){
        try {
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    public abstract void post(TYPE entity);

    public abstract void update (KEY identifier , TYPE update);

    public abstract void delete(KEY identifier);

    public abstract ResultSet search(KEY identifier) throws Exception;
}
