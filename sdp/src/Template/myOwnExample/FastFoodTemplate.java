package Template.myOwnExample;

public abstract class  FastFoodTemplate{

    public final void prepare_food(){
        take_order();
        prepare_ingredients();
        cook_meal();
        server_meal();
    }

    public final void take_order(){
        System.out.println("ordered is taken ");
    }
    public final void server_meal(){
        System.out.println("meal is served");
    }

    public abstract void prepare_ingredients();
    public abstract void cook_meal();
}
