package lab5.concerts;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductionCenter extends AbstractProductionCenter{
    private HashMap<String, Actor> actors = new HashMap<>();
    private HashMap<String, Client> clients = new HashMap<>();
    private HashMap<String, Place> places = new HashMap<>();

    @Override
    public void addActor(@NotNull Actor actor) {
        actors.put(actor.getName(), actor);
        actor.productionCenter = this;
    }

    @Override
    public void addClient(@NotNull Client client) {
        clients.put(client.getName(), client);
        client.productionCenter = this;
    }

    @Override
    public void addPlace(@NotNull Place place) {
        places.put(place.getName(), place);
        place.productionCenter = this;
    }

    @Override
    public void orderPerformance(@NotNull String clientName, @NotNull String placeName,
                                 @NotNull String ... actorsNames){
        Client client = clients.get(clientName);
        if (client == null){
            throw new IllegalArgumentException("no such client: " + clientName);
        }

        Place place = places.get(placeName);
        if (place == null){
            throw new IllegalArgumentException("no such place: " + placeName);
        }

        Actor[] actorsArray = new Actor[actorsNames.length];
        for (int i = 0; i < actorsNames.length; i++) {
            Actor actor = actors.get(actorsNames[i]);
            if (actor == null){
                throw new IllegalArgumentException("no such actor: " + actorsNames[i]);
            }

            actorsArray[i] = actor;
        }

        System.out.println("client " + client.getName() + " orders performance in " + place.getName());

        for (Actor actor: actorsArray){
            if (actor.agreeToAct(place)){
                System.out.println("actor " + client.getName() + " agrees to act at " + place.getName());
            }else {
                System.out.println("actor " + client.getName() + " refuses to act at " + place.getName());
            }
        }
    }
}
