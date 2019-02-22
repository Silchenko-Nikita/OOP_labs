package lab5.concerts;

import com.sun.istack.internal.NotNull;

public abstract class ProductionCenterEntity {
    protected ProductionCenter productionCenter;
    protected String name;

    public ProductionCenterEntity(@NotNull String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
