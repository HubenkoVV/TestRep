package model.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Seance {
    private int id;
    private LocalDateTime date;
    private int idFilm;

    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static final class SeanceBuilder{
        private int id;
        private LocalDateTime date;
        private int idFilm;
        private List<Ticket> tickets;

        public SeanceBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public SeanceBuilder buildDate(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public SeanceBuilder buildIdFilm(int idFilm) {
            this.idFilm = idFilm;
            return this;
        }

        public SeanceBuilder buildTickets(List<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Seance build(){
            Seance seance = new Seance();
            seance.setId(id);
            seance.setDate(date);
            seance.setIdFilm(idFilm);
            seance.setTickets(tickets);
            return seance;
        }
    }
}

