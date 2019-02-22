package lab2.messages;

import com.sun.istack.internal.NotNull;

public class MessageSender extends AbstractMessageSender{

    @Override
    public void sendMessage(@NotNull User user, @NotNull String message) {
        System.out.println("Sending message '" + message + "' to " + user.getName());
    }
}
