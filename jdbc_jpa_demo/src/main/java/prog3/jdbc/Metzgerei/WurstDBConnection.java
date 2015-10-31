package prog3.jdbc.Metzgerei;

import prog3.jdbc.GenericDBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
public class WurstDBConnection extends GenericDBConnection<Integer, Wurst> {


    @Override
    public void insert(Wurst entity) {
        //1. connect to db, with name 'wurstDB'
        connect("wurstDB");

        //surround insertion with try-catch
        try {
            //Use Prepared Statement for several parameters
            //Default Stement 'INSERT INTO $tablename ($c1 , $c2 , $c3 , $c4) VALUES (?,?,?,?)'
            mPreparedStatement = connection.prepareStatement("INSERT INTO wurst (plu , bezeichnung , kilopreis , kilobestand)" +
                    "VALUES (? , ? , ? , ?)");
            mPreparedStatement.setInt(1, entity.getPlu());
            mPreparedStatement.setString(2, entity.getBezeichnung());
            mPreparedStatement.setDouble(3, entity.getKilopreis());
            mPreparedStatement.setDouble(4, entity.getKilobestand());

            //Execute query
            mPreparedStatement.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException s) {
            System.out.println("Primary key already exists!");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //Dont forget to always disconnect after an operation
            disconnect();
        }


    }

    @Override
    public void update(Integer identifier, Wurst update) {
        //Only use non-id attributes since the primary key has to be unique
        String newBezeichnung = update.getBezeichnung();
        double newKilopreis = update.getKilopreis();
        double newKilobestand = update.getKilobestand();

        //connect to db
        connect("wurstDB");
        try {
            mPreparedStatement = connection.prepareStatement("UPDATE wurst SET bezeichnung = ?, kilopreis = ?, kilobestand = ? WHERE plu = ?");
            mPreparedStatement.setString(1 , newBezeichnung);
            mPreparedStatement.setDouble(2 , newKilopreis);
            mPreparedStatement.setDouble(3 , newKilobestand);

            mPreparedStatement.setInt(4 , identifier);

            mPreparedStatement.executeUpdate();
        }catch (SQLException s){
            s.printStackTrace();
        }finally {
            disconnect();
        }

    }

    @Override
    public void delete(Integer identifier) {
        connect("wurstDB");

        try {
            mPreparedStatement = connection.prepareStatement("DELETE FROM wurst WHERE plu = ?");
            mPreparedStatement.setInt(1 , identifier);

            mPreparedStatement.executeUpdate();
        }catch (SQLException s){
            s.printStackTrace();
        }finally {
            disconnect();
        }

    }

    /**
     * NOTICE: close connection after using this method
     * @param identifier the primary key
     * @return
     * @throws SQLException
     */
    @Override
    public ResultSet search(Integer identifier) throws SQLException {
        //We want to return an resultset, so we can print information out at the console
        ResultSet result;

        connect("wurstDB");

        mPreparedStatement = connection.prepareStatement("SELECT * FROM wurst WHERE plu = ?");
        mPreparedStatement.setInt(1 , identifier);

        result = mPreparedStatement.executeQuery();


        return result;
    }


    public void addToBestand(Integer identifier , Double amount){
        Wurst update = new Wurst();
        connect("wurstDB");

        try {
            ResultSet wurstFromDB = search(identifier);

            wurstFromDB.next();
            update.setBezeichnung(wurstFromDB.getString("bezeichnung"));
            update.setKilopreis(wurstFromDB.getDouble("kilopreis"));

            //add amount
            update.setKilobestand(wurstFromDB.getDouble("kilobestand") + amount);

            update(identifier , update);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    public void removeFromBestand(Integer identifier , Double amount){
        Wurst update = new Wurst();
        connect("wurstDB");

        try {
            ResultSet wurstFromDB = search(identifier);

            wurstFromDB.next();
            update.setBezeichnung(wurstFromDB.getString("bezeichnung"));
            update.setKilopreis(wurstFromDB.getDouble("kilopreis"));

            double bestand = wurstFromDB.getDouble("kilobestand") - amount;

            //add amount
            update.setKilobestand(bestand < 0 ? 0 : bestand);

            update(identifier , update);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }
}
