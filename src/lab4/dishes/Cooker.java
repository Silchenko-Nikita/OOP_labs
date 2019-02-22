package lab4.dishes;

public class Cooker {

    private String precookOperations(){
        return  "pick products\n" +
                "wash\n" +
                "cut\n";
    }

    public void cook(CookOperation operation1, CookOperation operation2){
        String recipeStr = precookOperations() +
                operation1.operation() + "\n"
                + operation2.operation() + "\n";
        System.out.println(recipeStr);
    }

    public void cook(CookRecipe recipe){
        String recipeStr = precookOperations() +
                recipe.handle() + "\n"
                + recipe.addon() + "\n";
        System.out.println(recipeStr);
    }
}
