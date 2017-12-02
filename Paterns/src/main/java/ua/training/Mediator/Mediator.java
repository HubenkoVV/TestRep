package ua.training.Mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    public static void main(String[] args){

        TextChat textChat = new TextChat();
        User admin = new Admin(textChat, "Vova");
        User user = new SimpleUser(textChat, "Vasya");
        User user1 = new SimpleUser(textChat, "Lera");
        user.setEnable(false);

        textChat.setAdmin(admin);
        textChat.addUser(user);
        textChat.addUser(user1);

        user1.sendMessage("Hi, i`m user " + user1.getName());
        admin.sendMessage("Hi, i`m admin " + admin.getName());

    }
}
//interface User{
//    void sendMessage(String message);
//    void getMessage(String message);
//}

abstract class User{
    private Chat chat;
    private String name;
    private boolean isEnable = true;

    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public boolean isEnable() {
        return isEnable;
    }

    void sendMessage(String message){
        chat.sendMessage(message, this);
    };
    abstract void getMessage(String message);
}

class Admin extends User{
    public Admin(Chat chat, String name) {
        super(chat, name);
    }

    public void getMessage(String message) {
        System.out.println("Admin " + getName() + " got message \"" + message + "\"");
    }
}

class SimpleUser extends User{
    public SimpleUser(Chat chat, String name) {
        super(chat, name);
    }

    public void getMessage(String message) {
        System.out.println("User " + getName() + " got message \"" + message + "\"");
    }
}
// class Admin implements User{
//    Chat chat;
//    public Admin(Chat chat) {
//        this.chat = chat;
//    }
//
//    @Override
//    public void sendMessage(String message) {
//        chat.sendMessage(message, this);
//    }
//
//    @Override
//    public void getMessage(String message) {
//        System.out.println("Admin got message \"" + message + "\"");
//    }
//}
//
//class SimpleUser implements User{
//    Chat chat;
//    public SimpleUser(Chat chat) {
//        this.chat = chat;
//    }
//
//    @Override
//    public void sendMessage(String message) {
//        chat.sendMessage(message, this);
//    }
//
//    @Override
//    public void getMessage(String message) {
//        System.out.println("User got message \"" + message + "\"");
//    }
//}

interface Chat{
    void sendMessage(String message, User user);
}

class TextChat implements Chat{
    User admin;
    List<User> userList = new ArrayList<>();

    void setAdmin(User admin){
        if(this.admin == null && admin instanceof Admin) {
            this.admin = admin;
        }
        else{
            System.out.println("Oops");
        }
    }
    void addUser(User u){
        if(admin != null && u instanceof SimpleUser) {
            userList.add(u);
        } else {
            System.out.println("Oops");
        }
    }

    @Override
    public void sendMessage(String message, User user) {
        if(user instanceof Admin) {
            userList.forEach(user1 -> user1.getMessage(message));
        }
        if(user instanceof SimpleUser){
            userList.forEach(user1 -> {
                if(user1.isEnable() && user1 != user)user1.getMessage(message);
            });
            if(admin.isEnable())
                admin.getMessage(message);
        }
    }
}
// class TextChat implements Chat{
//    User admin;
//    List<User> userList = new ArrayList<>();
//
//    void setAdmin(User admin){
//        this.admin = admin;
//    }
//    void addUser(User u){
//        userList.add(u);
//    }
//
//    @Override
//    public void sendMessage(String message, User user) {
//        userList.forEach(user1 -> user1.getMessage(message));
//        admin.getMessage(message);
//    }
//}