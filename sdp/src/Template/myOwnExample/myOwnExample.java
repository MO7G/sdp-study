package Template.myOwnExample;

import javax.swing.plaf.basic.BasicOptionPaneUI;

public class myOwnExample {
    public static  void main(String args[]){
        FastFoodTemplate fastFood;

        // Prepare a Pizza
        fastFood = new Pizza();
        fastFood.prepare_food();

        System.out.println();

        // Prepare a Burger
        fastFood = new Burger();
        fastFood.prepare_food();
    }
}
