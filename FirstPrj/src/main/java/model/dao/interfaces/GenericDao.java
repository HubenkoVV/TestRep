package model.dao.interfaces;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    void create(T t);
    T findByID(int id);
    List<T> findAll();
    void update (T t);
    void delete(int id);
}
