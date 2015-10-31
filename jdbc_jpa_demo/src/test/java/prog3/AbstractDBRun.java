package prog3;

import prog3.jdbc.Metzgerei.WurstDBConnection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 * We use this abstract class for providing a WurstConnection and an Entity Manager
 * to test both parts of the program
 */
public abstract class AbstractDBRun {

    //Needed for jdbc
    public static WurstDBConnection wurstDBConnection = new WurstDBConnection();

    //Needed for JPA
    //Create EntityManagerFactory
    public static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("jdbc_jpa_demo");

    //Create EntityManager
    public static EntityManager em = emf.createEntityManager();

}
