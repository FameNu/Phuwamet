package geometry;

public abstract class Shape {
    private final String color;
    public Shape(String color){
        this.color = color;
    }
    public abstract double getPerimeter();
    public abstract double getArea();
    public String getColor() {
        return color;
    }
}
// utility class