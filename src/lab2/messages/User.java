package lab2.messages;

import com.sun.istack.internal.NotNull;

public class User {
    private static int idCounter = 1;
    private int id = 0;
    private String name;
    private int rightsLevel = 0; // from 0 to 3 descending

    public User(@NotNull String name, int rightsLevel){
        if (rightsLevel < 0 || rightsLevel > 3){
            throw new IllegalArgumentException("rightsLevel must be from 0 to 3");
        }

        id = idCounter;
        idCounter += 1;
        this.name = name;
        this.rightsLevel = rightsLevel;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getRightsLevel() {
        return rightsLevel;
    }
}
