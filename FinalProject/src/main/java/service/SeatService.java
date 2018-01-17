package service;

import model.dao.SeatDao;
import model.dao.factory.AbstractDaoFactory;
import model.entity.Seat;

import java.util.List;

public class SeatService {

    AbstractDaoFactory daoFactory = AbstractDaoFactory.getInstance();

    public List<Seat> getSeats(){
        try(SeatDao seatDao = daoFactory.createSeatDao()) {
            return seatDao.findAll();
        }
    }

//    public List<Seat> getSeatsOnSeance(int seance){
//        try(SeatDao seatDao = daoFactory.createSeatDao()){
//            return seatDao.findBySeance(seance);
//        }
//    }
}
