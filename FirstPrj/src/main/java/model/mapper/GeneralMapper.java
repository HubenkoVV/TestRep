package model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GeneralMapper<T> {
    public T extractFromResultSet(ResultSet rs) throws SQLException;
}
