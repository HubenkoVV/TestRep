package model.entity;

import java.util.List;

public class Seat {
    private int id;
    private int number;
    private int numberOfRow;

    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfRow() {
        return numberOfRow;
    }

    public void setNumberOfRow(int numberOfRow) {
        this.numberOfRow = numberOfRow;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static final class SeatBuilder {
        private int id;
        private int number;
        private int numberOfRow;
        private List<Ticket> tickets;

        public SeatBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public SeatBuilder buildNumber(int number) {
            this.number = number;
            return this;
        }

        public SeatBuilder buildNumberOfRow(int numberOfRow) {
            this.numberOfRow = numberOfRow;
            return this;
        }

        public SeatBuilder buildTickets(List<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Seat build(){
            Seat seat = new Seat();
            seat.setId(id);
            seat.setNumber(number);
            seat.setNumberOfRow(numberOfRow);
            seat.setTickets(tickets);
            return seat;
        }
    }
}
