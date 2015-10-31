package prog3.jdbc;

import prog3.AbstractDBRun;

/**
 * Created by MichaelDick and Philipp Ratz on 31/10/15.
 */
public class FindWurstRun extends AbstractDBRun{
    public static void main(String[] args) {
        try {
            WurstDBRun.testFindAll();

            WurstDBRun.testSearch();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
