import geometry.*;
public class GeoTest {
    public static void main(String[] args) {
        Circle s = new Circle("Blue", 3.0);
        System.out.println("Color : " + s.getColor());
        System.out.println("Perimeter : " + s.getPerimeter());
        System.out.println("Area : " + s.getArea());
    }
}
