package dbutility;

import java.sql.Connection;

public interface DBUtilityInter {

    public abstract Connection connect() throws Exception;

    public abstract void close(Connection connection);

}
