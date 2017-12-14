package model.dao;

import model.dao.interfaces.*;
import services.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    protected static String language;
    protected DaoFactory(String language){
        this.language = language;
    }

    public abstract TestDao createTestDao() throws ClassNotFoundException;
    public abstract QuestionDao createQuestionDao() throws ClassNotFoundException;
    public abstract AnswerDao createAnswerDao() throws ClassNotFoundException;

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            synchronized (DaoFactory.class){
                if(daoFactory == null){
                    daoFactory = new JDBCDaoFactory(language);
                }
            }
        }
        return daoFactory;
    }
}
