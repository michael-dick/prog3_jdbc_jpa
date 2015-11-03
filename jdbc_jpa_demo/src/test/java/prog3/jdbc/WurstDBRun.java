package prog3.jdbc;

import org.junit.Test;
import prog3.AbstractDBRun;
import prog3.jdbc.Metzgerei.Wurst;
import prog3.jdbc.Metzgerei.WurstDBConnection;

import java.sql.ResultSet;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
public class WurstDBRun extends AbstractDBRun{

    @Test
    public static void testFindAll() throws Exception {

        ResultSet resultSet = wurstDBConnection.findAll("wurstDB", "wurst");

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("plu"));
            System.out.println(resultSet.getString("bezeichnung"));
            System.out.println(resultSet.getDouble("kilopreis"));
            System.out.println(resultSet.getDouble("kilobestand"));
            System.out.println("-----------------------------------");
        }
        wurstDBConnection.disconnect();

    }
    @Test
    public static void testSearch() throws Exception {
        ResultSet resultSet = wurstDBConnection.search(999);
        //We only have one result
        resultSet.next();

        System.out.println("-----------------------------------");
        System.out.println("Ulli's secret:");
        System.out.println(resultSet.getInt("plu"));
        System.out.println(resultSet.getString("bezeichnung"));
        System.out.println(resultSet.getDouble("kilopreis"));
        System.out.println(resultSet.getDouble("kilobestand"));
        System.out.println("-----------------------------------");

        wurstDBConnection.disconnect();
    }
    @Test
    public static void testInsert() throws Exception {
        Wurst nuernberger = new Wurst(004, "Nuernberger", 13.65, 101.6);

        wurstDBConnection.insert(nuernberger);

        testFindAll();
    }
    @Test
    public static void testUpdate() throws Exception {
        Wurst update = new Wurst();

        ResultSet oldWurst = wurstDBConnection.search(001);

        oldWurst.next();
        update.setBezeichnung("Wurstaufschnitt");
        update.setKilobestand(oldWurst.getDouble("kilobestand"));
        update.setKilopreis(oldWurst.getDouble("kilopreis"));

        wurstDBConnection.update(001, update);

        testFindAll();

    }

    @Test
    public static void testAddToBestand() throws Exception {
        wurstDBConnection.addToBestand(001, 25.4);

        ResultSet resultSet = wurstDBConnection.search(001);
        resultSet.next();

        System.out.println(resultSet.getInt("plu"));
        System.out.println(resultSet.getString("bezeichnung"));
        System.out.println(resultSet.getDouble("kilopreis"));
        System.out.println(resultSet.getDouble("kilobestand"));

    }

    public static void testDelete() {
        wurstDBConnection.delete(004);
    }


}
