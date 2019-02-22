package lab2.messages;

import com.sun.istack.internal.NotNull;

abstract class AbstractMessageSender {

    public abstract void sendMessage(@NotNull User user, @NotNull String message);
}
