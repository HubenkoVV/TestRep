package model.dao.impl;

import model.dao.AbstractDao;
import model.dao.SeatDao;
import model.dao.util.RequestBuilder;
import model.entity.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDaoJDBC extends AbstractDao<Seat> implements SeatDao{

    public SeatDaoJDBC(Connection connection) {
        super(connection, "seat");
        columns = new String []{"number", "numberOfRow"};
        id = "idSeat";
    }

    @Override
    protected void setDataIntoStatement(Seat object, PreparedStatement statement) throws SQLException {
        statement.setInt(1,object.getNumber());
        statement.setInt(2, object.getNumberOfRow());
    }

    @Override
    protected Seat getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Seat.SeatBuilder()
                .buildId(resultSet.getInt(id))
                .buildNumber(resultSet.getInt("number"))
                .buildNumberOfRow(resultSet.getInt("numberOfRow"))
                .build();
    }

    @Override
    public List<Seat> findBySeance(int idSeance) {
        Seat object;
        List<Seat> resultList = new ArrayList<Seat>();
        String request = new RequestBuilder()
                .select()
                .from()
                .table(nameOfTable)
                .where()
                .condition("idSeanse")
                .build();
        try(PreparedStatement ps = connection.prepareStatement(request)){
            ps.setInt(1,idSeance);
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
}
