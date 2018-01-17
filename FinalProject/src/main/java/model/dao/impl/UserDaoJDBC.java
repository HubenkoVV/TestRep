package model.dao.impl;

import model.dao.AbstractDao;
import model.dao.UserDao;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoJDBC extends AbstractDao<User> implements UserDao{

    public UserDaoJDBC(Connection connection) {
        super(connection, "user");
        columns = new String[]{"name","surname","login","password", "phone", "role", "money"};
        id = "idUser";
    }

    @Override
    protected void setDataIntoStatement(User object, PreparedStatement statement) throws SQLException {
        statement.setString(1,object.getName());
        statement.setString(2,object.getSurname());
        statement.setString(3,object.getLogin());
        statement.setInt(4,object.getPassword());
        statement.setString(5,object.getPhone());
        statement.setString(6,object.getRole());
        statement.setInt(7,object.getMoney());

    }

    @Override
    protected User getFromResultSet(ResultSet resultSet) throws SQLException {
        return new User.UserBuilder()
                .buildId(resultSet.getInt(id))
                .buildLogin(resultSet.getString("login"))
                .buildName(resultSet.getString("name"))
                .buildSurname(resultSet.getString("surname"))
                .buildPassword(resultSet.getInt("password"))
                .buildMoney(resultSet.getInt("money"))
                .buildRole(resultSet.getString("role"))
                .buildPhone(resultSet.getString("phone"))
                .build();
    }
}
