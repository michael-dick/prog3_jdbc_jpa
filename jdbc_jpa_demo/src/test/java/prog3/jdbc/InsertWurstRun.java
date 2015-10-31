package prog3.jdbc;

import prog3.AbstractDBRun;
import prog3.jdbc.Metzgerei.Wurst;

/**
 * Created by MichaelDick on 31/10/15.
 */
public class InsertWurstRun extends AbstractDBRun{

    public static void main(String[] args) {

        Wurst nuernberger = new Wurst(004, "Nuernberger", 13.65, 101.6);

        wurstDBConnection.insert(nuernberger);


    }

}
