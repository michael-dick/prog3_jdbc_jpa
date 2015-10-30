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


    /**
     * Connects to the mySQL DB specified in the name
     * @param dbName the name of the DB
     */
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

    /**
     * Disconnects from the connected DB
     */
    public void disconnect(){
        try {
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    /**
     * Inserts a new Java-Object into the database
     * @param entity the object to insert
     */
    public abstract void insert(TYPE entity);


    /**
     * Updates an existing entity in the DB
     * @param identifier the primary key
     * @param update the entity with the new attributes
     */
    public abstract void update (KEY identifier , TYPE update);


    /**
     * Deletes an existing entity
     * @param identifier the primary key
     */
    public abstract void delete(KEY identifier);

    /**
     * Searches an entity
     * @param identifier the primary key
     * @return the result set
     * @throws SQLException
     */
    public abstract ResultSet search(KEY identifier) throws SQLException;
}