package model.dao.datasourse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnection {

    public static DataSource getDataSource() {
        InitialContext initContext = null;
        try {
            initContext = new InitialContext();
            return  (DataSource) initContext.lookup("java:comp/env/jdbc/cinema");
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
