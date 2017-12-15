package model.dao.interfaces;

import model.entity.Question;

import java.util.List;

public interface QuestionDao extends GenericDao<Question> {
    List<Question> findAll(boolean sorted);
}
