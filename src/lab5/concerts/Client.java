package lab5.concerts;

import com.sun.istack.internal.NotNull;

public class Client extends ProductionCenterEntity {
    public Client(@NotNull String name) {
        super(name);
    }

    public void orderPerformance(@NotNull String placeName,
                                 @NotNull String ... actorsNames){
        productionCenter.orderPerformance(name, placeName, actorsNames);
    }
}
