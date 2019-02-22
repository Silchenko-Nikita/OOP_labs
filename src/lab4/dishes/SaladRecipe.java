package lab4.dishes;

public class SaladRecipe implements CookRecipe{

    @Override
    public String handle() {
        return "mix";
    }

    @Override
    public String addon() {
        return "pepper";
    }
}
