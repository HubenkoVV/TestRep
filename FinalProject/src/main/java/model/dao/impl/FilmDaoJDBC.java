package model.dao.impl;

import model.dao.AbstractDao;
import model.dao.FilmDao;
import model.dao.util.RequestBuilder;
import model.entity.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmDaoJDBC extends AbstractDao<Film> implements FilmDao{

    public FilmDaoJDBC(Connection connection) {
        super(connection, "film");
        columns = new String[]{"name","duration","genre","year"};
        id = "idFilm";
    }

    @Override
    public List<Film> findAll() {
        Film object;
        List<Film> resultList = new ArrayList<Film>();
        String request = new RequestBuilder()
                .select()
                .from()
                .table(nameOfTable)
                .build();
        try(PreparedStatement ps = connection.prepareStatement(request)){
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                if((object = getFromResultSet(rs)) != null)
                    resultList.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    protected void setDataIntoStatement(Film object, PreparedStatement statement) throws SQLException {
        statement.setString(1,object.getName());
        statement.setInt(2, object.getDuration());
        statement.setString(3, object.getGenre());
        statement.setInt(4, object.getYear());
    }

    @Override
    protected Film getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Film.FilmBuilder()
                .buildId(resultSet.getInt(id))
                .buildName(resultSet.getString("name"))
                .buildDuration(resultSet.getInt("duration"))
                .buildGenre(resultSet.getString("genre"))
                .buildYear(resultSet.getInt("year"))
                .build();
    }
}
