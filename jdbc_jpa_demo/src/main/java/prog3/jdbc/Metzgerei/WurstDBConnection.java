package prog3.jdbc.Metzgerei;

import prog3.jdbc.GenericDBConnection;

import java.sql.ResultSet;

/**
 * Created by MichaelDick on 29/10/15.
 */
public class WurstDBConnection extends GenericDBConnection<Integer , Wurst> {
    @Override
    public void post(Wurst entity) {

    }

    @Override
    public void update(Integer identifier, Wurst update) {

    }

    @Override
    public void delete(Integer identifier) {

    }

    @Override
    public ResultSet search(Integer identifier) throws Exception {
        return null;
    }
}
