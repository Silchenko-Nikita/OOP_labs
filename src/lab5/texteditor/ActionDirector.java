package lab5.texteditor;

import com.sun.istack.internal.NotNull;

public class ActionDirector {
    protected ActionLogger logger;

    public void setLogger(@NotNull ActionLogger logger) {
        this.logger = logger;
    }

    public void insert(@NotNull int pos, @NotNull String text){
        if (logger != null) {
            logger.addAction(new InsertAction(pos, text));
        }
    }

    public void remove(@NotNull int pos, @NotNull int length){
        if (logger != null) {
            logger.addAction(new RemoveAction(pos, length));
        }
    }

    public String recover(@NotNull String text){
        if (logger != null) {
            return logger.recover(text);
        }
        return text;
    }

    public void clearLog(){
        if (logger != null) {
            logger.clear();
        }
    }
}
