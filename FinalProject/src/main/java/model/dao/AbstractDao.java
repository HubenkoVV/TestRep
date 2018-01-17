package model.dao;

import model.dao.util.RequestBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDao<T> implements GenericDao<T> {

    protected Connection connection;
    protected String nameOfTable;
    protected String id;
    protected String [] columns;

    public AbstractDao(Connection connection, String nameOfTable) {
        this.connection = connection;
        this.nameOfTable = nameOfTable;
    }

    @Override
    public int create(T object) {
        String request = new RequestBuilder()
                .insertInto()
                .table(nameOfTable)
                .insertValues(columns)
                .build();
        try(PreparedStatement ps = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS)){
            setDataIntoStatement(object, ps);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            ps.close();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public T findById(int id) {
        String request = new RequestBuilder()
                .select()
                .from()
                .table(nameOfTable)
                .where()
                .condition(this.id)
                .build();
        try(PreparedStatement ps = connection.prepareStatement(request)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            ps.close();
            if(rs.next()) {
                return getFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        T object;
        List<T> resultList = new ArrayList<T>();
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
    public void update(T entity) {  }

    @Override
    public void delete(int id) {
        String request = new RequestBuilder()
                .delete()
                .from()
                .table(nameOfTable)
                .where()
                .condition(this.id)
                .build();
        try (PreparedStatement statement = connection.prepareStatement(request)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract void setDataIntoStatement(T object, PreparedStatement statement) throws SQLException;

    protected abstract T getFromResultSet(ResultSet resultSet) throws SQLException;
}
