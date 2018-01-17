package model.dao;

import model.entity.Seat;

import java.util.List;

public interface SeatDao extends GenericDao<Seat> {
    public List<Seat> findBySeance(int idSeance);
}
