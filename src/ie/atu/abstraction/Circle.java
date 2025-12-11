package ie.atu.abstraction;

public class Circle extends Shape {
    private double radius;
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea(){
        double result = Math.PI * radius * radius;
        return result;
    }
}
