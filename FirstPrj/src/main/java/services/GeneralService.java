package services;

import model.dao.interfaces.GenericDao;
import model.entity.Answer;

import java.util.ArrayList;
import java.util.List;

public abstract class GeneralService<T> {

    List<T> listOfElements = new ArrayList<>();
    GenericDao jdbcDao;

    public List<T> getListOfElements() {
        return listOfElements;
    }

    public void delete(int id){
        jdbcDao.delete(id);
        makeList();
    }

    public T getById(int id){
        return (T)jdbcDao.findByID(id);
    }

    void makeList(){
        listOfElements = jdbcDao.findAll();
    }

}
