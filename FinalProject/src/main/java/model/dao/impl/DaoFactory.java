package model.dao.impl;

import model.dao.*;
import model.dao.datasourse.PoolConnection;
import model.dao.factory.AbstractDaoFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DaoFactory extends AbstractDaoFactory {

    DataSource dataSource = PoolConnection.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new UserDaoJDBC(getConnection());
    }

    @Override
    public SeatDao createSeatDao() {
        return new SeatDaoJDBC(getConnection());
    }

    @Override
    public TicketDao createTicketDao() {
        return new TicketDaoJDBC(getConnection());
    }

    @Override
    public FilmDao createFilmDao() {
        return new FilmDaoJDBC(getConnection());
    }

    @Override
    public SeanceDao createSeanceDao() {
        return new SeanceDaoJDBC(getConnection());
    }

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
