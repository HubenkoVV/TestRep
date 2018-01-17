package model.entity;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String surname;
    private String login;
    private int password;
    private String phone;
    private String role;
    private int money;

    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static final class UserBuilder{
        private int id;
        private String name;
        private String surname;
        private String login;
        private int password;
        private String phone;
        private String role;
        private int money;
        private List<Ticket> tickets;

        public UserBuilder buildId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder buildName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserBuilder buildLogin(String login) {
            this.login = login;
            return this;
        }

        public UserBuilder buildPassword(int password) {
            this.password = password;
            return this;
        }

        public UserBuilder buildPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder buildTickets(List<Ticket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public UserBuilder buildRole(String role) {
            this.role = role;
            return this;
        }

        public UserBuilder buildMoney(int money) {
            this.money = money;
            return this;
        }

        public User build(){
            User user = new User();
            user.setId(id);
            user.setLogin(login);
            user.setName(name);
            user.setPassword(password);
            user.setPhone(phone);
            user.setSurname(surname);
            user.setTickets(tickets);
            user.setRole(role);
            user.setMoney(money);
            return user;
        }
    }
}
