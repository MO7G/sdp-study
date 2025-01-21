package Composite.myExampleWithoutIterator;

import java.util.ArrayList;
import java.util.List;

// Component
interface Graphic {
    void draw();
}

// Leaf
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Rectangle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Composite
class Group implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Group:");
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        // Individual shapes
        Graphic circle = new Circle();
        Graphic square = new Square();
        Graphic rectangle = new Rectangle();

        // Group of shapes
        Group Mastergroup = new Group();


        Group childGroup1 = new Group();
        Group childGroup2 = new Group();
        Group childGroup3 = new Group();

        childGroup1.add(circle);
        childGroup1.add(square);
        childGroup1.add(rectangle);


        childGroup2.add(circle);

        childGroup3.add(rectangle);
        childGroup3.add(square);


        Mastergroup.add(childGroup1);
        Mastergroup.add(childGroup2);
        Mastergroup.add(childGroup3);


        Mastergroup.draw();




    }
}
