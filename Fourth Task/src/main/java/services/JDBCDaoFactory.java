package services;

import model.dao.*;
import model.dao.interfaces.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    public JDBCDaoFactory(String language) {
        super(language);
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testing_db",
                "root",
                "root");
    }

    @Override
    public TestDao createTestDao() throws ClassNotFoundException {
        try {
            return new JDBCTestDao(getConnection(), language);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public QuestionDao createQuestionDao() throws ClassNotFoundException {
        try {
            return new JDBCQuestionDao(getConnection(), language);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AnswerDao createAnswerDao() throws ClassNotFoundException {
        try {
            return new JDBCAnswerDao(getConnection(), language);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
