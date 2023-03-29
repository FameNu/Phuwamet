package geometry;

public final class Circle extends Shape{
    private final double radius;
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
