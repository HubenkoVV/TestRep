package model.dao.impl;

import model.dao.AbstractDao;
import model.dao.SeanceDao;
import model.entity.Film;
import model.entity.Seance;
import model.entity.proxy.SeanseProxy;

import java.sql.*;

public class SeanceDaoJDBC extends AbstractDao<Seance> implements SeanceDao{

    public SeanceDaoJDBC(Connection connection) {
        super(connection, "seance");
        columns = new String[]{"date","idFilm"};
        id = "idSeance";
    }

    @Override
    protected void setDataIntoStatement(Seance object, PreparedStatement statement) throws SQLException {
        statement.setTimestamp(1, Timestamp.valueOf(object.getDate()));
        statement.setInt(2, object.getIdFilm());
    }

    @Override
    protected Seance getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Seance.SeanceBuilder()
                .buildId(resultSet.getInt("idSeance"))
                .buildDate(resultSet.getTimestamp("date").toLocalDateTime())
                .buildIdFilm(resultSet.getInt("idFilm"))
                .build();
    }
}
