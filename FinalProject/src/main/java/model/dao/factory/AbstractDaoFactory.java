package model.dao.factory;

import model.dao.*;
import model.dao.impl.DaoFactory;

public abstract class AbstractDaoFactory {

    private static AbstractDaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract SeatDao createSeatDao();
    public abstract TicketDao createTicketDao();
    public abstract FilmDao createFilmDao();
    public abstract SeanceDao createSeanceDao();

    public static AbstractDaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (AbstractDaoFactory.class){
                if(daoFactory==null){
                    AbstractDaoFactory temp = new DaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }

}
