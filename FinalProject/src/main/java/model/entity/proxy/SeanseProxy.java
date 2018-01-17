package model.entity.proxy;

import model.entity.Seance;
import model.entity.Ticket;

import java.util.List;

public class SeanseProxy extends Seance{
    @Override
    public List<Ticket> getTickets() {
        return super.getTickets();
    }
}
