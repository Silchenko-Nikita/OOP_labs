package lab2.messages;

import com.sun.istack.internal.NotNull;

import java.util.HashSet;

public class BulkMessageSender {
    private static HashSet<User> users = new HashSet<User>();

    public AbstractMessageSender getMessageSender() {
        return messageSender;
    }

    public void setMessageSender(@NotNull AbstractMessageSender messageSender) {
        this.messageSender = messageSender;
    }

    private AbstractMessageSender messageSender;

    public BulkMessageSender(@NotNull AbstractMessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void addUser(@NotNull User user) {
        users.add(user);
    }

    public void removeUser(@NotNull User user) {
        users.remove(user);
    }

    public void sendMessage(@NotNull String message){
        for(User user: users){
            try {
                messageSender.sendMessage(user, message);
            } catch (IllegalArgumentException ignored){}
        }
    }
}
