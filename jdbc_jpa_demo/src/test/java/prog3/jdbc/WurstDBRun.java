package prog3.jdbc;

import org.junit.Test;
import prog3.jdbc.Metzgerei.Wurst;
import prog3.jdbc.Metzgerei.WurstDBConnection;

import java.sql.ResultSet;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
public class WurstDBRun {

    /**
     * We use the jUnit framework to seperately run queries
     * No more information at this point since jUnit is another topic in the seminar
     */
    WurstDBConnection connection = new WurstDBConnection();


    @Test
    public void testFindAll() throws Exception {

        ResultSet resultSet = connection.findAll("wurstDB", "wurst");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("plu"));
            System.out.println(resultSet.getString("bezeichnung"));
            System.out.println(resultSet.getDouble("kilopreis"));
            System.out.println(resultSet.getDouble("kilobestand"));
            System.out.println("-----------------------------------");
        }
        connection.disconnect();

    }

    @Test
    public void testSearch() throws Exception {
        ResultSet resultSet = connection.search(999);
        //We only have one result
        resultSet.next();

        System.out.println("-----------------------------------");
        System.out.println("Ulli's secret:");
        System.out.println(resultSet.getInt("plu"));
        System.out.println(resultSet.getString("bezeichnung"));
        System.out.println(resultSet.getDouble("kilopreis"));
        System.out.println(resultSet.getDouble("kilobestand"));
        System.out.println("-----------------------------------");

        connection.disconnect();
    }

    @Test
    public void testInsert() throws Exception {
        Wurst nuernberger = new Wurst(004, "Nuernberger", 13.65, 101.6);

        connection.insert(nuernberger);

        testFindAll();
    }

    @Test
    public void testUpdate() throws Exception {
        Wurst update = new Wurst();

        ResultSet oldWurst = connection.search(001);

        oldWurst.next();
        update.setBezeichnung("Wurstaufschnitt");
        update.setKilobestand(oldWurst.getDouble("kilobestand"));
        update.setKilopreis(oldWurst.getDouble("kilopreis"));

        connection.update(001, update);

        testFindAll();

    }


    @Test
    public void testAddToBestand() throws Exception {
        connection.addToBestand(001, 25.4);

        ResultSet resultSet = connection.search(001);
        resultSet.next();

        System.out.println(resultSet.getInt("plu"));
        System.out.println(resultSet.getString("bezeichnung"));
        System.out.println(resultSet.getDouble("kilopreis"));
        System.out.println(resultSet.getDouble("kilobestand"));

    }

    @Test
    public void testDelete() throws Exception {
        connection.delete(004);
    }


}
