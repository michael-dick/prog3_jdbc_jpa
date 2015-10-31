package prog3.jdbc;

import java.sql.*;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 * We use this abstract class for providing the methods connect(String dbName) and disconnect()
 * the other methods are kept abstract so the logic still has to be implemented
 */

public abstract class GenericDBConnection<KEY, TYPE> {

    //java.sql.Connection etabished the connection to our target database
    public Connection connection;

    //java.sql.Statement is able to perform SQL-Queries on out database
    public Statement mStatement;

    //java.sql.PreparedStatement lets us set parameters(?) in our query to keep the query dynamic
    public PreparedStatement mPreparedStatement;


    /**
     * Connects to the mySQL DB specified in the name
     *
     * @param dbName the name of the DB
     */
    public void connect(String dbName) {

        //Would be necessary if we didn't use Maven
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            System.out.println("driver loaded");
//        } catch (Exception ex) {
//            System.out.println("Driver: " + ex.getMessage());
//            System.out.println("Error: " + ex.toString());
//        }

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
     * NOTICE: Using this in a method which returns a java.sql.ResultSet closes the set before returning
     */
    public void disconnect() {
        try {
            connection.close();
            System.out.println("disconnected");
        } catch (SQLException err) {
            System.err.println(err);
        }
    }

    /**
     * Returns all entries in the table
     * NOTICE: disconnect after using this method
     *
     * @param dbName    the name of the DB
     * @param tableName the name of the table
     * @return a java.sql.ResultSet of the entries in the table
     */
    public ResultSet findAll(String dbName, String tableName) {
        ResultSet result = null;

        connect(dbName);

        try {
            mStatement = connection.createStatement();

            String query = "SELECT * FROM " + tableName + ";";

            result = mStatement.executeQuery(query);

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            //would be null
            return result;
        }
    }

    /**
     * Inserts a new Java-Object into the database
     *
     * @param entity the object to insert
     */
    public abstract void insert(TYPE entity);


    /**
     * Updates an existing entity in the DB
     * IMPORTANT: always provide all attributes except from the primary key
     *
     * @param identifier the primary key
     * @param update     the entity with the new attributes
     */
    public abstract void update(KEY identifier, TYPE update);


    /**
     * Deletes an existing entity
     *
     * @param identifier the primary key
     */
    public abstract void delete(KEY identifier);

    /**
     * Searches an entity
     *
     * @param identifier the primary key
     * @return the result set
     * @throws SQLException
     */
    public abstract ResultSet search(KEY identifier) throws SQLException;
}
