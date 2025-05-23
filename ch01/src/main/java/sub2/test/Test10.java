package sub2.test;

interface Shape {
    public double calcArea(); // 빈칸
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double calcArea() {
        return width * height;
    }
}

public class Test10 {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.print("원 넓이 : ");
        System.out.println(circle.calcArea());
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.print("직사각형 넓이 : ");
        System.out.println(rectangle.calcArea());
    }
}