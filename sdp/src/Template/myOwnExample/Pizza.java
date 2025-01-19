package Template.myOwnExample;

public class Pizza extends FastFoodTemplate{
    @Override
    public void prepare_ingredients(){
        System.out.println("Prepareing The Pizza Ingredietns");
    }

    @Override
    public void cook_meal(){
        System.out.println("Cooking Pizza");
    }
}
