package lab2.messages;

import com.sun.istack.internal.NotNull;

public class LimitingMessageSender extends AbstractMessageSender{
    private MessageSender messageSender = new MessageSender();
    private int limitingRightsLevel = -1; // -1 = all users

    public LimitingMessageSender(int limitingRightsLevel){
        this.limitingRightsLevel = limitingRightsLevel;
    }

    @Override
    public void sendMessage(@NotNull User user, @NotNull String message) {

        if (limitingRightsLevel == -1 || user.getRightsLevel() <= limitingRightsLevel){
            messageSender.sendMessage(user, message);
        } else {
            throw new IllegalArgumentException("user " + user.getName() + " has no enough rights");
        }
    }
}
