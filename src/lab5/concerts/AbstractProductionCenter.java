package lab5.concerts;

import com.sun.istack.internal.NotNull;

abstract public class AbstractProductionCenter {
    public abstract void addActor(@NotNull Actor actor);
    public abstract void addClient(@NotNull Client client);
    public abstract void addPlace(@NotNull Place place);

    public abstract void orderPerformance(@NotNull String clientName, @NotNull String placeName,
                                          @NotNull String... actorsNames);
}
