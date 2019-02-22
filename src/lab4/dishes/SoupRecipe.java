package lab4.dishes;

public class SoupRecipe implements CookRecipe{

    @Override
    public String handle() {
        return "boil";
    }

    @Override
    public String addon() {
        return "soil";
    }
}
