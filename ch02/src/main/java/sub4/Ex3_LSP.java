package sub4;

interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int width;
    private int height;

    public Square(int width) {
        this.width = width;
        this.height = width;
    }
    @Override
    public int getArea() {
        return width * height;
    }
}

public class Ex3_LSP {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5,10);
        resize(rect); // 예상: 넓이 증가

        Square square = new Square(5);
        resize(square); // 예상과 다르게 정사각형의 높이도 함께 증가
    }

    public static void resize(Shape shape) {
        System.out.println("Expected area = 50, Actual area = " + shape.getArea());
    }
}