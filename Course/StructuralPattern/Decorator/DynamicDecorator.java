package Decorator;

public class DynamicDecorator {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        System.out.println(c1.info());

        ColouredShape blueSquare = new ColouredShape(new Square(20), "blue");
        System.out.println(blueSquare.info());

        var duo = new TransparentShape(new ColouredShape(new Circle(5), "green"), 50);
        System.out.println(duo.info());
    }
}

interface Shape {
    
    String info();
}

class Circle implements Shape {

    private float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public Circle() {}

    void resize(float factor) {
        radius *= factor;
    }

    @Override
    public String info() {
        return "Radius: " + radius;
    }
    
}

class Square implements Shape {
    private float side;

    public Square() {};
    public Square(float side) {
        this.side = side;
    }

    public void resize(float factor) {
        side *= factor;
    }

    @Override
    public String info() {
        return "Side: " + side;
    }
}

class ColouredShape implements Shape {

    private Shape shape;
    private String color;

    public ColouredShape(Shape shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public String info() {
        return shape.info() + " has color " + color;
    }
}

class TransparentShape implements Shape {

    private Shape shape;
    private int transparency;

    public TransparentShape(Shape shape, int transparency) {
        this.shape = shape;
        this.transparency = transparency;
    }

    @Override
    public  String info() {
        return shape.info() + " has transparency %" + transparency;
    }
}