package geometry;

public class Square extends Shape {
    private final double side;
    public Square(String color, double side){
        super(color);
        this.side = side;
    }
    @Override
    public double getPerimeter() {
        return side * 4.0;
    }
    @Override
    public double getArea() {
        return side * side;
    }
}
