package model.mapper;

import model.entity.Test;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class TestMapper implements GeneralMapper<Test> {
    public Test extractFromResultSet(ResultSet rs) throws SQLException {
        return new Test.TestBuilder()
                .buildId(rs.getInt("idtest"))
                .buildTopic(rs.getString("topic"))
                .build();
    }

    public Test makeUniqueTest(Set<Test> tests, ResultSet rs) throws SQLException {
        Test test = extractFromResultSet(rs);
        tests.add(test);
        return tests.stream().filter(item -> item.getId() == test.getId()).findFirst().get();
    }
}
