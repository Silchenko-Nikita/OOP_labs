package lab5.concerts;

import com.sun.istack.internal.NotNull;

import java.util.Random;

public class Actor extends ProductionCenterEntity {
    public Actor(@NotNull String name) {
        super(name);
    }

    public boolean agreeToAct(@NotNull Place place){
        // may include logic with place

        Random random = new Random();
        return random.nextFloat() > 0.33;
    }
}
