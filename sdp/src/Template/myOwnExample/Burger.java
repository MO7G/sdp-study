package Template.myOwnExample;

public class Burger extends FastFoodTemplate{
    @Override
    public void prepare_ingredients(){
        System.out.println("Prepareing The Burger Ingredietns");
    }

    @Override
    public void cook_meal(){
        System.out.println("Cooking Burger");
    }
}
