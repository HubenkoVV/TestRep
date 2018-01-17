package model.dao.impl;

import model.dao.AbstractDao;
import model.dao.TicketDao;
import model.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDaoJDBC extends AbstractDao<Ticket> implements TicketDao{

    public TicketDaoJDBC(Connection connection) {
        super(connection, "ticket");
        columns = new String[]{"idUser", "idSeance", "idSeat"};
    }

    @Override
    protected void setDataIntoStatement(Ticket object, PreparedStatement statement) throws SQLException {
        statement.setInt(1,object.getIdUser());
        statement.setInt(2, object.getIdSeance());
        statement.setInt(3, object.getIdSeat());
    }

    @Override
    protected Ticket getFromResultSet(ResultSet resultSet) throws SQLException {
        return new Ticket.TicketBuilder()
                .buildId(resultSet.getInt(id))
                .buildIdSeance(resultSet.getInt("idSeance"))
                .buildIdSeat(resultSet.getInt("idSeat"))
                .buildIdUser(resultSet.getInt("idUser"))
                .build();
    }
}
