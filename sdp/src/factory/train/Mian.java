package factory.train;


import javax.net.ssl.SSLHandshakeException;
import java.sql.SQLData;

interface Shape{
    void draw();
}

class Circle implements  Shape{
    @Override
    public void draw(){
        System.out.println("Drawing circle");
    }
}

class Triangle implements  Shape{
    @Override
    public void draw(){
        System.out.println("Drawing Triangle");
    }
}

class Square implements  Shape{
    @Override
    public void draw(){
        System.out.println("Drawing square");
    }
}


class ShapeFactory {

    public Shape getShape(String ShapeType){
        if(ShapeType == null){
            return null;
        }
        if(ShapeType.toLowerCase() == "circle"){
            return new Circle();
        }
        if(ShapeType.toLowerCase() == "square"){
            return new Square();
        }
        if(ShapeType.toLowerCase() == "triangle"){
            return new Triangle();
        }

        return null;
    }
}




public class Mian {
    public static void main(String args[]){
        ShapeFactory shape = new ShapeFactory();
        Shape firstShape = shape.getShape("circle");

        Shape secondShape = shape.getShape("triangle");
        Shape thirdShape = shape.getShape("square");
        firstShape.draw();
        secondShape.draw();
        thirdShape.draw();
    }
}
