package ie.atu.abstraction;

public class Square extends Shape{
    private double length;
    public Square(String input, double length) {
        super(input);
        this.length=length;
    }

    @Override
    public double getArea() {
        double result = length*length;
        return result;
    }
}
