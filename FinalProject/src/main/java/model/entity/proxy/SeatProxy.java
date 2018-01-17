package model.entity.proxy;

import model.entity.Seat;
import model.entity.Ticket;

import java.util.List;

public class SeatProxy extends Seat{
    @Override
    public List<Ticket> getTickets() {
        return super.getTickets();
    }
}
