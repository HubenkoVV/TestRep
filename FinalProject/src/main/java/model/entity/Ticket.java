package model.entity;

public class Ticket {
    private int id;
    private int idUser;
    private int idSeance;
    private int idSeat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(int idSeanse) {
        this.idSeance = idSeanse;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public static final class TicketBuilder {
        private int id;
        private int idUser;
        private int idSeance;
        private int idSeat;

        public TicketBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public TicketBuilder buildIdUser(int idUser) {
            this.idUser = idUser;
            return this;
        }

        public TicketBuilder buildIdSeance(int idSeance) {
            this.idSeance = idSeance;
            return this;
        }

        public TicketBuilder buildIdSeat(int idSeat) {
            this.idSeat = idSeat;
            return this;
        }

        public Ticket build(){
            Ticket ticket = new Ticket();
            ticket.setId(id);
            ticket.setIdSeance(idSeance);
            ticket.setIdSeat(idSeat);
            ticket.setIdUser(idUser);
            return ticket;
        }
    }
}
