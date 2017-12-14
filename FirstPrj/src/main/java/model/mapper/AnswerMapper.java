package model.mapper;

import model.entity.Answer;
import model.entity.Question;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class AnswerMapper implements GeneralMapper<Answer> {
    public Answer extractFromResultSet(ResultSet rs) throws SQLException {
        return new Answer.AnswerBuilder()
                .buildId(rs.getInt("idanswer"))
                .buildIdQuestion(rs.getInt("idtest"))
                .buildText(rs.getString("text_answer"))
                .buildRight(rs.getBoolean("right_answer"))
                .build();
    }

}
